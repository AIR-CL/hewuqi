<%--
  Created by IntelliJ IDEA.
  User: 誓约之泪
  Date: 2020-10-13
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册页面</title>
  </head>
  <body>
  <h1>用户注册</h1>
  <form action="/reg" method="post">
    用户名:<input type="text" name="username" placeholder="请输入用户名"><br>
    密码:<input type="password" name="pwd" placeholder="请输入密码"><br>
    电话:<input type="tel" name="tel" placeholder="请输入联系方式"><br>
    <input type="submit" value="注册">

  </form>

  </body>
</html>
