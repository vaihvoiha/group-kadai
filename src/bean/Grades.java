package bean;

import java.io.Serializable;

public class Grades implements Serializable {
	private int ent_year;
	private String class_num;
	private String no;
	private String name;
	private int point;
	public int getEnt_year() {
		return ent_year;
	}
	public void setEnt_year(int ent_year) {
		this.ent_year = ent_year;
	}
	public String getClass_num() {
		return class_num;
	}
	public void setClass_num(String class_num) {
		this.class_num = class_num;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}


}
