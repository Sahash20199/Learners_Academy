 package com.la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.la.models.Class;

public class ClassDAO {

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
	public void insertClass(Class class1) {

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement("insert into class(classId, className) values(?, ?);");
			statement.setInt(1, class1.getClassId());
			statement.setString(2, class1.getClassName());
			int result = statement.executeUpdate();
			System.out.println(result + " Class Added Successfully.");
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Class selectClass(int classId) {
		Class class1 = new Class();
		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement("select * from CLASS where classId= ?;");
			statement.setInt(1, classId);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				class1.setClassId(rs.getInt("classId"));
				class1.setClassName(rs.getString("className"));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return class1;
	}

	public List<Class> selectAllClass() {

		List<Class> classList = new ArrayList<Class>();

		try {

			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM CLASS");
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Class class1 = new Class();
				class1.setClassId(rs.getInt("classId"));
				class1.setClassName(rs.getString("className"));
				classList.add(class1);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return classList;

	}


	public void deleteClass(int classId) {
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from class where classId = ?;");
			statement.setInt(1, classId);
			int result = statement.executeUpdate();
			System.out.println(result + " Class Deleted Successfully.");
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update(Class class1) {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("update  class set className=? where classId = ?;");
			statement.setString(1,class1.getClassName());
			statement.setInt(2,class1.getClassId());
			int rs = statement.executeUpdate();
		
			System.out.println(rs+"success");

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}