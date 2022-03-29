package com.wkcto.mybatis.domain;

public class Student {
	/*
	 *注意：以下的属性名和数据库表当中的字段名不一致。 
	 */
	private String sid;
	private String sname;
	private String sbirth;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSbirth() {
		return sbirth;
	}

	public void setSbirth(String sbirth) {
		this.sbirth = sbirth;
	}

}
