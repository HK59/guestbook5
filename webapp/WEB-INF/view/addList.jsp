<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/guest/addlist" method="post">
			<table border="1">
				<tr>
					<td>이름</td>
					<td>${personVo.name}</td>
					<td>비밀번호</td>
					<td>${personVo.password}</td>
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
		<c:forEach items="${requestScope.glist}" var = "PersonVo">
			<table border="1">
				<tr>
					<td>${PersonVo.no }</td>
					<td>${PersonVo.name }</td>
					<td>${PersonVo.regdate }</td>
					<td><a href="">[삭제]</a></td>
				</tr>
				<tr>
					<td colspan="4">${PersonVo.content }</td>
				</tr>
	
			</table>
			
			</c:forEach>

		
		
		
</body>
</html>