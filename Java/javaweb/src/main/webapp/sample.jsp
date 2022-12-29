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
   int sum =0;
   for(int i=0; i<10; i++){
      sum = sum +i;
   }
%>
   <h1>JSP 생성</h1>
   <div><%=sum %></div>
   <div><%=request.getRemoteAddr() %></div>
</body>
</html>