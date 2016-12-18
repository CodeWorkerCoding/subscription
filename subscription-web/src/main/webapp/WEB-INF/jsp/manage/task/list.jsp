<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 2016/12/18
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.nchu.weixin.subscription.enums.component.TimeTaskStatusEnum" %>
<%@page import="com.nchu.weixin.subscription.enums.component.TimeTaskConditionEnum" %>
<html>
<head>
    <title>系统任务列表</title>
    <%@ include file="../../common/include.jsp"%>
</head>
<body>

    <div class="container-fluid">
        <h1 class="page-header">任务列表</h1>
        <form name="searchForm" id="searchForm" role="form" action="" method="post">
            <div class="form-inline">
                <div class="row">
                    <div class="form-group">
                        <label class="control-label text-right" for="taskName">任务名称:</label>
                        <input type="text" class="form-control text-left" id="taskName" value="${taskName}">
                    </div>
                    <div class="form-group">
                        <label class="control-label text-right" for="status">状态:</label>
                        <select class="form-control" id="status" name="status">
                            <option value="">--请选择状态--</option>
                            <c:forEach items="${TimeTaskStatusEnum.values()}" var="tts">
                                <option value="${tts.value}" <c:if test="${status == tts}">selected</c:if>>${tts.desc}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label text-right" for="condition">状态:</label>
                        <select class="form-control" id="condition" name="condition">
                            <option value="">--请选择状态--</option>
                            <c:forEach items="${TimeTaskConditionEnum.values()}" var="ttc">
                                <option value="${ttc.value}" <c:if test="${condition == ttc}">selected</c:if>>${ttc.desc}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">查询</button>
                        <a href="${ctx}/manage/goods/create" class="btn btn-success">创建系统任务</a>
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
                        <th>规则</th>
                        <th>执行器</th>
                        <th>状态</th>
                        <th>执行状态</th>
                        <th>状态</th>
                        <th>创建时间</th>
                        <th>跟新时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${tts}" var="tt">
                        <td>${tt.id}</td>
                        <td>${tt.taskName}</td>
                        <td>${tt.cronRule}</td>
                        <td>${tt.executeContext}</td>
                        <td>${tt.status.desc}</td>
                        <td>${tt.condition.desc}</td>
                        <td><fmt:formatDate value="${tt.createdTime}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${tt.modifiedTime}" pattern="yyyy-MM-dd"/> </td>
                        <td>
                            <a href="${ctx}/manage/goods/${tt.id}/modify" class="btn btn-primary">修改</a>
                            <button class="btn btn-primary"
                                    onclick="sendOperate(${tt.id}, ${OperateEnum.RELEASE.value}})">${OperateEnum.RELEASE.desc}</button>
                            <button class="btn btn-primary"
                                    onclick="sendOperate(${tt.id}, ${OperateEnum.REBACK.value}})">${OperateEnum.REBACK.desc}</button>
                            <button class="btn btn-primary"
                                    onclick="sendOperate(${tt.id}, ${OperateEnum.UNSHELVE.value}})">${OperateEnum.UNSHELVE.desc}</button>
                            <a href="${ctx}/#" class="btn btn-danger">删除</a>
                        </td>
                    </c:forEach>
                    </tbody>
                </table>
                <%@ include file="../../common/page.jsp "%>
            </div>
        </form>
    </div>

</body>
</html>
