package com.maytech.lms.entitty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	
	//instructor_id, instructor_name, instructor_training_exp, Instructor_email
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private int id;
	
	@Column(name = "instructor_name")
	private String name;
	
	@Column(name = "instructor_training_exp")
	private String teachingexp;
	
	@Column(name = "Instructor_email")
	private String email;
	
	

	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instructor(int id, String name, String teachingexp, String email) {
		super();
		this.id = id;
		this.name = name;
		this.teachingexp = teachingexp;
		this.email = email;
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

	public String getTeachingexp() {
		return teachingexp;
	}

	public void setTeachingexp(String teachingexp) {
		this.teachingexp = teachingexp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", teachingexp=" + teachingexp + ", email=" + email + "]";
	}
	
	
}
