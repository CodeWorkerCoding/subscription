<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 2016/12/12
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单列表</title>
    <%@include file="../../common/include.jsp"%>
</head>
<body>
<div class="container-fluid">
    <h1 class="page-header">订单列表</h1>
    <form class="form-inline" name="searchForm" method="post", role="form">
        <div class="row">
            <div class="form-group">
                <label class="control-label" for="goodsName"></label>
                <input type="text" class="form-control" id="goodsName" value="${goodsName}">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">查询</button>
                <%--<a href="${ctx}/#" class="btn btn-success">添加商品</a>--%>
            </div>
        </div>
    </form>
    <h2></h2>
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>订单编号</th>
                <th>客户编号</th>
                <th>订单总额</th>
                <th>商品数量</th>
                <th>状态</th>
                <th>生成时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <td>${ord.id}</td>
            <td>${ord.custId}</td>
            <td>${ord.orderCost}</td>
            <td>${ord.goodsCount}</td>
            <td>${ord.status.desc}</td>
            <td>${ord.createdTime}</td>
            <td>
                <a href="${ctx}/#" class="btn btn-primary">修改</a>
                <a href="${ctx}/#" class="btn btn-danger">删除</a>
            </td>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
