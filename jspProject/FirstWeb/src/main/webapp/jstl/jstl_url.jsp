<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:url value="index.jsp" var="url_index1"/>
상대경로: ${url_index1} <br>
<c:url value="/index.jsp" var="url_index2"/>
절대경로: ${url_index2} <br>
<a href = "<c:url value="/index.jsp"/>">Home</a>
<br>
<c:url value = "/jstl/jstl_choosewhen.jsp">
<c:param name="sel">a</c:param>
<c:param name="code" value="123"/>
</c:url>
${url}
<br>
<a href = "${url}">select</a>
<a href = "<c:url value="/jstl/jstl_choosewhen.jsp"/>">select</a>
</body>
</html>