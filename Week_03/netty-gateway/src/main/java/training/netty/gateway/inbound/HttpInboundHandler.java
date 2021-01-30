package training.netty.gateway.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import training.netty.gateway.filter.HttpRequestFilter;
import training.netty.gateway.handler.HttpRequestHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的Handler
 *
 * @author ping.zhang
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private List<HttpRequestFilter> filters = null;
    private HttpRequestHandler requestHandler = null;

    public HttpInboundHandler() {
        this.filters = new ArrayList<>();
    }

    public HttpInboundHandler addFilter(HttpRequestFilter filter) {
        this.filters.add(filter);
        return this;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest httpRequest = (FullHttpRequest) msg;
        //只是简单的按顺序执行filter
        for (HttpRequestFilter filter : filters) {
            filter.filter(httpRequest, ctx);
        }
        //处理请求
        requestHandler.handler(ctx, msg);
    }

    public HttpInboundHandler setHttpRequestHandler(HttpRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
        return this;
    }

}
