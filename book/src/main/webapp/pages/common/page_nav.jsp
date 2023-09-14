<%--
  Created by IntelliJ IDEA.
  User: haonan
  Date: 2023/9/14
  Time: 08:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">
  <c:if test="${requestScope.page.pageNumber > 1}">
    <a href="${requestScope.page.url}&pageNumber=1">首页</a>
    <a href="${requestScope.page.url}&pageNumber=${requestScope.page.pageNumber-1}">上一页</a>
  </c:if>
  <c:choose>
    <c:when test="${requestScope.page.pageTotal <= 5}">
      <c:set var="begin" value="1"></c:set>
      <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
    </c:when>
    <c:otherwise>
      <c:choose>
        <c:when test="${requestScope.page.pageNumber <= 3}">
          <c:set var="begin" value="1"></c:set>
          <c:set var="end" value="5"></c:set>
        </c:when>
        <c:when test="${requestScope.page.pageNumber > requestScope.page.pageTotal - 3}">
          <c:set var="begin" value="${requestScope.page.pageTotal - 4}"></c:set>
          <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
        </c:when>
        <c:otherwise>
          <c:set var="begin" value="${requestScope.page.pageNumber - 2}"></c:set>
          <c:set var="end" value="${requestScope.page.pageNumber + 2}"></c:set>
        </c:otherwise>
      </c:choose>
    </c:otherwise>
  </c:choose>

  <c:forEach begin="${begin}" end="${end}" var="i">
    <c:if test="${requestScope.page.pageNumber != i}">
      <a href="${requestScope.page.url}&pageNumber=${i}">${i}</a>
    </c:if>
    <c:if test="${requestScope.page.pageNumber == i}">
      [${i}]
    </c:if>
  </c:forEach>

  <c:if test="${requestScope.page.pageNumber < requestScope.page.pageTotal}">
    <a href="${requestScope.page.url}&pageNumber=${requestScope.page.pageNumber+1}">下一页</a>
    <a href="${requestScope.page.url}&pageNumber=${requestScope.page.pageTotal}">末页</a>
  </c:if>
  共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input
        value="${requestScope.page.pageNumber}" name="pn"
        id="pn_input"/>页
  <input id="toPageBtn" type="button" value="确定">

  <script type="text/javascript">
    $(function () {
      $("#toPageBtn").click(function () {
        let val = $("#pn_input").val();
        location.href = "http://localhost:8080/book/${requestScope.page.url}&pageNumber=" + val;
      })
    });
  </script>
</div>