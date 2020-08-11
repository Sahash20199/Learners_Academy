<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Teacher</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="coversheet.css" />
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
	<div style="margin-top:30px">
<h1>Update Teacher</h1>
	
	<form class="form-group" action="<%=request.getContextPath() %>/TeacherServlet">
		<input type="hidden" name="action" value="update">
		<input style="width:300" class="form-control" type ="text" name="teacherId" value="${teacher1.teacherId}"/><br/>
		<input style="width:300" class="form-control" type ="text" name="teacherName" value="${teacher1.teacherName}"/><br/>
		<input style="width:300" class="form-control" type ="text" name="teacherSalary" value="${teacher1.teacherSalary}"/><br/>
		<input style="width:300" class="form-control" type ="text" name="teacherExperience" value="${teacher1.teacherExperience}"/><br/>
		<input style="width:300" class="form-control" type ="text" name="classId" value="${teacher1.classId}"/><br/>
		
		<br/>
		<input class="btn btn-outline-info" type ="submit" value="Update Teacher"/>
	</form>
	</div>
</body>
</html>