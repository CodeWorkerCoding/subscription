<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 2016/12/12
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nchu.weixin.subscription.enums.GoodsTypeEnum" %>
<html>
<head>
    <title>添加一个商品</title>
    <%@include file="../../common/include.jsp"%>
</head>
<body>
    <div class="container-fluid">
        <div class="page-header">
            <h1>添加一个商品信息</h1>
        </div>
        <div class="pager">
            <form class="form-horizontal" role="form" action="" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsName">商品名</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="text" class="form-control" required id="goodsName" name="goodsName" placeholder="商品名" value="${gs.goodsName}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsPrice">商品价格</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="text" class="form-control" required id="goodsPrice" name="goodsPrice" placeholder="商品价格" value="${gs.goodsPrice}">
                        <%--<span class="input-group-addon col-sm-1 col-md-1">元</span>--%>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsType">商品类型</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <select class="form-control" id="goodsType" name="goodsType" required>
                            <option value="">--指定商品类型--</option>
                            <c:forEach items="${GoodsTypeEnum.values()}" var="gtp">
                                <option value="${gtp.value}" <c:if test="${gs.goodsType == gtp}">selected</c:if>>${gtp.desc}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsDesc">商品描述</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <textarea class="form-control" placeholder="商品描述" id="goodsDesc" name="goodsDesc" value="${gs.desc}"></textarea>
                        <%--<input type="" class="form-control" id="goodsDesc" name="goodsDesc" placeholder="商品名">--%>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodMainImg">商品主图片</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="file" class="form-control" id="goodMainImg" required name="iconImg" placeholder="商品图片">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-3 col-md-3 col-md-offset-2">
                        <%--<button type="reset" class="btn btn-danger _confirm" data-confirm="确定清除所有信息？">清除所有</button>--%>
                        <button type="reset" class="btn btn-danger" onclick="javascript:confirm('确定清除所有信息？')">清除所有</button>
                        <button type="submit" class="btn btn-primary">添加</button>
                        <a href="javascript:void(0);" class="btn btn-default" onclick="javascript:history.back(-1)">返回</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
