<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="coversheet.css" />
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
<h1>Add New Subject</h1>
	
	<form class="form-signin" action="<%=request.getContextPath() %>/SubjectServlet">
		<input type="hidden" name="action" value="insert"/>
		<input type ="number" class="form-control" name="subjectId" placeholder="Enter Subject id" />
		<input type ="text" class="form-control" name="subjectName" placeholder="Enter Subject name"/>
		<input type ="number" class="form-control" name="classId" placeholder="Enter Class id" />
		<input type ="number" class="form-control" name="teacherId" placeholder="Enter Teacher id" />
		<input type ="submit" value="Add Subject"/>
	</form>
</body>
</html>