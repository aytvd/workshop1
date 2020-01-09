package com.bolsadeideas.springboot.web.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.web.app.models.Courses;
import com.bolsadeideas.springboot.web.app.services.CoursesServices;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	private CoursesServices service;
	
	@Autowired
	public CourseController(CoursesServices service) {
		this.service = service;
	}

	@GetMapping
	@ResponseBody
	public Page<Courses> findAll(@SortDefault(sort="name", direction= Direction.ASC) @PageableDefault(size=50, page =0) Pageable pageable){
		return this.service.findAll(pageable);
	}
	
	@GetMapping("/all")
	@ResponseBody
	public Iterable<Courses> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Courses> create(@Valid @RequestBody Courses course){
		Courses savedCourse =this.service.create(course);
		
		return new ResponseEntity<>(savedCourse, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Courses> update(@PathVariable(value = "id") Integer id, @RequestBody Courses course){
		Courses savedCourse = this.service.update(id, course);
		
		return new ResponseEntity<>(savedCourse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Courses> findById(@PathVariable(value ="id") Integer id ){
		Courses findCourse = this.service.findById(id);			
		return new ResponseEntity<Courses>(findCourse, HttpStatus.OK);	
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Courses> delete(@PathVariable(value="id") Integer id){
		this.service.delete(id);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
