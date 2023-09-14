<%--
  Created by IntelliJ IDEA.
  User: haonan
  Date: 2023/8/14
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8088/_05_web/uploadServlet" enctype="multipart/form-data" method="post">
    用户名：<input type="text" name="username"/> <br>
    上传头像：<input type="file" name="photo"> <br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
