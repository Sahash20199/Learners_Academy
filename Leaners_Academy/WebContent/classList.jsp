<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class List</title>

</head>

<body class="text-center">
<%@ include file="header.jsp"%>
	<br/>
	<a href="<%=request.getContextPath() %>/ClassServlet?action=insertClass">
		<button class="btn btn-outline-primary">Add new Class</button>
	</a>
	<br/><br/>

	<table class="table table-bordered table-hover table-hover"">

		<thead>
			<tr>
				<th>Class Id</th>
				<th>Class Name</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="class1" items="${class1}">

				<tr>
					<td style='color:black'><c:out value="${class1.classId}" /></td>
					<td style='color:black'><c:out value="${class1.className}" /></td>
					<td style='color:black' >
						<a href="ClassServlet?action=updateClass&classId=<c:out value="${class1.classId}" />">
							<button class="btn btn-outline-info">Update</button>
						</a> 
						<a href="ClassServlet?action=deleteClass&classId=<c:out value="${class1.classId}" />">
							<button class="btn btn-outline-danger">Delete</button>
						</a>
						<a href="ClassServlet?action=report&classId=<c:out value="${class1.classId}" />">
							<button class="btn btn-outline-warning">View Report</button>
						</a>
					</td>
				</tr>

			</c:forEach>

		</tbody>
		</table>
</body>
</html>