<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//파라미터를 읽기
	String first = request.getParameter("first");
	String second = request.getParameter("second");
	
	//처리 수행
	int result = Integer.parseInt(first)+Integer.parseInt(second);
	
	//결과 저장
	request.setAttribute("result", result);
	session.setAttribute("result", result);
	application.setAttribute("result", result);
	
	//결과 페이지로 이동
	System.out.println("처리 페이지");
	
	//포워딩
	//request.getRequestDispatcher("output.jsp").forward(request, response);
	
	//리다이렉트
	response.sendRedirect("output.jsp");
%>