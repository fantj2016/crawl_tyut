<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/ch-ui.admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/font/css/font-awesome.min.css">
</head>
<style type="text/css">
    .crumb_warp i {
        font-size: 30px;
    }
</style>
<body style="background:#F3F3F4;">
<div class="crumb_warp">
    <i class="fa fa-home"></i><a href="${pageContext.request.contextPath}/index.jsp" style="font-size: 25px">返回登录页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>

<style type="text/css">
    input[type='submit'], input[type='button'] {
        padding: 0 25px;
        height: 113px;
        width: 200px;
        vertical-align: middle;
        margin-right: 10px;
        color: #fff;
        letter-spacing: 2px;
        border-radius: 3px;
        background: #337ab7;
        border: 1px solid #286090;
        cursor: pointer;
    }
</style>

<div class="result_wrap">
    <div style='text-align:center'>
        <p>欢迎访问,<%=session.getAttribute("username")%>,祝福你考个好成绩</p>
    </div>
    <div style='text-align:center'>
    <form method="post" action="${pageContext.request.contextPath}/select/code.do">
        <input type="submit" value="成绩查询">
    </form>
    </div>
<br>

    <div style='text-align:center'>
    <form method="post" action="${pageContext.request.contextPath}/select/classtable.do">
        <input type="submit" value="课表查询">
    </form>
    </div>


</div>
</body>
</html>
