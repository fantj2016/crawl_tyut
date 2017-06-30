package com.laojiao.tools;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * Created by dell on 2017/06/15.
 * 抓取信息
 */
public class crawl {
    protected String crawl(String url) throws Exception{
        //try with resource  语法，自动关闭流
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            try (CloseableHttpResponse closeableHttpResponse = httpClient.execute(new HttpGet(url))) {
                /**Get mothed */
                HttpGet httpGet = new HttpGet(url);
                DefaultHttpClient httpclient=new DefaultHttpClient();
                CookieStore cookie = httpclient.getCookieStore();
//                Header[] cookie = httpGet.getHeaders("Cookie");
                String result = EntityUtils.toString(closeableHttpResponse.getEntity(), "utf8");
                return String.valueOf(cookie);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}