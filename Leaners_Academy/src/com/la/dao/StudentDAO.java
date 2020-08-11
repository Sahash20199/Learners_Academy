package com.la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.la.models.*;


public class StudentDAO {
	
	public Connection getConnection() {

		Connection connection = null;
		try {

			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatedb", "root", "Sahash47!");
		} catch (Exception ex) {
			System.out.println("Exception Raised...");
			System.out.println(ex.getMessage());
		}
		return connection;

	}
	
	public List<Student> selectAll() throws SQLException{
		List <Student> studentList = new ArrayList<Student>();
		
		try(Connection connection = getConnection()){
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Student;");
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getInt("studentId"));
			student.setStudentName(rs.getString("studentName"));
			student.setStudentAge(rs.getInt("studentAge"));
			student.setClassId(rs.getInt("classId"));
			studentList.add(student);
		}
		}catch(Exception e) {
			System.out.println("Exception Raised...");
			System.out.println(e.getMessage());
		}
		return studentList;
		
	}
	
	public Student select(int studentId) throws SQLException {
		Student student = new Student();
		
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("Select * from Student where studentId = ?;");
			statement.setInt(1,studentId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				student.setStudentId(rs.getInt("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentAge(rs.getInt("studentAge"));
				student.setClassId(rs.getInt("classId"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return student;
	}
	
	public void update(Student student) {
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("update  student set studentName = ?, studentAge = ?, classId = ?  where studentId = ?;");
			statement.setString(1,student.getStudentName());
			statement.setInt(2,student.getStudentAge());
			statement.setInt(3,student.getClassId());
			statement.setInt(4,student.getStudentId());

			int rs = statement.executeUpdate();
		
			System.out.println(rs+"success");

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void delete(int studentId) {
		try {
			Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM student WHERE studentId = ?;");
            statement.setInt(1, studentId);
            int result = statement.executeUpdate();
            System.out.println("delete successful");
            connection.close();
        } catch (Exception ex) {
            System.out.println("Exception Raised...");
            System.out.println(ex.getMessage());
        }
	}
	

	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		try {
            Connection connection = getConnection();
            
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Student(studentId, studentName, studentAge, classId) VALUES(?,?,?,?);");
            statement.setInt(1, student.getStudentId());
            statement.setString(2, student.getStudentName());
            statement.setInt(3, student.getStudentAge());
            statement.setInt(4, student.getClassId());
            
            int result = statement.executeUpdate();
            System.out.println("successful");
            connection.close();
        } catch (Exception ex) {
            System.out.println("Exception Raised...");
            System.out.println(ex.getMessage());
        }
	}
	
	public List<Student> selectName(int classId){
		List<Student> list = new ArrayList<Student>();
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Select studentname from student where classId=? ");
			statement.setInt(1, classId);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setStudentName(rs.getString("studentName"));
				list.add(student);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
