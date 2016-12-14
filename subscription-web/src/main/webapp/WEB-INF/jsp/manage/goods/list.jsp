<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 2016/12/12
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nchu.weixin.subscription.enums.OperateEnum" %>
<html>
<head>
    <title>商品列表</title>
    <%@include file="../../common/include.jsp"%>
    <script type="text/javascript">
        function sendOperate(goodsId, operate) {
            $.get('${ctx}/manage/goods/operate',
                    {goodsId:goodsId,operate:goodsId}, function (data) {
                        alert(data.msg);
                    });
        }
    </script>
</head>
<body>
    <div class="container-fluid">
        <h1 class="page-header">商品列表</h1>
        <form class="form-inline" name="searchForm" method="post", role="form">
            <div class="row">
                <div class="form-group">
                    <label class="control-label text-right" for="goodsName">商品名:</label>
                    <input type="text" class="form-control text-left" id="goodsName" value="${goodsName}">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">查询</button>
                    <a href="${ctx}/manage/goods/create" class="btn btn-success">添加商品</a>
                </div>
            </div>
        </form>
        <h2></h2>
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>编号</th>
                        <th>名称</th>
                        <th>描述</th>
                        <th>价格</th>
                        <th>销量</th>
                        <th>状态</th>
                        <th>添加时间</th>
                        <th>最近修改</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <td>${gs.id}</td>
                    <td>${gs.goodsName}</td>
                    <td>${gs.goodsDesc}</td>
                    <td>${gs.goodsPrice}</td>
                    <td>${gs.saleCount}</td>
                    <td>${gs.status}</td>
                    <td>${gs.createdTime}</td>
                    <td>${gs.modifedTime}</td>
                    <td>
                        <a href="${ctx}/#" class="btn btn-primary">修改</a>
                        <button class="btn btn-primary" onclick="sendOperate(${gs.id}, ${OperateEnum.RELEASE.value}})">${OperateEnum.RELEASE.desc}</button>
                        <button class="btn btn-primary" onclick="sendOperate(${gs.id}, ${OperateEnum.REBACK.value}})">${OperateEnum.REBACK.desc}</button>
                        <button class="btn btn-primary" onclick="sendOperate(${gs.id}, ${OperateEnum.UNSHELVE.value}})">${OperateEnum.UNSHELVE.desc}</button>
                        <a href="${ctx}/#" class="btn btn-danger">删除</a>
                    </td>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
