package com.laojiao.tools;

import net.sourceforge.tess4j.Tesseract;
import org.jsoup.Jsoup;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 给我一个验证码连接，自动识别验证码并返回
 * Created by Super.John on 2017/06/17.
 */
public class GetCheckCode {
    public void getCheckCodePre() throws IOException {
        String cookiePre = String.valueOf(Jsoup.connect("http://202.207.247.49/loginAction.do").execute().cookies());
        String cookie = cookiePre.replace("{","").replace("}","");
        //getCheckCode();
    }
    public String getCheckCode(String urlString,String filename,String cookieId) throws Exception {

        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        con.addRequestProperty("Cookie", cookieId);
        con.addRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        con.addRequestProperty("Accept-Encoding","gzip, deflate, sdch");
        con.addRequestProperty("Accept-Language","zh-CN,zh;q=0.8");
        con.addRequestProperty("Connection","keep-alive");
        con.addRequestProperty("Host","202.207.247.49");
        con.addRequestProperty("Upgrade-Insecure-Requests","1");
        con.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        File f =new File("usr/imageCheck");
        f.mkdirs();

        /**localhost test*/
         //输出的文件流
//        OutputStream os = new FileOutputStream("D:\\imageCheck" + filename);
//        // 开始读取
//        while ((len = is.read(bs)) != -1) {
//            os.write(bs, 0, len);
//        }
//        File imageFile = new File("D:\\imageCheck" + filename);
//        Tesseract instance = new Tesseract();
//        instance.setDatapath("D:\\IdeaProjects\\LoL\\tessdata");

        /**aliyun test ========start===========*/
        OutputStream os = new FileOutputStream("C:\\imageCheck" + filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        File imageFile = new File("C:\\imageCheck" + filename);
        Tesseract instance = new Tesseract();
        instance.setDatapath("C:\\tessdata");
        /**aliyun test ========end===========*/
//                OutputStream os = new FileOutputStream("/usr/imageCheck" + filename);
//        // 开始读取
//        while ((len = is.read(bs)) != -1) {
//            os.write(bs, 0, len);
//        }
//        File imageFile = new File("/usr/imageCheck" + filename);
//        Tesseract instance = new Tesseract();
//        instance.setDatapath("/usr/tessdata/tessdata");

        //将验证码图片的内容识别为字符串
        String checkCode = instance.doOCR(imageFile);
        //System.out.print("获取到的验证码为！！"+checkCode);
        System.out.print(checkCode);
        // 完毕，关闭所有链接
        os.close();
        is.close();
        imageFile.delete();
        return checkCode;
    }
}
