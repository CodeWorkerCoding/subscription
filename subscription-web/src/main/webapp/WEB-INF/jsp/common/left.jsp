<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${ctx}/static/plugin/accordion.js"></script>
<script>
    $(function(){
        $(".nav").accordion({
            //accordion: true,
            speed: 500,
            closedSign: '<i class="glyphicon glyphicon-chevron-right"></i>',
            openedSign: '<i class="glyphicon glyphicon-chevron-down"></i>'
        });
    });
</script>
<style>
    ul.nav ul {display: none;padding-left:0;list-style:none}
    ul.nav ul li{border-bottom:1px solid #eee;}
    ul.nav li a{color:#666;}
    ul.nav li a:hover {background-color:#428bca;color:white;}
    ul.nav ul li a { display: block;padding: 10px 10px 10px 30px;background-color: #fff;color:#333;text-decoration: none;}
    ul.nav ul li a:hover {background-color:#eff0f1;color:#666;}
    ul.nav ul ul li a {color:silver; padding-left: 40px;}
    ul.nav ul ul li a:hover { background-color:#D3CEB8; color:#675C7C;}
    ul.nav span{float:right;}
</style>

<ul class="nav nav-sidebar">

    <li><a href="#">商品管理</a>
        <ul>
            <li><a href="${ctx}/manage/goods/list" target="mainFrame">商品列表</a></li>
        </ul>
    </li>
    <li><a href="#">订单管理</a>
        <ul>
            <li><a href="${ctx}/manage/order/list" target="mainFrame">订单列表</a></li>
        </ul>
    </li>

	<%--
    <li><a href="#">产品管理</a>
        <ul>
            <li><a href="/product/list" target="mainFrame">产品列表</a></li>
        </ul>
    </li>
    <li><a href="#">信息管理</a>
        <ul>
            <li><a href="/fund/list" target="mainFrame">资金方管理</a></li>
            <li><a href="/rate/list" target="mainFrame">费率管理</a></li>
            <!--
            <li><a href="javascript:void(0)" target="mainFrame">结算方式管理</a></li>
            <li><a href="javascript:void(0)" target="mainFrame">放款配置</a></li>
            -->
            <li><a href="/bank/list" target="mainFrame">银行配置</a></li>
        </ul>
    </li>
    <li><a href="#">账务管理</a>
        <ul>
        	<!--
            <li><a href="javascript:void(0)" target="mainFrame">还款对账</a></li>
            -->
            <li><a href="/trade/list" target="mainFrame">交易管理</a></li>
            <!--
            <li><a href="javascript:void(0)" target="mainFrame">结算管理</a></li>
            <li><a href="javascript:void(0)" target="mainFrame">放款对账</a></li>
            <li><a href="javascript:void(0)" target="mainFrame">代扣对账</a></li>
            <li><a href="javascript:void(0)" target="mainFrame">手续费结算</a></li>
             -->
        </ul>
    </li>
    <li><a href="#">任务管理</a>
        <ul>
            <li class="active"><a href="/timer/list" target="mainFrame">定时计划</a></li>
            <li><a href="/timerlog/list" target="mainFrame">定时器执行日志</a></li>
        </ul>
    </li>
    <li><a href="#">系统监控</a>
        <ul>
        	<li class="active"><a href="${ctx}/trade/monitor" target="mainFrame">贷款监控</a></li>
            <li class="active"><a href="${ctx}/queue/list" target="mainFrame">队列监控</a></li>
        </ul>
    </li>
	--%>
    <%--<c:forEach items="${menuSet }" var="top">
        <c:forEach items="${top.menuItems }" var="menu">
        <li><a href="#">${menu.name}</a>
            <ul>
                <c:forEach items="${menu.menuItems }" var="item">
                    <li><a href="${item.url}" target="mainFrame">${item.name}</a></li>
                </c:forEach>
            </ul>
        </li>
        </c:forEach>
    </c:forEach>--%>
</ul>
