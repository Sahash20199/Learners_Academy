 <%
 	String Username=null;
	if (session.getAttribute("user") == null)
		response.sendRedirect("Login.jsp");
	Username= (String)session.getAttribute("user");
%>
 
 
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="coversheet.css" />
  
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand"> WELCOME <%= Username %></h3>
      <br>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link active" href="<%= request.getContextPath() %>/Dashboard.jsp">Home</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/ClassServlet?action=selectClass">Class</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/TeacherServlet?action=selectTeacher">Teacher</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/StudnetServlet?action=selectStudent">Student</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/SubjectServlet?action=selectSubject">Subject</a>       
		<br><br>

        <form action="login.jsp" >
        	<button style='margin-left:10px' class="btn btn-outline-danger"> Logout </button>
        </form>
        
      </nav>
    </div>
  </header>
