package training.httpclient;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class HttpClientDemo {
    private static final String url = "http://localhost:8088/api/hello";

    private static HttpClient httpClient;

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

    public static void main(String[] args) throws IOException {
        HttpClientDemo httpClientDemo = new HttpClientDemo();
        httpClientDemo.doGet();
//        httpClientDemo.doPost();
    }

    private void doGet() throws IOException {
        //发送GET无参请求
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        System.out.println("请求响应状态：" + response.getStatusLine());
        System.out.println("请求响应数据：" + EntityUtils.toString(entity, "UTF-8"));
    }

    private void doPost() throws IOException {
        HttpPost httpPost = new HttpPost(url);
        //设置请求头
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        //构造请求参数
        UserInfo userInfo = new UserInfo("zhang", "test@qq.com");
        String value = new ObjectMapper().writeValueAsString(userInfo);
        httpPost.setEntity(new StringEntity(value, Charset.forName("UTF-8")));
        //发送请求
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        System.out.println("请求响应状态：" + response.getStatusLine());
        System.out.println("请求响应数据：" + EntityUtils.toString(entity, "UTF-8"));
    }


    class UserInfo {
        private String name;
        private String email;

        public UserInfo(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
