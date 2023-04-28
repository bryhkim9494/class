<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    request.setAttribute("totalPageNum",5);
    request.setAttribute("msg", "1|손흥민|010-9999-7777|런던");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forTokens items="${msg}" delims="|" var="str" varStatus="stat">

<c:if test="${stat.index==1}">이름 : ${str}
</c:if>

</c:forTokens>

<br>

<h2>1~5까지 반복 (페이징 넘버)</h2>
<c:forEach var="num" begin="1" end="${totalPageNum}" step="1">
[ ${num} ]
</c:forEach>


<br>
<table border ="1">

	<tr>
	
		<th>index</th>
		<th>count</th>
		<th>아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
	</tr>
	
	<c:forEach items="${members}" var="member" varStatus="stat"> <!-- 반복처리할려면 var까지만 쓰면됨 varStatus선택사항임 -->
	<!-- varStatus index나 count값 찍을때 사용 -->
	
	
	
	
	
	<tr>
		<td>${stat.index}</td>
		<td>${stat.count}</td>
		<td>${member.id}</td> <!-- getid메소드호출 -->
		<td>
		<c:out value="${member.name}" default="noname"/>
		</td>
		<td>${member.pw}</td>
	</tr>
	</c:forEach>
		
	
	
</table>


</body>
</html>