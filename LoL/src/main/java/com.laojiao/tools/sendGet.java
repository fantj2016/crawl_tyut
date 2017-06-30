package com.laojiao.tools;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * 获取成绩查询页面
 * Created by Super.John on 2017/06/17.
 */
public class sendGet {
    public String sendGetCodeTable(String cookieId) throws IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://202.207.247.49/gradeLnAllAction.do?type=ln&oper=qbinfo");
            httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            httpGet.setHeader("Accept-Encoding","gzip, deflate, sdch");
            httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.8");
            httpGet.setHeader("Connection","keep-alive");
            httpGet.setHeader("Cookie", cookieId);
            httpGet.setHeader("Host","202.207.247.49");
            httpGet.setHeader("Referer","http://202.207.247.49/gradeLnAllAction.do?type=ln&oper=fa");
            httpGet.setHeader("Upgrade-Insecure-Requests","1");
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            String result = EntityUtils.toString(httpResponse.getEntity(), "gb2312");
            return result;
        }
        //http://202.207.247.49/xkAction.do?actionType=6
        public String sendGetClassTable(String cookieId) throws IOException{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://202.207.247.49/xkAction.do?actionType=6");
            httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            httpGet.setHeader("Accept-Encoding","gzip, deflate, sdch");
            httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.8");
            httpGet.setHeader("Connection","keep-alive");
            httpGet.setHeader("Cookie", cookieId);//@17d0685f
//            httpGet.setHeader("Cookie","17d0685f");
            httpGet.setHeader("Host","202.207.247.49");
            httpGet.setHeader("Referer","http://202.207.247.49/gradeLnAllAction.do?type=ln&oper=fa");
            httpGet.setHeader("Upgrade-Insecure-Requests","1");
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            String result = EntityUtils.toString(httpResponse.getEntity(), "gb2312");

            //System.out.println("Response content: " +result);
            return result;
        }
    }

