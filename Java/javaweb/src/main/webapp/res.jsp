<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		request.setCharacterEncoding("UTF-8");
		String nickname = request.getParameter("nickname");	
	%>
	이름: <%=name%><br/>
	별명: <%=nickname%>
</body>
</html>