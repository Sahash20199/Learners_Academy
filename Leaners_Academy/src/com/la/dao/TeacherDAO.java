package com.la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.la.models.*;


public class TeacherDAO {
	
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
	
	public List<Teacher> selectAll() throws SQLException{
		List <Teacher> teacherList = new ArrayList<Teacher>();
		
		try(Connection connection = getConnection()){
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Teacher;");
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			Teacher teacher = new Teacher();
			teacher.setTeacherId(rs.getInt("teacherId"));
			teacher.setTeacherName(rs.getString("teacherName"));
			teacher.setTeacherSalary(rs.getInt("teacherSalary"));
			teacher.setTeacherExperience(rs.getInt("teacherExperience"));
			teacher.setClassId(rs.getInt("classId"));
			
			teacherList.add(teacher);
		}
		}catch(Exception e) {
			System.out.println("Exception Raised...");
			System.out.println(e.getMessage());
		}
		return teacherList;
		
	}
	
	public Teacher select(int teacherId) throws SQLException {
		Teacher teacher = new Teacher();
		
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("Select * from Teacher where teacherId = ?;");
			statement.setInt(1,teacherId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				teacher.setTeacherId(rs.getInt("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setTeacherSalary(rs.getInt("teacherSalary"));
				teacher.setTeacherExperience(rs.getInt("teacherExperience"));
				teacher.setClassId(rs.getInt("classId"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return teacher;
	}
	
	public void update(Teacher teacher) {
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("update  Teacher set teacherName = ?, "
					+ "teacherSalary = ?, teacherExperience = ?, classId = ?  where teacherId = ?;");
			statement.setString(1,teacher.getTeacherName());
			statement.setInt(2,teacher.getTeacherSalary());
			statement.setInt(3,teacher.getTeacherExperience());
			statement.setInt(4,teacher.getClassId());
			statement.setInt(5,teacher.getTeacherId());
			int rs = statement.executeUpdate();
			System.out.println(rs+"success");

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void delete(int teacherId) {
		try {
			Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM teacher WHERE teacherId = ?;");
            statement.setInt(1, teacherId);
            int result = statement.executeUpdate();
            System.out.println("delete successful");
            connection.close();
        } catch (Exception ex) {
            System.out.println("Exception Raised...");
            System.out.println(ex.getMessage());
        }
	}
	

	public void insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
            Connection connection = getConnection();
            
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Teacher(teacherId, teacherName, teacherSalary, teacherExperience, classId) VALUES(?,?,?,?,?);");
            statement.setInt(1, teacher.getTeacherId());
            statement.setString(2, teacher.getTeacherName());
            statement.setInt(3, teacher.getTeacherSalary());
            statement.setInt(4,  teacher.getTeacherExperience());
            statement.setInt(5, teacher.getClassId());
            
            int result = statement.executeUpdate();
            System.out.println("successful");
            connection.close();
        } catch (Exception ex) {
            System.out.println("Exception Raised...");
            System.out.println(ex.getMessage());
        }
	}
	public List<String> selectName(int classId){
		List<String> list = new ArrayList<String>();
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Select teacherName from teacher where classId=? ");
			statement.setInt(1, classId);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("teacherName"));

			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
