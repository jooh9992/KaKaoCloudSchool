<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 출력</title>
</head>
<body>
	request 객체: <%=request.getAttribute("result") %>
	<br/>
	session 객체: <%=session.getAttribute("result") %>
	<br/>
	application 객체: <%=application.getAttribute("result") %>
	<br/>
</body>
</html>