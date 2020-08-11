<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="coversheet.css" />
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
<h1>Add New User</h1>
	
	<form class="form-signin" action="<%=request.getContextPath() %>/TeacherServlet">
		<input type="hidden" name="action" value="insert"/>
		<input type ="number" class="form-control" name="teacherId" placeholder="Enter Teacher Id"/>
		<input type ="text" class="form-control" name="teacherName" placeholder="Enter Teacher name"/>
		<input type ="number" class="form-control" name="teacherSalary" placeholder="Enter Teacher salary" />
		<input type ="number" class="form-control" name="teacherExperience" placeholder="Enter Teacher Experience" />
		<input type ="number" class="form-control" name="classId" placeholder="Enter Class Id" />
		
		<input type ="submit" value="Add Teacher"/>
	</form>
</body>
</html>