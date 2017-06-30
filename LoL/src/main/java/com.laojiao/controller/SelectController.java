package com.laojiao.controller;

import com.laojiao.model.ClassInfo;
import com.laojiao.model.CodeInfo;
import com.laojiao.model.User;
import com.laojiao.service.ClassService;
import com.laojiao.service.CodeService;
import com.laojiao.tools.sendGet;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 查询成绩和课表
 * Created by Super.John on 2017/06/18.
 */
@RestController
@RequestMapping("/select")
public class SelectController {
    @Autowired
    CodeService codeService;
    @Autowired
    ClassService classService;
    @RequestMapping("/code")
    public ModelAndView selectCode(HttpSession session) throws IOException {
        String cookieId = (String) session.getAttribute("cookie");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("codeShow");
        sendGet sendGet = new sendGet();
        String resultPre = sendGet.sendGetCodeTable(cookieId);
        String result = resultPre.replace("displayTag","list_tab");
        Document doc = Jsoup.parse(result);
        Elements codeTable = doc.select(".titleTop2");
        if (codeTable != null)
        System.out.println("成绩查询成功");
        else System.out.println("成绩查询为空");
 //       classInfo.setClassTable(codeTable.toString());
        //取出与用户相关联的ID
//        classService.
//        classInfo.setId();
//        classService.insertClassInfo(classInfo);
        //System.out.println(codeTable);

        mv.addObject("codeTable",codeTable);
        return mv;
    }
    @RequestMapping("/classtable")
    public ModelAndView selectClassTable(HttpSession session) throws IOException {
        String cookieId = (String) session.getAttribute("cookie");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("classTable");
        sendGet sendGet = new sendGet();
        String resultPre = sendGet.sendGetClassTable(cookieId);
        String result = resultPre.replace("displayTag","list_tab")
                .replace("<th align=\"center\" width=\"100\" class=\"sortable\">&nbsp;大纲日历</th> ","")
                .replace("<td rowspan=\"1\" align=\"center\"> <img src=\"/img/icon/calendar.jpg\" style=\"cursor: hand;\" title=\"大纲日历\" onclick=\"CxJxDgRl(this)\" name=\"actionType=6&amp;oper=QueryDgRl&amp;kch=00007002&amp;kxh=332\" /></td> ","");
        Document doc = Jsoup.parse(result);
        Elements classTable = doc.select(".titleTop2");
        if (classTable != null)
            System.out.println("课表查询成功!");
        else System.out.println("课表查询为空!");
        mv.addObject("classTable",classTable);
//        codeInfo.setCodeTable(classTable.toString());
//        codeService.insertCodeTable(codeInfo);
        return mv;
    }

}
