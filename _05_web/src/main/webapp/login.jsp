<%--
  Created by IntelliJ IDEA.
  User: haonan
  Date: 2023/9/14
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/_05_web/loginServlet" method="get">
    用户名：<input type="text" name="username" value="${cookie.username.value}"> <br>
    密码：<input type="password" name="password" > <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
