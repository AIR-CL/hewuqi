<%--
  Created by IntelliJ IDEA.
  User: 誓约之泪
  Date: 2020-10-13
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<h1>用户登录</h1>
<form action="/login" method="post">
    用户名:<input type="text" name="username" placeholder="请输入用户名"><span>${msg}</span><br>
    密码:<input type="password" name="pwd" placeholder="请输入密码"><br>
<%--    电话:<input type="tel" name="tel" placeholder="请输入联系方式"><br>--%>
    <input type="submit" value="登录">

</form>

</body>
</html>
