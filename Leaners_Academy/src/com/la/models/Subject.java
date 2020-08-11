package com.la.models;

public class Subject {
	
	int subjectId;
	String subjectName;
	int classId;
	int teacherId;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public Subject(int subjectId, String subjectName, int classId, int teacherId) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.classId = classId;
		this.teacherId = teacherId;
	}
	public Subject(String subjectName, int classId, int teacherId) {
		super();
		this.subjectName = subjectName;
		this.classId = classId;
		this.teacherId = teacherId;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", classId=" + classId
				+ ", teacherId=" + teacherId + "]";
	}
	
	

}
