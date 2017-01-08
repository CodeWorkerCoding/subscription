<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 2016/12/12
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nchu.weixin.subscription.enums.component.TimeTaskStatusEnum" %>
<html>
<head>
    <title>添加一个系统任务</title>
    <%@include file="../../common/include.jsp"%>
</head>
<body>
    <div class="container-fluid">
        <div class="page-header">
            <h1>添加一个系统任务</h1>
        </div>
        <div class="pager">
            <form class="form-horizontal" role="form" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="taskName">任务名称</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="text" class="form-control" required id="taskName" name="taskName" placeholder="任务名称" value="${ts.taskName}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="executeContext">任务执行器</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="text" class="form-control" required id="executeContext" name="executeContext" placeholder="任务执行器" value="${ts.executeContext}">
                        <%--<span class="input-group-addon col-sm-1 col-md-1">元</span>--%>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="cronRule">执行规则</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <input type="text" class="form-control" required id="cronRule" name="cronRule" placeholder="执行规则" value="${ts.cronRule}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="status">任务状态</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <select class="form-control" id="status" name="status" required>
                            <option value="">--选择任务状态--</option>
                            <c:forEach items="${TimeTaskStatusEnum.values()}" var="tts">
                                <option value="${tts}" <c:if test="${ts.status == tts}">selected</c:if>>${tts.desc}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 col-md-2 text-right">
                        <label class="control-label" for="taskDesc">任务描述</label>
                    </div>
                    <div class="col-sm-4 col-md-3 text-left">
                        <textarea class="form-control" placeholder="任务描述" id="taskDesc" name="taskDesc"
                                  value="${ts.taskDesc}"
                                  style="margin: 0px -175px 0px 0px; height: 208px; width: 506px;"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-3 col-md-3 col-md-offset-2">
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
