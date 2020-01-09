package com.bolsadeideas.springboot.web.app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Courses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	//@NotEmpty(message = "Please provide a name")
	private String name;
	
	//@NotEmpty(message = "Please provide a duration")
	private Integer duration;
	
	
	@JsonManagedReference
    @OneToMany(mappedBy = "course", cascade = {CascadeType.PERSIST})
	 //@OneToMany(mappedBy = "course",cascade = {CascadeType.PERSIST}, orphanRemoval = true)
	private List<Students> students;

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	

}
