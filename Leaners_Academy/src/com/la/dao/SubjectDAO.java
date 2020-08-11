 package com.la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.la.models.Subject;

public class SubjectDAO {

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
	public void insertSubject(Subject subject) {

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement("insert into Subject(subjectId, subjectName, classId, teacherId) values(?, ?, ?, ?);");
			statement.setInt(1, subject.getSubjectId());
			statement.setString(2, subject.getSubjectName());
			statement.setInt(3, subject.getClassId());
			statement.setInt(4, subject.getTeacherId());

			int result = statement.executeUpdate();
			System.out.println(result + " Subject Added Successfully.");
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public Subject selectSubject(int subjectId) {
		Subject subject = new Subject();
		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement("select * from Subject where subjectId= ?;");
			statement.setInt(1, subjectId);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				subject.setSubjectId(rs.getInt("subjectId"));
				subject.setSubjectName(rs.getString("subjectName"));
				subject.setClassId(rs.getInt("classId"));
				subject.setTeacherId(rs.getInt("teacherId"));

			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return subject;

	}

	public List<Subject> selectAllSubject() {

		List<Subject> subjectList = new ArrayList<Subject>();

		try {

			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Subject");
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setSubjectId(rs.getInt("subjectId"));
				subject.setSubjectName(rs.getString("subjectName"));
				subject.setClassId(rs.getInt("classId"));
				subject.setTeacherId(rs.getInt("teacherId"));				
				subjectList.add(subject);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return subjectList;

	}

	
//
	public void deleteSubject(int subjectId) {
		try {

			Connection connection = getConnection();
			PreparedStatement statement = connection
					.prepareStatement("delete from subject where subjectId = ?;");
			statement.setInt(1, subjectId);
			int result = statement.executeUpdate();
			System.out.println(result + " subject Deleted Successfully.");
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("update  subject set subjectName=?, classId = ?, teacherId = ? where subjectId = ?;");
			statement.setString(1,subject.getSubjectName());
			statement.setInt(2,subject.getClassId());
			statement.setInt(3,subject.getTeacherId());
			statement.setInt(4,subject.getSubjectId());
			int rs = statement.executeUpdate();
		
			System.out.println(rs+"success");

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public List<String> selectName(int classId){
		List<String> list = new ArrayList<String>();
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Select subjectName from subject where classId=? ");
			statement.setInt(1, classId);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("subjectName"));

			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}