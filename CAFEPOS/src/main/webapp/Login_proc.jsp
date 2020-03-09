
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
		//1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if (id.equals("test") && password.equals("test123")) {
			response.sendRedirect("Main_Page.jsp");
		} else {
			response.sendRedirect("Login.jsp");

		}
	%>
</body>
</html>