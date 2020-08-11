<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
	<br/>

	<table class="table table-striped table-hover">

		<thead>
			<tr>
				<th style='color:black'>Student Name</th>
				<th style='color:black'>Teacher name</th>
				<th style='color:black'>Subject Name</th>
				<th style='color:black'>Teacher name</th>
				<th style='color:black'>subjectname</th>
				<th style='color:black'>Teacher name</th>
				<th style='color:black'>subjectname</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach var="stu" items="${stu}">

				<tr>
					<td style='color:black'><c:out value="${stu.studentName}" /></td>
					<td style='color:black'><c:out value="${subclass.tut_name1}" /></td>
					<td style='color:black'><c:out value="${subclass.sub_name1}" /></td>
					<td style='color:black'><c:out value="${subclass.tut_name2}" /></td>
					<td style='color:black'><c:out value="${subclass.sub_name2}" /></td>
					<td style='color:black'><c:out value="${subclass.tut_name3}" /></td>
					<td style='color:black'><c:out value="${subclass.sub_name3}" /></td>
					<td>
					</td>
				</tr>

			</c:forEach>

		</tbody>


	</table>

</body>
</html>