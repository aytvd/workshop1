package com.bolsadeideas.springboot.web.app.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.bolsadeideas.springboot.web.app.validators.ValidRut;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idStudent;
	
	@NotEmpty(message = "Please providea full name")
	private String fullName;
	
	@ValidRut
	private String rut;
	
	//@ManyToOne
	//@JoinColumn(name = "id")
	//private Courses course;
	
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
	//@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id")
    private Courses course;
	
	
	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	

}
