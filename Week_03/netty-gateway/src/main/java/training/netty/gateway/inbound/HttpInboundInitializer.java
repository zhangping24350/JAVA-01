package training.netty.gateway.inbound;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import training.netty.gateway.filter.HeaderHttpRequestFilter;
import training.netty.gateway.filter.HeaderHttpResponseFilter;
import training.netty.gateway.handler.HttpRequestHandler;
import training.netty.gateway.outbound.EncryptionOutBoundHandler;
import training.netty.gateway.router.RandomHttpEndpointRouter;

import java.util.Arrays;
import java.util.List;


/**
 * 初始化handler
 *
 * @author ping.zhang
 */
public class HttpInboundInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();

        //Http解码器 HttpServerCodec是无法完全的解析Http POST请求
        p.addLast(new HttpServerCodec());
        //HttpObjectAggregator可以解码POST body 中的参数
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        //添加自己的handler
        List<String> serverAddress = Arrays.asList("http://127.0.0.1:8088", "http://127.0.0.1:8089");
        HttpRequestHandler requestHandler =
                new HttpRequestHandler(serverAddress,
                        new RandomHttpEndpointRouter(),
                        new HeaderHttpResponseFilter());
        HttpInboundHandler httpInboundHandler = new HttpInboundHandler()
                .setHttpRequestHandler(requestHandler)
//                .addFilter(new AuthorizationHttpRequestFilter())
                .addFilter(new HeaderHttpRequestFilter());

        p.addLast(httpInboundHandler);
        //此处有不清楚为什么不进去这个Handler的write()
        p.addFirst(new EncryptionOutBoundHandler());
    }
}
