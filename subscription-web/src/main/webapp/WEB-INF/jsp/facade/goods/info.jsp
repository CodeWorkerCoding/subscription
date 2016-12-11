<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 2016/12/11
  Time: 14:39
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
        <div class="row">
            <div class="col-sm-12">
                <div class="thumbnail">
                    <img src="${ctx}/static/images/goods/img2.jpg" alt="pizza-2">
                    <div class="caption">
                        <h2>pizza-02 <span style="">￥10</span> <span class="badge">100件</span> </h2>
                        <p>
                            bootstrap，想做微信小程序开发?编程0基础快速上手，3个月内成为WEB前端开发工程师bootstrap，
                            首套WEB全栈开发工程师体系课程，随到随学!
                        </p>
                        <p>
                            <a href="#" class="btn btn-primary" role="button">购买</a>
                            <a href="#" class="btn btn-default" role="button">返回</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="panel panel-primary col-sm-12">
                    <div class="panel-heading">
                        <h2>pizza-05 图片展示</h2>
                    </div>
                    <div class="panel-body">
                        <ul class="list-group">
                            <li class="list-group-item col-sm-12"><img src="${ctx}/static/images/goods/img9.jpg" alt="商品细节" ></li>
                            <li class="list-group-item col-sm-12"><img src="${ctx}/static/images/goods/img8.jpg" alt="商品细节" ></li>
                            <li class="list-group-item col-sm-12"><img src="${ctx}/static/images/goods/img7.jpg" alt="商品细节" ></li>
                            <li class="list-group-item col-sm-12"><img src="${ctx}/static/images/goods/img6.jpg" alt="商品细节" ></li>
                            <li class="list-group-item col-sm-12"><img src="${ctx}/static/images/goods/img5.jpg" alt="商品细节" ></li>
                            <%--<li class="list-group-item col-sm-12"><img src="${ctx}/static/images/goods/img4.jpg" alt="商品细节" ></li>--%>
                            <li class="list-group-item col-sm-12"><img src="${ctx}/static/images/goods/img3.jpg" alt="商品细节" ></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
