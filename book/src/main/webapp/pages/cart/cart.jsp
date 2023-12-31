<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>


</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>

    <%--静态包含，登录 成功之后的菜单 --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>
    <script type="text/javascript">
      $(function () {

        $(".deleteItem").click(function () {
          const name = $(this).parent().parent().find("td:first").text();
          return confirm("你确定删除【" + name + "】吗？")
        })

        $(".clearCart").click(function () {
          return confirm("你确定清空购物车吗？");
        })

        $(".updateCart").change(function () {
          const id = $(this).attr("bookId");
          const count = this.value;
          const name = $(this).parent().parent().find("td:first").text()
          if (confirm("你确定要将【" + name + "】的数量修改为【" + count + "】吗？")) {
            location.href = "http://localhost:8080/book/cartServlet?action=updateItem&id=" + id + "&count=" +
              count;
          } else {
            this.value = this.defaultValue;
          }
        })
      })
    </script>

</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp"> 购物车中没有商品，快去选购吧！！</a></td>
            </tr>
        </c:if>

        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td>
                    <input type="text" style="width: 80px" value="${entry.value.count}" bookId="${entry.value.id}"
                           class="updateCart">
                </td>
                <td>${entry.value.price}</td>
                <td>${entry.value.totalPrice}</td>
                <td><a href="cartServlet?action=deleteItem&id=${entry.value.id}" class="deleteItem">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span
                    class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a href="cartServlet?action=clear" class="clearCart">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>


</body>
</html>