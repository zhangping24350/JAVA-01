package training.netty.gateway.filter;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;

import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static org.springframework.http.HttpHeaders.CONNECTION;

/**
 * TODO
 *
 * @author ping.zhang
 */
@Slf4j
public class AuthorizationHttpRequestFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest request, ChannelHandlerContext ctx) {
        //模拟认证处理
        String authorization = request.headers().get("Authorization");
        this.checkAuthorization(request, ctx, authorization);
    }

    private void checkAuthorization(FullHttpRequest request, ChannelHandlerContext ctx, String authorization) {
        boolean nullOrEmpty = StringUtil.isNullOrEmpty(authorization);

        //模拟有权限直接返回
        if (!nullOrEmpty) {
            return;
        }
        //无权限响应请求403
        try {
            String value = "无对应访问权限";
            FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.FORBIDDEN, Unpooled.wrappedBuffer(value.getBytes("UTF-8")));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", response.content().readableBytes());
            ctx.write(response).addListener(ChannelFutureListener.CLOSE);
        } catch (Exception e) {
            log.error("处理认证出错：" + e);
        }

    }
}

