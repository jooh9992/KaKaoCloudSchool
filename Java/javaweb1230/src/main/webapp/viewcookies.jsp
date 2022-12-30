<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 읽기</title>
</head>
<body>
	<%
		//모든 쿠키 전부 가져오기
		Cookie [] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			String value = java.net.URLDecoder.decode(
					cookie.getValue(), "UTF-8");
		
	%>
		<%=cookie.getName() %>: <%=value %>
		<br/>
	<% } %>
</body>
<script>
	//모든 쿠키 읽기
	let cookieData = document.cookie;
	let start = cookieData.indexOf("nickname");
	let cValue = '';
	if(start != -1){
		start += "nickname".length;
		let end = cookieData.indexOf(";", start);
		if(end === -1){
			end = cookieData.length;
		}
		console.log(decodeURI(cookieData.substring(start, end)));
	}else{
		console.lof("존재하지 않는 쿠키 입니다.");
	}
</script>
</html>
