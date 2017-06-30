<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/06/18
  Time: 02:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/ch-ui.admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/font/css/font-awesome.min.css">
    <link rel="script" href="${pageContext.request.contextPath}/style/js/jquery.js">

</head>
<style type="text/css">
    .login_box h1 {
        text-align: center;
        color: #ba9e9e;
        font-size: 91px;
        margin: 50px 0 10px 0;
        font-weight: normal;
    }
    input[type='text'], input[type='password'] {
        width: 200px;
        margin-right: 5px;
        padding: 6px 5px;
        line-height: 12px;
        font-size: 12px;
    }
</style>
<body style="background:#F3F3F4;">

<div class="login_box">
    <div class="result_wrap">
        <div class="result_content">
            <h1>成绩查询</h1>
            <h2>太理学生专用</h2>
            <h2 style="color: red">${message}</h2>
            <div style='text-align:center'>
                <form action="${pageContext.request.contextPath}/admin/login.do" method="post" onsubmit="return check()">
                    学号：<input type="text" name="username" class="text" placeholder="学号/201500xxxx" id="username"/>
                    <br><br>
                    密码：<input type="password" name="password" class="text" placeholder="xxxxxx" id="password"/>
                    <br><br><br>
                    <center><input onclick="return checkNull()" type="submit" value="登录" id="submit"></center>
                </form>
                <br><br><br><br><br><br><br><br><br>
                <p> &copy; 2017 Powered by <br><a href="#" target="_blank">SuperJohn</a></p>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function check(){
        var name = document.getElementById("username").value.trim();
        var passwd = document.getElementById("password").value.trim();
        if(name ==  null || name == ''){
            if(passwd == null || passwd ==""){
                alert("请输入您的账号密码");
                return false;
            }
            else {
                alert("请输入您的账号");
            }
        }
        if(name != null ||name != ""){
            if(passwd ==null || passwd == ""){
                alert("请输入您的密码");
                return false;
            }
        }
        return true;
    }

</script>
</body>
</html>
