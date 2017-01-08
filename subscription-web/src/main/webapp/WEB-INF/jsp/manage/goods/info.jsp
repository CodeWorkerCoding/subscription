<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 2016/12/12
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <%@include file="../../common/include.jsp"%>
</head>
<body>
    <div class="container-fluid">
        <div class="page-header">
            <h1>商品详情</h1>
        </div>
        <div class="pager">
            <div class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsName">商品图片</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <div class="thumbnail">
                            <img data-src="holder.js/300x300" alt="${gs.goodsName}" src="${ctx}/${gs.goodsImgPath}">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsName">商品名</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="text" class="form-control" id="goodsName" name="goodsName" placeholder="商品名"
                               readonly value="${gs.goodsName}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsPrice">商品价格</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="number" class="form-control" id="goodsPrice" name="goodsName" placeholder="商品价格"
                               readonly value="${gs.goodsPrice}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsType">商品类型</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="text" class="form-control" id="goodsType" name="goodsType" placeholder="商品类型"
                               readonly value="${gs.goodsType.desc}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="status">商品状态</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="text" class="form-control" id="status" name="status" placeholder="商品状态" readonly
                               value="${gs.status.desc}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="goodsDesc">商品描述</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                            <textarea class="form-control" placeholder="商品描述" id="goodsDesc" name="goodsDesc" readonly
                                      style="margin: 0px -65px 0px 0px; width: 396px; height: 188px;">
                                ${gs.goodsDesc}
                            </textarea>
                    </div>
                </div>
                <div class="form-group">
                    <a href="javascript:history.back(-1);" class="btn btn-primary">返回</a>
                </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
