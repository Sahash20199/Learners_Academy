package com.la.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.la.dao.SubjectDAO;

import com.la.models.Subject;

public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SubjectDAO subjectdao; 
    public SubjectServlet() {
        super();
        subjectdao = new SubjectDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
		
		case "insertSubject":
			insertSubject(request,response);
			break;
		case "insert":
			insert(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "deleteSubject":
			deleteSubject(request,response);
			break;
		case "updateSubject":
			try {
				updateSubject(request,response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			try {
				System.out.println(action);
				selectSubject(request,response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		subjectdao.deleteSubject(subjectId);
		response.sendRedirect("SubjectServlet?action=SelectSubject");
		
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Inserting New Subject");
		Subject subject = new Subject();
		subject.setSubjectId(Integer.parseInt(request.getParameter("subjectId")));
		subject.setSubjectName(request.getParameter("subjectName"));
		subject.setClassId(Integer.parseInt(request.getParameter("classId")));		
		subject.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
		System.out.println(subject);
		subjectdao.insertSubject(subject);
		response.sendRedirect("SubjectServlet?action=SelectSubject");
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Subject subject = new Subject();
		subject.setSubjectId(Integer.parseInt(request.getParameter("subjectId")));
		subject.setSubjectName(request.getParameter("subjectName"));
		subject.setClassId(Integer.parseInt(request.getParameter("classId")));
		subject.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
		System.out.println(subject);
		subjectdao.updateSubject(subject);
		response.sendRedirect("SubjectServlet?action=SelectSubject");
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		Subject subject = subjectdao.selectSubject(subjectId);
		System.out.println(subject);
		request.setAttribute("subject1", subject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectUpdate.jsp");
		dispatcher.forward(request, response);
	}

	private void selectSubject(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException, SQLException {
		List <Subject> subject = subjectdao.selectAllSubject();
		request.setAttribute("subject1", subject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectList.jsp");
		dispatcher.forward(request, response);
	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectForm.jsp");
		dispatcher.forward(request,response);
	}
}
