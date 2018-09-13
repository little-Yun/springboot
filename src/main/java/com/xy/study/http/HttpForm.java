package com.xy.study.http;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class HttpForm {

    private static HttpContext localContext = new BasicHttpContext();
    private static HttpClientContext context = HttpClientContext
            .adapt(localContext);

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            // 模拟表单
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", "**"));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
            HttpPost httpPost = new HttpPost("http://localhost:8080/spiderweb/RirectServlet");
            httpPost.setEntity(entity);

            // 将HttpClientContext传入execute()中
            CloseableHttpResponse response = httpClient.execute(httpPost, context);
            try {
                HttpEntity responseEntity = response.getEntity();
                System.out.println(EntityUtils.toString(responseEntity));

            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }

    }
}