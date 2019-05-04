<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04.05.2019
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<p>Привет, ${requestScope.user.name}!Купи ${requestScope.book.name}, пожалуйста</p>
</body>
</html>
