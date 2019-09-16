package com.xy.study.http;


public class HttpForm {
//
//    private static HttpContext localContext = new BasicHttpContext();
//    private static HttpClientContext context = HttpClientContext
//            .adapt(localContext);
//
//    public static void main(String[] args) throws Exception {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        try {
//            // 模拟表单
//            List<NameValuePair> params = new ArrayList<NameValuePair>();
//            params.add(new BasicNameValuePair("username", "**"));
//            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
//            HttpPost httpPost = new HttpPost("http://localhost:8080/spiderweb/RirectServlet");
//            httpPost.setEntity(entity);
//
//            // 将HttpClientContext传入execute()中
//            CloseableHttpResponse response = httpClient.execute(httpPost, context);
//            try {
//                HttpEntity responseEntity = response.getEntity();
//                System.out.println(EntityUtils.toString(responseEntity));
//
//            } finally {
//                response.close();
//            }
//        } finally {
//            httpClient.close();
//        }
//
//    }
}