<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject List</title>

</head>

<body class="text-center">
<%@ include file="header.jsp"%>
	<br/>
	<a href="<%=request.getContextPath() %>/SubjectServlet?action=insertSubject">
		<button class="btn btn-outline-primary">Add new Subject</button>
	</a>
	<br/><br/>

	<table class="table table-bordered table-hover table-hover"">

		<thead>
			<tr>
				<th>Subject ID</th>
				<th>Subject Name</th>
				<th>Class ID</th>
				<th>Teacher ID</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="subject1" items="${subject1}">

				<tr>
					<td style='color:black'><c:out value="${subject1.subjectId}" /></td>
					<td style='color:black'><c:out value="${subject1.subjectName}" /></td>
					<td style='color:black'><c:out value="${subject1.classId}" /></td>
					<td style='color:black'><c:out value="${subject1.teacherId}" /></td>
					<td style='color:black' >
						<a href="SubjectServlet?action=updateSubject&subjectId=<c:out value="${subject1.subjectId}" />">
							<button class="btn btn-outline-info">Update</button>
						</a> 
						<a href="SubjectServlet?action=deleteSubject&subjectId=<c:out value="${subject1.subjectId}" />">
							<button class="btn btn-outline-danger">Delete</button>
						</a>
					</td>
				</tr>

			</c:forEach>

		</tbody>
		</table>
</body>
</html>