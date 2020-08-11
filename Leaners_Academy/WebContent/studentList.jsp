<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>

</head>

<body class="text-center">
<%@ include file="header.jsp"%>
	<br/>
	<a href="<%=request.getContextPath() %>/StudentServlet?action=insertStudent">
		<button class="btn btn-outline-primary">Add new Student</button>
	</a>
	<br/><br/>

	<table class="table table-bordered table-hover table-hover"">

		<thead>
			<tr>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Student Age</th>
				<th>Class ID</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="student1" items="${student1}">

				<tr>
					<td style='color:black'><c:out value="${student1.studentId}" /></td>
					<td style='color:black'><c:out value="${student1.studentName}" /></td>
					<td style='color:black'><c:out value="${student1.studentAge}" /></td>
					<td style='color:black'><c:out value="${student1.classId}" /></td>					
					<td style='color:black' >
						<a href="StudentServlet?action=updateStudent&studentId=<c:out value="${student1.studentId}" />">
							<button class="btn btn-outline-info">Update</button>
						</a> 
						<a href="StudentServlet?action=deleteStudent&studentId=<c:out value="${student1.studentId}" />">
							<button class="btn btn-outline-danger">Delete</button>
						</a>
					</td>
				</tr>

			</c:forEach>

		</tbody>
		</table>
</body>
</html>