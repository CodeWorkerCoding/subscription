<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 2016/12/12
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nchu.weixin.subscription.enums.GoodsStatusEnum" %>
<%@ page import="com.nchu.weixin.subscription.enums.GoodsTypeEnum" %>
<html>
<head>
    <title>更新一个商品</title>
    <%@include file="../../common/include.jsp"%>
</head>
<body>
    <div class="container-fluid">
        <div class="page-header">
            <h1>更新一个商品信息</h1>
        </div>
        <div class="pager">
            <form class="form-horizontal" role="form">
                <input type="hidden" name="id" value="${gs.id}">
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsName">商品名</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="text" class="form-control" id="goodsName" name="goodsName" placeholder="商品名" value="${gs.goodsName}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsPrice">商品价格</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="number" class="form-control" id="goodsPrice" name="goodsName" placeholder="商品价格" value="${gs.goodsPrice}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsType">商品类型</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <select class="form-control" id="goodsType" name="goodsType">
                            <option value="">--指定商品类型--</option>
                            <c:forEach items="${GoodsTypeEnum.values()}" var="gtp">
                                <option value="${gtp.value}" <c:if test="${gs.goodsType == gtp}">selected</c:if>>${gtp.desc}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="status">商品状态</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <select class="form-control" id="status" name="status">
                            <option value="">--指定商品状态--</option>
                            <c:forEach items="${GoodsStatusEnum.values()}" var="gst">
                                <option value="${gst.value}" <c:if test="${gs.status == gst}">selected</c:if>>${gst.desc}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsDesc">商品描述</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <textarea class="form-control" placeholder="商品描述" id="goodsDesc" name="goodsDesc"
                                  style="margin: 0px -65px 0px 0px; width: 396px; height: 188px;">"${gs.goodsDesc}"</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodMainImg">商品主图片</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="file" class="form-control" id="goodMainImg" name="goodMainImg" placeholder="商品图片">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-3 col-md-3 col-md-offset-2">
                        <button type="reset" class="btn btn-danger">清除所有</button>
                        <button type="submit" class="btn btn-primary">修改</button>
                        <a href="javascript:history.back(-1);" class="btn btn-default">返回</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
