package training.okhttp;


import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.Charset;

public class OkHttpDemo {
    private static final String url = "http://localhost:8088/api/hello";

    public static OkHttpClient client = new OkHttpClient();


    public static void main(String[] args) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        //同步获取
        Response response = call.execute();
        System.out.println("同步请求响应数据：" + response.body().string());
        //异步
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                System.out.println("执行失败：" + e.getMessage());
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                System.out.println("异步请求响应数据：" + response.body().string());
//            }
//        });

    }

}
