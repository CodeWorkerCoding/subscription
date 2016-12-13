<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
    <%@ taglib prefix="sec" uri="http://www.springframework.org/tags" %>
    使用
    <div> username : <sec:authentication property="name"/></div>
--%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>微信订阅号商品销售管理系统</title>
<link href="${ctx}/static/shenma.ico" rel="shortcut icon" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="${ctx}/static/plugin/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/plugin/bootstrap/css/bootstrap-theme.min.css" >
<link rel="stylesheet" href="${ctx}/static/plugin/bootstrap/ext/ie10-viewport-bug-workaround.css">
<link rel="stylesheet" href="${ctx}/static/css/dashboard.css">
<link rel="stylesheet" href="${ctx}/static/css/style.css">

<!-- Latest compiled and minified JavaScript -->
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/plugin/bootstrap/js/bootstrap.min.js" ></script>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-header">
         <a class="navbar-brand" href="#">微信订阅号商品销售管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right" style="margin-right: 0;">
                <li><a href="#">${cus}</a></li>
                <li><a href="${ctx}/#">修改密码</a></li>
                <li><a href="${ctx}/login?logout">退出</a></li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid" >
      <div class="row">
      	<aside class="col-sm-3 col-md-2 sidebar">
      		<%@ include file="common/left.jsp"%>
      	</aside>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

        	<iframe id="mainFrame" name="mainFrame"  onload="initFrame(this);"></iframe>
      	</div>
      </div>
    </div>
    <div class="footer"></div>

<script>
    function initFrame($this){
        var height=500;
        try{
            height=$this.contentWindow.document.body.scrollHeight;
            if(height<500){
                height=$(window).height()-50;
            }
        }catch (e){
        }
        $this.style.height =height+'px';
    }
</script>
</body>
</html>
