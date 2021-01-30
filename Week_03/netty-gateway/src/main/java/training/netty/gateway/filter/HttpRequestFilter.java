package training.netty.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.logging.Filter;

/**
 * Http请求过滤器
 *
 * @author ping.zhang
 */
public interface HttpRequestFilter {

    /**
     * 请求过滤
     *
     * @param request
     * @param ctx
     */
    void filter(FullHttpRequest request, ChannelHandlerContext ctx);


}
