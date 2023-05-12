<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2023-05-12
  Time: 오전 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Page</title>
</head>
<body>
<h1>todo : ${todo}</h1> <%--여기서 el표시안에 todo는  TodoRegistController클래스안에 model.addAttribute("todo", todo);여기에 "todo"에서 온거임--%>
<h1>duedate : ${duedate}</h1>
<h1>todoRequest : ${todoRequest}</h1> <%--속성에 저장될때는 자동으로 첫번째글자가 대문자가 소문자로바뀜--%>

</body>
</html>
