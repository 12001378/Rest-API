package com.restApitoDb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_db")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String age;
	
	//uni_Directional Mapping.
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Stream stream;
	
	
	public Employee(int id, String name, String age, Stream stream) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.stream = stream;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", stream=" + stream + "]";
	}
	public int getId() {
		return id;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Stream getStream() {
		return stream;
	}
	public void setStream(Stream stream) {
		this.stream = stream;
	}
	

}
