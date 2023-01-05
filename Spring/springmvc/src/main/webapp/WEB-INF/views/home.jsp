<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    
<!-- jstl 사용을 위한 태그 라이브러리 설정 : JSP에서만 사용 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
<!-- link는 파일의 위치 기준이 아니고 URL 기준임 -->
<link rel="stylesheet" href="./css/style.css"/>
</head>
<body>
	<!-- 
	<a href="hello">안녕하세요</a><br/>
	<a href="message/detail/11">URL에 포함된 매개변수</a>
	<a href="redirect">리다이렉트</a>
	
	<!-- action은 생략하면 현재 요청 method는 기본이 get
	enctype은 file이 있는 경우 multipart/form-data로 설정 그 이외는 생략
	id는 스크립트에서 사용하기 위해서 사용 --> -->
	<!-- <form action="param1">
		이름:<input type="text" name="name"/><br/>
		비밀번호:<input type="password" name="password"/><br/>
		<input type="submit" value="전송"/>
	</form>
	<form action="param2" method="post">
		이름:<input type="text" name="name"/><br/>
		비밀번호:<input type="password" name="password"/><br/>
		<input type="submit" value="전송"/>
	</form>
	<form action="param3" method="post">
		이름:<input type="text" name="name"/><br/>
		비밀번호:<input type="password" name="password"/><br/>
		<input type="submit" value="전송"/>
	</form>
	-->
	<div align="center" class="body">
		<h2>상품 목록</h2>
		<table border="1">
			<tr class ="header">
				<th align="center" width="80">상품 아이디</th>
				<th align="center" width="320">상품 이름</th>
				<th align="center" width="100">가격</th>
			</tr>
			<c:forEach var ="item" items="${list}">
				<tr class ="record">
					<td align ="center" width="80">${item.itemid}</td>
					<td align ="left" width="320">${item.itemname}</td>
					<td align ="right" width="100">${item.price}원</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>