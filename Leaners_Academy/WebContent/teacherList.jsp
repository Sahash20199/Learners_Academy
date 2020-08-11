<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher List</title>

</head>

<body class="text-center">
<%@ include file="header.jsp"%>
	<br/>
	<a href="<%=request.getContextPath() %>/TeacherServlet?action=insertTeacher">
		<button class="btn btn-outline-primary">Add new Teacher</button>
	</a>
	<br/><br/>

	<table class="table table-bordered table-hover table-hover"">

		<thead>
			<tr>
				<th>Teacher Id</th>
				<th>Teacher Name</th>
				<th>Teacher Salary</th>
				<th>Teacher Experience</th>
				<th>Class ID</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="teacher1" items="${teacher1}">

				<tr>
					<td style='color:black'><c:out value="${teacher1.teacherId}" /></td>
					<td style='color:black'><c:out value="${teacher1.teacherName}" /></td>
					<td style='color:black'><c:out value="${teacher1.teacherSalary}" /></td>
					<td style='color:black'><c:out value="${teacher1.teacherExperience}" /></td>
					<td style='color:black'><c:out value="${teacher1.classId}" /></td>
					
					<td style='color:black' >
						<a href="TeacherServlet?action=updateTeacher&teacherId=<c:out value="${teacher1.teacherId}" />">
							<button class="btn btn-outline-info">Update</button>
						</a> 
						<a href="TeacherServlet?action=deleteTeacher&teacherId=<c:out value="${teacher1.teacherId}" />">
							<button class="btn btn-outline-danger">Delete</button>
						</a>
					</td>
				</tr>

			</c:forEach>

		</tbody>
		</table>
</body>
</html>