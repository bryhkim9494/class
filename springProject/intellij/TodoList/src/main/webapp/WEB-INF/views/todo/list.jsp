<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2023-05-11
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
  <h1>Todo List</h1>
  <hr>
  <h3>${todoList}</h3>
  <a href="/todo/read">read 페이지</a> <br> <%--context 경로를 edit configurations 에서 /(root)로 잡아서 따로 적을필요없이 바로 /todo/read만 적으면됨--%>
  <a href="/todo/regist">등록 페이지</a>
</body>
</html>
