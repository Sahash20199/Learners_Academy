package com.la.models;

public class Class {

	int classId;
	String className;
	
	public Class() {
		super();
	}
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Class(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}
	public Class(String className) {
		super();
		this.className = className;
	}
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + "]";
	}
	
	
	
	
}
