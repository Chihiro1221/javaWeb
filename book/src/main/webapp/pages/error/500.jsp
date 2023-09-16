<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>500错误页面</title>
    <style>
        body {
            background-color: #f6f6f6;
            font-family: Arial, sans-serif;
        }

        h1 {
            font-size: 48px;
            font-weight: bold;
            margin-top: 100px;
            text-align: center;
        }

        p {
            font-size: 24px;
            margin-top: 40px;
            text-align: center;
        }

        .a-con {
            display: flex;
            justify-content: center;
        }

        a {
            display: block;
            background-color: #108db6;
            border: none;
            color: white;
            font-size: 24px;
            padding: 15px 30px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            cursor: pointer;
            margin: 40px auto;
        }

        button:hover {
            background-color: #0d8aa4;
        }
    </style>
</head>
<body>
<h1>500</h1>
<p>出现问题了，请稍后再试！</p>
<div class="a-con">
    <a href="index.jsp">返回上一页</a>
</div>
</body>
</html>