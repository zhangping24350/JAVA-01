package training.netty.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.internal.StringUtil;

/**
 * TODO
 *
 * @author ping.zhang
 */
public class HeaderHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest request, ChannelHandlerContext ctx) {
        //header 添加属性
        request.headers().set("TestCase", "netty-gateway");
    }
}
