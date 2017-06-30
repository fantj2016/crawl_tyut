<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/06/18
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/ch-ui.admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/font/css/font-awesome.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/style/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/style/js/ch-ui.admin.js"></script>
</head>
<style type="text/css">
    .crumb_warp i {
        font-size: 30px;
    }
</style>
<body>
<div class="crumb_warp">
    <i class="fa fa-home"></i> <a onclick="history.go(-1)" style="font-size: 25px">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>

<!--结果页快捷搜索框 开始-->
<!-- <div class="search_wrap"> -->
<!-- <form action="" method="post"> -->
<!-- <table class="search_tab"> -->
<!-- <tr> -->
<!-- <th width="120">小说查询:</th> -->

<!-- <th width="70">关键字:</th> -->
<!-- <td><input type="text" name="keywords" placeholder="关键字"></td> -->
<!-- <td><input type="submit" name="sub" value="查询"></td> -->
<!-- </tr> -->
<!-- </table> -->
<!-- </form> -->
<!-- </div> -->
<div class="result_wrap">
    <div class="result_content">
    ${codeTable}
</body>
</html>
