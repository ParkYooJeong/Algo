<%@page import="com.spring.biz.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.spring.biz.board.AmountVO"%>
<%@page import="com.spring.biz.board.impl.AmountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/jejuhallasan.css);

table, td, th, tr {
	text-align: center;
	font-family: 'Jeju Hallasan', serif;
}

body {
	font-family: 'Jeju Hallasan', serif;
	background: #ffffe6;
}

p {
	font-size:30px;
}
</style>

<meta charset="UTF-8">
<%
	AmountDAO dao = new AmountDAO();
	List<BoardVO> list = dao.getBoardList();
	int sum = dao.sum();
%>
<title>Insert title here</title>
</head>
<body>
	<center>
		<p><b>총 매출</b></p>

		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="#05944d" width="100">번호</th>
				<th bgcolor="#05944d" width="200">메뉴</th>
				<th bgcolor="#05944d" width="150">수량</th>
				<th bgcolor="#05944d" width="150">가격</th>
			</tr>
			<%
				for (BoardVO board : list) {
			%>
			<tr>
				<td><%=board.getSeq()%></td>
				<td><%=board.getP_name()%></td>
				<td><%=board.getCount()%></td>
				<td><%=board.getP_price()%></td>
			</tr>

			<%
				}
			%>
			<tr>
				<td colspan=2>총 매출액</td>
				<td colspan=2><%=sum%></td>

			</tr>
		</table>

	</center>


</body>
</html>