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
	//쿠키 생성 및 저장
	//value가 한글인 경우는 인코딩을 해주어야 함
	//
	Cookie cookie = new Cookie("name", "value");
	response.addCookie(cookie);
%>
<a href="viewcookies.jsp">쿠키 보기</a>
<script>
	//유효 시간 설정
	let expire = new Date();
	expire.setDate(expire.getDate() + 60*60*24);
	//쿠키 모양 생성
	let cookie = "nickname" + "=" + encodeURI("이쥬") +
		"; path=/";
	//유효시간 설정
	cookie += ";expires=" + expire.toGMTString() + ";";
	document.cookie = cookie;
</script>
</body>
</html>