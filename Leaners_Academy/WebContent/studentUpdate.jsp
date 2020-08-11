<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="coversheet.css" />
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
	<div style="margin-top:30px">
<h1>Update Student</h1>
	
	<form class="form-group" action="<%=request.getContextPath() %>/StudentServlet">
		<input type="hidden" name="action" value="update">
		<input style="width:300" class="form-control" type ="text" name="studentId" value="${student1.studentId}"/><br/>
		<input style="width:300" class="form-control" type ="text" name="studentName" value="${student1.studentName}"/><br/>
		<input style="width:300" class="form-control" type ="text" name="studentAge" value="${student1.studentAge}"/><br/>
		<input style="width:300" class="form-control" type ="text" name="classId" value="${student1.classId}"/><br/>

		<br/>
		<input class="btn btn-outline-info" type ="submit" value="Update Student"/>
	</form>
	</div>
</body>
</html>