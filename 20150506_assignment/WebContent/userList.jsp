<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 목록</h3>
	<table>
		<tr>
			<th>이름</th>
			<th>이메일</th>
			<th>나이</th>
			<th>성별</th>
		</tr>
		<c:forEach items="${ requestScope.userList }" var="user">
			<tr>
				<td>${ user.name }</td>
				<td>${ user.email }</td>
				<td>${ user.age }</td>
				<c:if test="${ user.gender } == 0">
					<td>F</td>
				</c:if>
				<c:if test="${ user.gender } == 1">
					<td>M</td>
				</c:if>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2"><a href="registerForm.jsp">회원가입하기</a></td>
		</tr>
	</table>
</body>
</html>