<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="signinsheet.css" />
</head>
	
	<h2> <center> Login Page </center></h2>

<body class="text-center">
	
	<form class="form-signin" action="LoginServlet" method="POST"> 
		<input type="text" class="form-control" name="name" placeholder="Enter Name" />
		<br>
		<input type="password" class="form-control" name="password" placeholder="Enter Password" />
		<br>
	<button class="btn btn-success" type="submit">Log in</button>
</form>
</body></html>