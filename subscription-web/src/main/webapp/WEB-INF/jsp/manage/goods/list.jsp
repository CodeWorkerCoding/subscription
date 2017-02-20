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
    <%@include file="../../common/include.jsp" %>
    <script type="text/javascript">
        function sendOperate(goodsId, operate) {
            $.get('${ctx}/manage/goods/operate',
                    {goodsId: goodsId, operate: operate}, function (data) {
                        alert(data.msg);
                    });
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <h1 class="page-header">商品列表</h1>
    <form name="searchForm" id="searchForm" role="form" method="post">
        <div class="form-inline">
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
        </div>
        <h2></h2>
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>描述</th>
                    <th>价格</th>
                    <th>类型</th>
                    <th>销量</th>
                    <th>状态</th>
                    <th>添加时间</th>
                    <th>最近修改</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${gds}" var="gs">
                    <td>${gs.goodsNo}</td>
                    <td>
                        <a href="${ctx}/manage/goods/${gs.id}/info">${gs.goodsName}</a>
                    </td>
                    <td>${gs.goodsDesc}</td>
                    <td>${gs.goodsPrice}</td>
                    <td>${gs.goodsType.desc}</td>
                    <td>${gs.saleCount}</td>
                    <td>${gs.status.desc}</td>
                    <td>${gs.createdTime}</td>
                    <td>${gs.modifiedTime}</td>
                    <td>
                        <a href="${ctx}/manage/goods/${gs.id}/modify" class="btn btn-primary">修改</a>
                        <button class="btn btn-primary"
                                onclick="sendOperate(${gs.id}, ${OperateEnum.RELEASE.value}})">${OperateEnum.RELEASE.desc}</button>
                        <button class="btn btn-primary"
                                onclick="sendOperate(${gs.id}, ${OperateEnum.REBACK.value}})">${OperateEnum.REBACK.desc}</button>
                        <button class="btn btn-primary"
                                onclick="sendOperate(${gs.id}, ${OperateEnum.UNSHELVE.value}})">${OperateEnum.UNSHELVE.desc}</button>
                        <a href="${ctx}/#" class="btn btn-danger">删除</a>
                    </td>
                </c:forEach>
                </tbody>
            </table>
            <%@include file="../../common/page.jsp" %>
        </div>
    </form>
</div>
</body>
</html>
