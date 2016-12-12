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
            <div class="col-sm-12 col-xs-12">
                <div class="thumbnail">
                    <img src="${ctx}/static/images/goods/img2.jpg" alt="pizza-2">
                    <div class="caption">
                        <%--<h2>pizza-02 <span style="">￥10</span> <span class="badge">100件</span> </h2>--%>
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <div class="col-sm-6"><span class="pull-left">pizz-05</span></div>
                                    <div class="col-sm-6"><span class="pull-right">￥100</span></div>
                                </div>

                                <p>
                                    bootstrap，想做微信小程序开发?编程0基础快速上手，3个月内成为WEB前端开发工程师bootstrap，
                                    首套WEB全栈开发工程师体系课程，随到随学!
                                </p>
                                <%--<p>
                                    <a href="#" class="btn btn-primary" role="button"><span
                                            class="glyphicon glyphicon-phone-alt"> 电话预定</a>
                                    <a href="#" class="btn btn-default" role="button">返回</a>
                                </p>--%>
                                <div class="form-group">
                                    <div class="col-sm-12 col-xs-12">
                                        <div class="operator">
                                            <a href="#" class="btn btn-primary col-md-7 col-xs-7" role="button"><span
                                                    class="glyphicon glyphicon-phone-alt"/> 电话预定</a>
                                            <a href="javascript：history.back(-1);" class="btn btn-default col-md-5 col-xs-5" role="button">返回</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2>pizza-05 图片展示</h2>
                    </div>
                    <div class="panel-body">
                        <ul class="list-group">
                            <li class="list-group-item"><img src="${ctx}/static/images/goods/img9.jpg" alt="商品细节" width="100%"></li>
                            <li class="list-group-item"><img src="${ctx}/static/images/goods/img8.jpg" alt="商品细节" width="100%" ></li>
                            <li class="list-group-item"><img src="${ctx}/static/images/goods/img7.jpg" alt="商品细节" width="100%"></li>
                            <li class="list-group-item"><img src="${ctx}/static/images/goods/img6.jpg" alt="商品细节" width="100%"></li>
                            <li class="list-group-item"><img src="${ctx}/static/images/goods/img5.jpg" alt="商品细节" width="100%"></li>
                            <li class="list-group-item"><img src="${ctx}/static/images/goods/img4.jpg" alt="商品细节" width="100%"></li>
                            <li class="list-group-item"><img src="${ctx}/static/images/goods/img3.jpg" alt="商品细节" width="100%"></li>
                        </ul>
                    </div>
                    <div class="panel-footer">
                        <span class="sm-pull-center">拥有最终版权</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
