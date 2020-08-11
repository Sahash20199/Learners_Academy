package com.la.models;

public class SubjectClass {
	private int classid;
	private String sub_name1;
	private String sub_name2;
	private String sub_name3;
	private String tut_name1;
	private String tut_name2;
	private String tut_name3;
	
	public SubjectClass() {
		super();
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getSub_name1() {
		return sub_name1;
	}
	public void setSub_name1(String sub_name1) {
		this.sub_name1 = sub_name1;
	}
	public String getSub_name2() {
		return sub_name2;
	}
	public void setSub_name2(String sub_name2) {
		this.sub_name2 = sub_name2;
	}
	public String getSub_name3() {
		return sub_name3;
	}
	public void setSub_name3(String sub_name3) {
		this.sub_name3 = sub_name3;
	}
	@Override
	public String toString() {
		return "SubjectClass [classid=" + classid + ", sub_name1=" + sub_name1 + ", sub_name2=" + sub_name2
				+ ", sub_name3=" + sub_name3 + ", tut_name1=" + tut_name1 + ", tut_name2=" + tut_name2 + ", tut_name3="
				+ tut_name3 + "]";
	}
	public String getTut_name1() {
		return tut_name1;
	}
	public void setTut_name1(String tut_name1) {
		this.tut_name1 = tut_name1;
	}
	public String getTut_name2() {
		return tut_name2;
	}
	public void setTut_name2(String tut_name2) {
		this.tut_name2 = tut_name2;
	}
	public String getTut_name3() {
		return tut_name3;
	}
	public void setTut_name3(String tut_name3) {
		this.tut_name3 = tut_name3;
	}
	

	
}
