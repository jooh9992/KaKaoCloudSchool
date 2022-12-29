<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 실습</title>
</head>
<body>
	<%
		//web.xml 파일의 초시화 파라미터 읽어오기
		String user = application.getInitParameter("User");
	%>
	<%= user %><br/>

	<a href="res.jsp?name=park">GET 요청</a><br/>
	<form method="post" action="res.jsp">
		별명: <input type="text" name="nickname"/>
		<input type="submit"/>전송
	</form>
	
	<%
		//모든 헤더 정보 출력
		//브라우저 나 운영체제 정보, 쿠키 등을 확인 가능
		java.util.Enumeration <String> headerEnum = request.getHeaderNames();
		while(headerEnum.hasMoreElements()){
			String name = headerEnum.nextElement();
			String value = request.getHeader(name);
	%>
	<%=name %>:<%=value %><br/>
	<% } %>
</body>
</html>