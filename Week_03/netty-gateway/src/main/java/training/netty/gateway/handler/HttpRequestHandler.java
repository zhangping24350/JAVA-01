package training.netty.gateway.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import training.netty.gateway.filter.HttpResponseFilter;
import training.netty.gateway.router.HttpEndpointRouter;

import java.io.IOException;
import java.util.List;

import static io.netty.handler.codec.http.HttpMethod.*;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * 自定义的Handler
 *
 * @author ping.zhang
 */
@Slf4j
public class HttpRequestHandler {

    private List<String> serverAddress;

    private HttpEndpointRouter router;

    private static HttpClient httpClient;

    private HttpResponseFilter filter;

    static {
        // 配置信息
        RequestConfig requestConfig = RequestConfig.custom()
                // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true)
                .build();

        httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

    public HttpRequestHandler(List<String> serverAddress, HttpEndpointRouter router, HttpResponseFilter filter) {
        this.serverAddress = serverAddress;
        this.router = router;
        this.filter = filter;
    }

    public void handler(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest httpRequest = (FullHttpRequest) msg;
        HttpMethod method = httpRequest.method();
        String address = router.route(serverAddress);
        final String url = address + httpRequest.uri();
        HttpResponse httpResponse = null;
        if (GET.equals(method)) {
            httpResponse = doGet(httpRequest, url);
        } else if (POST.equals(method)) {
            httpResponse = doPost(url);
        } else if (method.equals(PUT)) {
            httpResponse = doPut(url);
        }
        this.handleResponse(address, ctx, httpResponse);
    }

    private void handleResponse(String address, ChannelHandlerContext ctx, HttpResponse httpResponse) {
        FullHttpResponse response = null;

        try {
            byte[] byteArray = EntityUtils.toByteArray(httpResponse.getEntity());
            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(byteArray));

            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", Integer.parseInt(httpResponse.getFirstHeader("Content-Length").getValue()));

            filter.filter(response, address);
            ctx.write(response).addListener(ChannelFutureListener.CLOSE);
            ctx.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private HttpResponse doGet(FullHttpRequest httpRequest, String url) throws IOException {
        //发送GET无参请求
        HttpGet httpGet = new HttpGet(url);
        String testCase = httpRequest.headers().get("TestCase");
        httpGet.addHeader("TestCase", testCase);
        HttpResponse response = httpClient.execute(httpGet);

        return response;
    }

    private HttpResponse doPost(String url) throws IOException {
        return null;
    }

    private HttpResponse doPut(String url) throws IOException {
        return null;
    }
}
