package com.la.models;

public class Teacher {
	
	int teacherId;
	String teacherName;
	int teacherSalary;
	int teacherExperience;
	int classId;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getTeacherSalary() {
		return teacherSalary;
	}

	public void setTeacherSalary(int teacherSalary) {
		this.teacherSalary = teacherSalary;
	}

	public int getTeacherExperience() {
		return teacherExperience;
	}

	public void setTeacherExperience(int teacherExperience) {
		this.teacherExperience = teacherExperience;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public Teacher(int teacherId, String teacherName, int teacherSalary, int teacherExperience, int classId) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherSalary = teacherSalary;
		this.teacherExperience = teacherExperience;
		this.classId = classId;
	}

	public Teacher(String teacherName, int teacherSalary, int teacherExperience, int classId) {
		super();
		this.teacherName = teacherName;
		this.teacherSalary = teacherSalary;
		this.teacherExperience = teacherExperience;
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherSalary=" + teacherSalary
				+ ", teacherExperience=" + teacherExperience + ", classId=" + classId + "]";
	}
	
	

}
