<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 가입</h3>
	<form action="registerUser.do" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" min="0" max="150"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="gender" value="0">여성</td>
				<td><input type="radio" name="gender" value="1">남성</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입">
					<input type="reset" value="다시 작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>