package com.la.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.ClassDAO;
import com.la.dao.StudentDAO;
import com.la.dao.SubjectDAO;
import com.la.dao.TeacherDAO;
import com.la.models.Class;
import com.la.models.Student;
import com.la.models.SubjectClass;

public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	SubjectDAO subjectdao;
	TeacherDAO teacherdao;
	StudentDAO studentdao;
	ClassDAO classdao;
    public ClassServlet() {
        super();
        // TODO Auto-generated constructor stub
        classdao = new ClassDAO();
        subjectdao = new SubjectDAO();
        teacherdao = new TeacherDAO();
        studentdao = new StudentDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
		
		case "insertClass":
			insertClass(request,response);
			break;
		case "insert":
			insert(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "deleteClass":
			delete(request,response);
			break;
		case "updateClass":
			updateClass(request,response);
			break;
		case "report":
			report(request, response);
			break;
		default:
			selectClass(request,response);
			break;
		}
	}

	private void insertClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("classForm.jsp");
		dispatcher.forward(request,response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Inserting New Class");
		Class class1 = new Class();
		class1.setClassId(Integer.parseInt(request.getParameter("classId")));
		class1.setClassName(request.getParameter("className"));
		System.out.println(class1);
		classdao.insertClass(class1);
		response.sendRedirect("ClassServlet?action=SelectClass");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Class class1 = new Class();
		class1.setClassId(Integer.parseInt(request.getParameter("classId")));
		class1.setClassName(request.getParameter("className"));
		System.out.println(class1);
		classdao.update(class1);
		response.sendRedirect("ClassServlet?action=SelectClass");
	}

	private void updateClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int classId = Integer.parseInt(request.getParameter("classId"));
		System.out.println(classId);
		Class class1 = classdao.selectClass(classId);
		request.setAttribute("class1", class1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("classUpdate.jsp");
		dispatcher.forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int classId = Integer.parseInt(request.getParameter("classId"));
		classdao.deleteClass(classId);
		response.sendRedirect("ClassServlet?action=SelectClass");
	}

	private void report(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		List<Student> student = new ArrayList<Student>();
		
		int classId = Integer.parseInt(request.getParameter("classId"));
		SubjectClass subclass = new SubjectClass();
		
		arr = subjectdao.selectName(classId);
		System.out.println(classId);
		
		subclass.setSub_name1(arr.get(0));
		subclass.setSub_name2(arr.get(1));
		subclass.setSub_name3(arr.get(2));
		
		temp = teacherdao.selectName(classId);
		
		subclass.setTut_name1(temp.get(0));
		subclass.setTut_name2(temp.get(1));
		subclass.setTut_name3(temp.get(2));
		
		student = studentdao.selectName(classId);
		
		System.out.println(student);
		request.setAttribute("stu", student);
		request.setAttribute("subclass", subclass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("report.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	private void selectClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <Class> classlist = classdao.selectAllClass();
		request.setAttribute("class1", classlist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("classList.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
