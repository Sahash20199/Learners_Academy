<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Class</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="coversheet.css" />
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
	<div style="margin-top:30px">
<h1>Update Class</h1>
	
	<form class="form-group" action="<%=request.getContextPath() %>/ClassServlet">
		<input type="hidden" name="action" value="update">
		<input style="width:300" class="form-control" type ="text" name="classId" value="${class1.classId}"/><br/>
		<input style="width:300" class="form-control" type ="text" name="className" value="${class1.className}"/><br/>
		<br/>
		<input class="btn btn-outline-info" type ="submit" value="Update Class"/>
	</form>
	</div>
</body>
</html>