<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="${ctx}/static/shenma.ico" rel="shortcut icon" />
<title>微信订阅号商品销售管理系统</title>
    <%--set ctx var value--%>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="${ctx}/static/plugin/bootstrap/css/bootstrap.min.css">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link rel="stylesheet" href="${ctx}/static/plugin/bootstrap/ext/ie10-viewport-bug-workaround.css" >
    <link rel="stylesheet" href="${ctx}/static/css/login.css" >
    <!-- JavaScript -->
    <script src="${ctx}/static/js/jquery.min.js"></script>
    <script src="${ctx}/static/plugin/bootstrap/js/bootstrap.min.js" ></script>
    <!-- MD5 -->
    <%--<script type="text/javascript" src="${ctx}/static/js/md5.js"></script>--%>
    <script type="text/javascript">
    /*function encode() {
        var pwd = $('#j_password').val();
        $('#j_password').val(hex_md5(pwd));
        $('#loginForm').submit();
    }*/
    </script>
</head>

<body>
<div id="login-page">
  <div class="container">
    <form class="form-signin" id="loginForm" action="/login" method="post" >
    	<h2 class="form-signin-heading">请登录</h2>
    	<label for="j_username" class="sr-only">用户名</label>
        <input type="text" id="j_username" name='username' class="form-control" placeholder="用户名" autofocus>
        <label for="j_password" class="sr-only">密码</label>
        <input type="password" id="j_password" name='password' class="form-control" placeholder="密码">
        <c:if test="${error != null || error !=''}"><h4 class="text-danger">${error }</h4></c:if>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><i class="fa"></i>登  录</button>
    </form>
  </div>
</div>

</body>
</html>
