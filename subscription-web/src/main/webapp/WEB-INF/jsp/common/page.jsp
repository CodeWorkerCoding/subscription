<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 2016/12/18
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<input type="hidden" name="pageNo" id="pageNo", value="${pageNo}">
<script type="text/javascript">

    function gotoPage(n){
        $("#pageNo").val(n);
        document.searchForm.submit();
    }
    function clearPage(){
        document.searchForm[page].value=1;
    }

</script>
<%--分页--%>
<div class="col-sm-2">总条数：${pages.totalElements}</div>
<div class="col-sm-10">
    <ul class="pagination pull-right">
        <li><a href="javascript:gotoPage(0)">首页</a></li>
        <c:if test="${pages.number > 0 }">
            <li><a href="javascript:gotoPage(${pages.number-1})"><i class="fa-angle-double-left"></i>上一页</a></li>
        </c:if>
        <c:if test="${pages.totalPages <= 5 || pages.number+6 > pages.totalPages }">
            <c:forEach begin="${pages.number+1}" end="${pages.totalPages }" var="currPage">
                <li><a href="javascript:gotoPage(${currPage-1 })">${currPage }</a></li>
            </c:forEach>
        </c:if>
        <c:if test="${pages.totalPages > 5 && pages.number+6<=pages.totalPages }">
            <c:forEach begin="${pages.number+1}" end="${pages.number+5}" var="currPage">
                <li><a href="javascript:gotoPage(${currPage-1 })">${currPage }</a></li>
            </c:forEach>
        </c:if>
        <c:if test="${pages.number+1 < pages.totalPages  }">
            <li><a href="javascript:gotoPage(${pages.number +1})">下一页  <i class="fa-angle-double-right"></i></a></li>
        </c:if>
        <li><a href="javascript:gotoPage(${pages.totalPages - 1})">尾页</a></li>
    </ul>
</div>
<%--end--%>
