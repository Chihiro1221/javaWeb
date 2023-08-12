<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<div>大家好，欢迎学习Tomcat</div>
<input type="text">
<button> 提交</button>
<script>
  const btn = document.querySelector('button')
  btn.onclick = () => {
    fetch('http://localhost:8088/_05_web/hello3', {
      method: 'POST',
    }).then(value => {}).catch(err => {
      console.log(err)
    })
  }
</script>
</body>
</html>