<%--jstl--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--end--%>

<%--set ctx value--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%--end--%>

<%--icon--%>
<link href="${ctx}/static/shenma.ico" rel="icon">
<%--end--%>

<%--self style--%>
<link href="${ctx}/static/css/common.css">
<%--end--%>

<%--bootstrap--%>
<link rel="stylesheet" href="${ctx}/static/plugin/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/plugin/bootstrap/css/bootstrap-datetimepicker.min.css">
<script src="${ctx}/static/plugin/bootstrap/js/bootstrap.min.js" ></script>
<%--<script src="${ctx}/static/plugin/bootstrap/js/bootstrap-datetimepicker.js" ></script>
<script src="${ctx}/static/plugin/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" ></script>--%>
<%--end--%>

<%--jquery--%>
<script src="${ctx}/static/js/jquery.min.js"></script>
<%--end--%>