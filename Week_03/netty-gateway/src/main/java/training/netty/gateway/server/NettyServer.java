package training.netty.gateway.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import training.netty.gateway.inbound.HttpInboundHandler;
import training.netty.gateway.inbound.HttpInboundInitializer;

@Data
@Slf4j
public class NettyServer {

    private Integer port;

    public NettyServer(Integer port) {
        this.port = port;
    }

    public void run() throws InterruptedException {
        //bossGroup 负责处理socket连接
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);


        //   workGroup 复制处理数据读写
        //   默认创建核心的2倍的线程
        //   nThreads == 0 ? DEFAULT_EVENT_LOOP_THREADS : nThreads
        //   DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));

        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        //启动引导
        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap
                //服务端将不能处理的客户端连接请求放在队列中等待处理，backlog参数指定了队列的大小
                .option(ChannelOption.SO_BACKLOG, 128)
                //TCP_NODELAY选项是用来控制是否开启Nagle算法
                .childOption(ChannelOption.TCP_NODELAY, true)
                //通信两端即client server之间超过一定时间（默认的心跳间隔是7200s即2小时）没有数据交换 keepalive 的一端自动发送一个 packet
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                //套接字复用端口
                .childOption(ChannelOption.SO_REUSEADDR, true)
//                .childOption(EpollChannelOption.SO_REUSEPORT, true)
                //发送缓冲区
                .childOption(ChannelOption.SO_SNDBUF, 64 * 1024)
                //接收缓冲区
                .childOption(ChannelOption.SO_RCVBUF, 64 * 1024)
                //Netty参数，ByteBuf的分配器(重用缓冲区)，默认值为ByteBufAllocator.DEFAULT，
                // 4.0版本为UnpooledByteBufAllocator，4.1版本为PooledByteBufAllocator
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

        bootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                //设置日志
                .handler(new LoggingHandler(LogLevel.DEBUG))
                //初始化必要的Handler
                .childHandler(new HttpInboundInitializer());

        Channel ch = bootstrap.bind(port).sync().channel();
        log.debug(String.format("Netty Server 启动 ,监听地址：http://127.0.0.1:%s/", port));
        ch.closeFuture().sync();
    }
}
