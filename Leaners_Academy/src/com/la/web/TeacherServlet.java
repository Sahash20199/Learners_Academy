package com.la.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.TeacherDAO;
import com.la.models.Teacher;

public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TeacherDAO teacherdao; 
    public TeacherServlet() {
        super();
        teacherdao = new TeacherDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
		
		case "insertTeacher":
			insertTeacher(request,response);
			break;
		case "insert":
			insert(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "deleteTeacher":
			delete(request,response);
			break;
		case "updateTeacher":
			try {
				updateTeacher(request,response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			try {
				System.out.println(action);
				selectTeacher(request,response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		teacherdao.delete(teacherId);
		response.sendRedirect("TeacherServlet?action=SelectTeacher");
		
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Inserting New Teacher");
		Teacher teacher = new Teacher();
		teacher.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
		teacher.setTeacherName(request.getParameter("teacherName"));
		teacher.setTeacherSalary(Integer.parseInt(request.getParameter("teacherSalary")));
		teacher.setTeacherExperience(Integer.parseInt(request.getParameter("teacherExperience")));
		teacher.setClassId(Integer.parseInt(request.getParameter("classId")));
		System.out.println(teacher);
		teacherdao.insertTeacher(teacher);
		response.sendRedirect("TeacherServlet?action=SelectTeacher");
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
		teacher.setTeacherName(request.getParameter("teacherName"));
		teacher.setTeacherSalary(Integer.parseInt(request.getParameter("teacherSalary")));
		teacher.setTeacherExperience(Integer.parseInt(request.getParameter("teacherExperience")));
		teacher.setClassId(Integer.parseInt(request.getParameter("classId")));
		
		System.out.println(teacher);
		teacherdao.update(teacher);
		response.sendRedirect("TeacherServlet?action=SelectTeacher");
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Teacher teacher = teacherdao.select(teacherId);
		request.setAttribute("teacher1", teacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherUpdate.jsp");
		dispatcher.forward(request, response);
	}

	private void selectTeacher(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException, SQLException {
		List <Teacher> teacher = teacherdao.selectAll();
		request.setAttribute("teacher1", teacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherList.jsp");
		dispatcher.forward(request, response);
	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherForm.jsp");
		dispatcher.forward(request,response);
	}
}
