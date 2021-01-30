package training.netty.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * 响应过滤器
 *
 * @author ping.zhang
 */
public interface HttpResponseFilter {

    void filter(FullHttpResponse response, String addr);

}
