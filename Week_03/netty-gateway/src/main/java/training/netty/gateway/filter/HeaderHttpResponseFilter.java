package training.netty.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * 响应头过滤器
 *
 * @author ping.zhang
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response, String addr) {
        //测试用
        response.headers().set("response-address", addr);
    }
}
