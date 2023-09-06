package com.basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Old Pkg Name: "PERSISTENT API: a kind of specification"=> javax.persistence.*, but from now onward: jakarta.persistence.*

//@Entity = Table
//@Id  => Primary Key

//@Entity:  default name: class name in camelCase i.e: "student"
//@Entity("student_details"):  explicitely mentioning different name

@Entity
public class Student {

	@Id
	private int id;

	private String name;
	private String city;
	
	private Certificate certi;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", certi=" + certi + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

}
