package com.la.models;

public class Student {

	int studentId;
	String studentName;
	int studentAge;
	int classId;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public Student(int studentId, String studentName, int studentAge, int classId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.classId = classId;
	}
	
	public Student(String studentName, int studentAge, int classId) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.classId = classId;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", classId=" + classId + "]";
	}
	
	
	
}
