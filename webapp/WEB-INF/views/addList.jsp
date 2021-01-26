<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here ${pageContext.request.contextPath} </title>
</head>
<body>
<form action="${pageContext.request.contextPath}/guest/addlist" method="post">
			<table border="1">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
					<td>비밀번호</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td colspan="4"> <textarea name="content"> </textarea> </td>
				</tr>
				<tr>
					<td colspan="4"> <button type="submit" >확인</button></td>
				</tr>
				
			</table>
		</form>
		<br>
		<c:forEach items="${gList}" var = "GuestVo">
			<table border="1">
				<tr>
					<td>${guestVo.no}</td>
					<td>${guestVo.name}</td>
					<td>${guestVo.regdate}</td>
					<td><a href="">[삭제]</a></td>
				</tr>
				<tr>
					<td colspan="4">${guestVo.content}</td>
				</tr>
	
			</table>
			
			</c:forEach>

		
		
		
</body>
</html>