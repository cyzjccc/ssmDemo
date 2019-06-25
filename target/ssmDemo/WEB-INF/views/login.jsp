<%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2019/6/18
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h4>登录界面</h4>
<form id="login" action="/login/login" method="post">
    用户名：<input type="text" required id="userName" name="name"><br>
    密 码：<input type="password" required id="password" name="password"><br>
    <input type="submit" value="登录ss">
    <input type="button" value="注册" onclick="location.href='/user/register'">
</form>
</body>
<script>
    //对应后台返回的提示
    if ('${status}' != '') {
        if ('${status}' == 0) {
            alert('登录成功,即将跳转至用户详情页！')
            location.href = '/user/userInfo'
        } else if ('${status}' == 1) {
            alert('该账户不存在！');
        } else if ('${status}' == 2) {
            alert('密码错误！')
        }else if ('${status}' == 3) {
            alert('该用户名已经存在！')
        }
    }
</script>
</html>
