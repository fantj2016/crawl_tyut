package com.laojiao.junit;

import com.laojiao.tools.GetCheckCode;
import com.laojiao.tools.sendGet;
import com.laojiao.tools.sendPost;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Super.John on 2017/06/16.
 */
public class Test {
    @org.junit.Test
    /**验证码获取*/
    public void test() throws Exception {
        GetCheckCode getCheckCode = new GetCheckCode();
        //vmLogin_tyut.login();
        double r = new Random().nextDouble();
        System.out.println(r);
        //getCheckCode.getCheckCode("http://202.207.247.49/validateCodeAction.do?random="+ r,r+"laojiao.jpg");
    }
    @org.junit.Test
    public void getCheckPreGetCookie()throws  Exception{

    }
    @org.junit.Test
    /***成绩查询*/
    public void test2() throws IOException {
        sendGet sendGet = new sendGet();
        String result = sendGet.sendGetCodeTable("JSESSIONID=cgb6woNaXgj0igCpPK7Yv");
        Document doc = Jsoup.parse(result);
        Elements codeTable = doc.select(".titleTop2");
        System.out.println(codeTable);
    }
    @org.junit.Test
    /**课表查询*/
    public void test3() throws IOException {
        sendGet sendGet = new sendGet();
        String result = sendGet.sendGetClassTable("JSESSIONID=2572ECDAE12A91C3A066F3F0FADD3C2F");
        Document doc = Jsoup.parse(result);
        Elements codeTable = doc.select(".titleTop2");
        System.out.println(codeTable);
    }
    /**Cookie获取*/
    @org.junit.Test
    public void testCookie() throws IOException {
        String url = "http://202.207.247.49/loginAction.do";
        String cookiePre = String.valueOf(Jsoup.connect(url).execute().cookies());
        String cookie = cookiePre.replace("{","").replace("}","");
        System.out.println(cookie);
    }
    /**post登录前的准备*/
    @org.junit.Test
    public void testPost() throws IOException {
        sendPost sendPost = new sendPost();
        String cookiePre = String.valueOf(Jsoup.connect("http://202.207.247.49/loginAction.do").execute().cookies());
        String cookie = cookiePre.replace("{","").replace("}","");
        //获取验证码
        String result = sendPost.sendPost(cookie);
        System.out.println(cookie);
        System.out.println(result);
    }
    /***正式登录*/
    @org.junit.Test
    public void testPost2() throws IOException {
        sendPost sendPost = new sendPost();
//        String url = "http://202.207.247.49/loginAction.do";
//        String cookiePre = String.valueOf(Jsoup.connect(url).execute().cookies());
//        String cookie = cookiePre.replace("{","").replace("}","");
 //       sendPost.sendPost("2016006569","283116","V4ra",cookie);
    }

    @org.junit.Test
    public void testLoginRank() throws IOException {
        String url = "http://202.207.247.60/";
        String cookiePre = String.valueOf(Jsoup.connect(url).execute().cookies());
        String cookie = cookiePre.replace("{","").replace("}","");
        System.out.println("%E7%84%A6%E5%B8%86%E6%8C%BA;"+cookie);

    }
/**=============================================测试   排名=========================***/
@org.junit.Test
    public void testRank() throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet("http://202.207.247.60/Pages/Cj/Xyyj/Xsgrcj.aspx");
    httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
    httpGet.setHeader("Accept-Encoding","gzip, deflate, sdch");
    httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.8");
    httpGet.setHeader("Cookie","ASP.NET_SessionId=cwy0mpiemzri412gem4n12ay; UserID=79819; UserName=2016006569; TrueName=%E7%84%A6%E5%B8%86%E6%8C%BA; ProjectId=1; Tel=; Roles=24; Xsh=16; Xqh=01\t");
    httpGet.setHeader("Host","202.207.247.60");
    httpGet.setHeader("Proxy-Connection","keep-alive");
    httpGet.setHeader("Referer","http://202.207.247.60/Default.aspx");
    httpGet.setHeader("Upgrade-Insecure-Requests","1");
    httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");

    CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
    String result = EntityUtils.toString(httpResponse.getEntity(),"utf8");
    Document doc = Jsoup.parse(result);
    Elements elements = doc.select(".bootstrap-table");
    System.out.println(elements);

}

@org.junit.Test
    public void testPostRank()throws IOException {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost("http://202.207.247.60/Hander/Cj/CjAjax.ashx?rnd%20=%200.7642697889180316");

   // System.out.println("请输入验证码");
    //String checkCode = scanner.next();
    List<BasicNameValuePair> formParams = new ArrayList<>();
    formParams.add(new BasicNameValuePair("limit", "40"));
    formParams.add(new BasicNameValuePair("offset", "0"));
    formParams.add(new BasicNameValuePair("order", "asc"));
    formParams.add(new BasicNameValuePair("sort", "jqzypm,xh"));
    formParams.add(new BasicNameValuePair("do", "xsgrcj"));
    formParams.add(new BasicNameValuePair("xh", "2016006569"));
    httpPost.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
    httpPost.setHeader("Accept-Encoding", "gzip, deflate");
    httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
    httpPost.setHeader("Connection", "keep-alive");
    httpPost.setHeader("Content-Length","68");
    httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");
    httpPost.setHeader("Cookie", "ASP.NET_SessionId=cwy0mpiemzri412gem4n12ay; UserID=79819; UserName=2016006569; TrueName=%E7%84%A6%E5%B8%86%E6%8C%BA; ProjectId=1; Tel=; Roles=24; Xsh=16; Xqh=01");
    httpPost.setHeader("Host", "202.207.247.60");
    httpPost.setHeader("Origin", "http://202.207.247.60");
    httpPost.setHeader("Referer", "http://202.207.247.60/Pages/Cj/Xyyj/Xsgrcj.aspx");
    httpPost.setHeader("X-Requested-With", "XMLHttpRequest");
    httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formParams, "utf8");
    httpPost.setEntity(formEntity);
    //System.out.println("executing request: " + httpPost.getURI());
    //执行post请求
    CloseableHttpResponse response = httpclient.execute(httpPost);
    HttpEntity entity = response.getEntity();
    String resultPre = EntityUtils.toString(entity, "utf8");
    Document doc = Jsoup.parse(resultPre);
    System.out.println(doc);
    //String result = doc.select(".errorTop").text();
    response.close();
    httpclient.close();
}
}
