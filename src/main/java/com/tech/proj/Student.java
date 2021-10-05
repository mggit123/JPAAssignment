package com.tech.proj;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@SequenceGenerator(name="myGenerator",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "myGenerator")
	private Integer rollNo;
	private String name;
	private String address;
	private long phone;

	public Student(String name, String address, long phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
}}
