<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 2016/12/10
  Time: 15:44
  target: use list goods in winxin client on user mobile divice
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
    <%@include file="../../common/include.jsp"%>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <a href="${ctx}/goods/11/info">
                    <div class="thumbnail">
                        <img src="${ctx}/static/images/goods/img0.jpg" alt="pizza-01">
                        <div class="caption">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <div class="col-md-8 col-xs-8 pull-left">
                                        <span class="thumbnail-title"> pizza-01</span>
                                    </div>
                                    <div class="col-md-3 col-xs-3 pull-right">
                                        <span class="thumbnail-price">￥100</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-xd-12">
                <div class="thumbnail">
                    <img src="${ctx}/static/images/goods/img1.jpg" alt="pizza-02">
                    <div class="caption">
                        <h4>pizza-02 <span>￥10</span></h4>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-xd-12">
                <div class="thumbnail">
                    <img src="${ctx}/static/images/goods/img2.jpg" alt="pizza-03">
                    <div class="caption">
                        <h4>pizza-03 <span>￥10</span></h4>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-xd-12" >
                <div class="thumbnail">
                    <img src="${ctx}/static/images/goods/img3.jpg" alt="pizza-04">
                    <div class="caption">
                        <h4>pizza-04 <span>￥10</span></h4>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-xd-12">
                <div class="thumbnail">
                    <img src="${ctx}/static/images/goods/img4.jpg" alt="pizza-05">
                    <div class="caption">
                        <h4>pizza-05 <span>￥10</span></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
