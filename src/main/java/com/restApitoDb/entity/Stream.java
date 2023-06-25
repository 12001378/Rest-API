package com.restApitoDb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stream_Table")
public class Stream {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int streamId;
	@Column(name = "Stream_name")
	private String name;
	private int salary;
	@OneToOne(mappedBy = "stream")
	@JsonBackReference
	private Employee employee;
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getStreamId() {
		return streamId;
	}
	public void setStreamId(int streamId) {
		this.streamId = streamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
