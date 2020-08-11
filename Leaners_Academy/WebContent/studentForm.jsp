<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="coversheet.css" />
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
<h1>Add New Student</h1>
	
	<form class="form-signin" action="<%=request.getContextPath() %>/StudentServlet">
		<input type="hidden" name="action" value="insert"/>
		<input type ="text" class="form-control" name="studentId" placeholder="Enter Student ID"/>
		<input type ="text" class="form-control" name="studentName" placeholder="Enter Student Name"/>
		<input type ="text" class="form-control" name="studentAge" placeholder="Enter Student Age" />
		<input type ="text" class="form-control" name="classId" placeholder="Enter Class ID" />
		<br>
		<input type ="submit" value="Add Student"/>
	</form>
</body>
</html>