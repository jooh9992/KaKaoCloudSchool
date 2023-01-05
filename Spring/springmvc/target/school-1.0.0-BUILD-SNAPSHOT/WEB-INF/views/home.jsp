<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
	<a href="hello">안녕하세요</a><br/>
	<a href="message/detail/11">URL에 포함된 매개변수</a>
	<a href="redirect">리다이렉트</a>
	
	<!-- action은 생략하면 현재 요청 method는 기본이 get
	enctype은 file이 있는 경우 multipart/form-data로 설정 그 이외는 생략
	id는 스크립트에서 사용하기 위해서 사용 -->
	<form action="param1">
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
</body>
</html>