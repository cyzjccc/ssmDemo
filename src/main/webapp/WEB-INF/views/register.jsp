<%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2019/6/24
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form id="login" action="/user/register" method="post">
    用户名：<input type="text" required id="userName" name="name"><br>
    密 码：<input type="password" required id="password" name="password"><br>
    <input type="submit" value="注册">
</form>
</body>
<script>
    //对应后台返回的提示
    if ('${status}' != '') {
        if ('${status}' == 0) {
            alert('注册成功,即将跳转至登录页面！')
            location.href = '/login/login'
        } else if ('${status}' == 1) {
            alert('该账户注册失败！');
        } else if ('${status}' == 2) {
            alert('该用户已存在！')
        }
    }
</script>
</html>
