package com.laojiao.controller;

import com.laojiao.model.User;
import com.laojiao.service.impl.UserServiceImpl;
import com.laojiao.tools.sendPost;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Super.John on 2017/06/17.
 */
@RestController
@RequestMapping("/admin")
public class LoginController {
    User user = new User();
    @Autowired
    UserServiceImpl userService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session
    ) throws IOException {
        ModelAndView mv = new ModelAndView();
        sendPost sendPost = new sendPost();
        String cookieId = (String) session.getAttribute("cookie");
        //String cookieId = user.getCookieId();
        String checkCode = sendPost.sendPost(cookieId);
        String result = String.valueOf(sendPost.sendPost(username, password, checkCode, cookieId));
        user.setUsername(username);
        user.setPassword(password);
        if (result.contains("你输入的验证码错误，请您重新输入！")) {
            for (int i = 0; i < 20; i++) {
                String checkCode2Pre = sendPost.sendPost(cookieId);
                String checkCode2 = checkCode2Pre.substring(0, 4);
                String result2 = String.valueOf(sendPost.sendPost(username, password, checkCode2, cookieId));
                if (result2.contains("你输入的验证码错误，请您重新输入！"))
                    continue;
                else if (result2.contains("您的密码不正确，请您重新输入！")){
                    mv.addObject("message","请您输入正确的帐号密码");
                    mv.setViewName("login");
                    return mv;
                }else
                    System.out.println(result2 + "登录成功");
                    break;
            }
        }
        mv.setViewName("main");
        mv.addObject("cookieId", cookieId);
        mv.addObject("username", username);
        session.setAttribute("username",username);
        System.out.println(username + "对应的cookie :" +cookieId+"对应的checkCode :"+checkCode);
       // userService.addUser(user);
        return mv;
    }

    @RequestMapping("/loginPre")
    public ModelAndView loginPre(HttpServletRequest request, HttpSession session) throws IOException {
        ModelAndView mv = new ModelAndView("login");
        //sendPost sendPost = new sendPost();
        /**拿到cookie存到数据库*/
        String cookiePre = String.valueOf(Jsoup.connect("http://202.207.247.49/loginAction.do").execute().cookies());
        String cookie = cookiePre.replace("{", "").replace("}", "");
        //String checkCode = sendPost.sendPost(cookie);
        session = request.getSession();
        session.setAttribute("cookie",cookie);
        user.setCookieId(cookie);
        return mv;
    }

    @RequestMapping("/logintest")
    public ModelAndView loginIn() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
}
