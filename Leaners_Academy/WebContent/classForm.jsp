<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Class</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="coversheet.css" />
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
<h1>Add New Class</h1>
	
	<form class="form-signin" action="<%=request.getContextPath() %>/ClassServlet">
		<input type="hidden" name="action" value="insert"/>
		<input type ="number" class="form-control" name="classId" placeholder="Enter Class ID"/>
		<input type ="text" class="form-control" name="className" placeholder="Enter Class Name"/>
		<br>
		<input type ="submit" value="Add Class"/>
	</form>
</body>
</html>