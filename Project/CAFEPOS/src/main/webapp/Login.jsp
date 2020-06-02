<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="style.css" />
<style >
@import url(http://fonts.googleapis.com/earlyaccess/jejuhallasan.css);

@charset "UTF-8";

html {
	height: 100%;
}

body {
	position: relative;
	width: 100%;
	height: 100%;
	margin: 0;
	padding-top: 80px;
	padding-bottom: 40px;
	font-family: 'Jeju Hallasan', serif;
	background-repeat: no-repeat;
	background: #ffffe6;
}

#form {
    width:30%; 
	margin:100px; 
	border: 3px solid gray; 
    border-radius: 5px; 
	padding: 10px; 
	background-color:white; 

}

#inBtn {
	width: 80%;
	height: 30px;
	background-color: green;
	color: white;
	border: none;
	text-align: center;
	display: inline-block;
}

.form-control {
	position: relative;
	width: 240px;
	height: 40px;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}
</style>
</head>
<body class="background">
<center>
<h1>Welcome Coffee POS System</h1>

<form action="Login_proc.jsp" id="form" method="post">


<input type="text" name="id" class="form-control" placeholder="Your ID"/><br><br>

<input type="password" class="form-control" name="password" placeholder="Your Password"/>
<br><br>
<input type="submit" id="inBtn" value="로그인"/>

</form>

</center>
</body>
</html>