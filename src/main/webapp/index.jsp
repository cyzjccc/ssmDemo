<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h2>Hello World!!!!!</h2>
<a href="login/toLogin">跳转登录页面</a>

<h4>表单传递数据--post</h4>
<form id="loginPost" action="/login/getMessagePost" method="post">
    用户名：<input type="text" name="userName"><br>
    密 码：<input type="password" name="password"><br>
    <button type="submit">POST传递</button>
</form>

<h4>表单传递数据--get</h4>
<form id="loginGet" action="/login/getMessageGet" me
      thod="get">
    用户名：<input type="text" name="userName"><br>
    密 码：<input type="password" name="password"><br>
    <button type="submit">GET传递</button>
</form>

<h4>综合页面跳转传递数据</h4>
<input type="text" id="userName" name="name">
<input type="button" value="查询用户" onclick="SearchInfo()">

</body>
<script>

    function SearchInfo() {
        window.open("/login/info/data=" + document.getElementById("userName").value);
    }

</script>
</html>
