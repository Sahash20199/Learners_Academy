package com.la.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.ClassDAO;
import com.la.dao.StudentDAO;
import com.la.models.Student;

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentDAO studentdao; 
    public StudentServlet() {
        super();
        studentdao = new StudentDAO();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
		
		case "insertStudent":
			insertStudent(request,response);
			break;
		case "insert":
			insert(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "deleteStudent":
			delete(request,response);
			break;
		case "updateStudent":
			try {
				updateStudent(request,response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			try {
				System.out.println(action);
				selectStudent(request,response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		studentdao.delete(studentId);
		response.sendRedirect("StudentServlet?action=SelectStudent");
		
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Inserting New Student");
		Student student = new Student();
		student.setStudentId(Integer.parseInt(request.getParameter("studentId")));
		student.setStudentName(request.getParameter("studentName"));
		student.setStudentAge(Integer.parseInt(request.getParameter("studentAge")));
		student.setClassId(Integer.parseInt(request.getParameter("classId")));
		System.out.println(student);
		studentdao.insertStudent(student);
		response.sendRedirect("StudentServlet?action=SelectStudent");
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("hi");
		Student student = new Student();
		student.setStudentId(Integer.parseInt(request.getParameter("studentId")));
		student.setStudentName(request.getParameter("studentName"));
		student.setStudentAge(Integer.parseInt(request.getParameter("studentAge")));
		student.setClassId(Integer.parseInt(request.getParameter("classId")));
		System.out.println(student);
		studentdao.update(student);
		response.sendRedirect("StudentServlet?action=SelectStudent");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentdao.select(studentId);
		request.setAttribute("student1", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentUpdate.jsp");
		dispatcher.forward(request, response);
	}

	private void selectStudent(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException, SQLException {
		List <Student> student = studentdao.selectAll();
		request.setAttribute("student1", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentList.jsp");
		dispatcher.forward(request, response);
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentForm.jsp");
		dispatcher.forward(request,response);
	}
}
