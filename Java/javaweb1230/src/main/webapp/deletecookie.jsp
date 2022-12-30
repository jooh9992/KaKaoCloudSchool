<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제</title>
</head>
<body>
	<%
		//name 쿠키 삭제
		Cookie [] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("name")){
				Cookie cookie1 = new Cookie("name", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie1);
			}
		}
	%>
</body>
</html>