package com.bolsadeideas.springboot.web.app.controllers;

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
import com.bolsadeideas.springboot.web.app.models.Students;
import com.bolsadeideas.springboot.web.app.services.StudentsServices;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private StudentsServices service;
	
	@Autowired
	public StudentController(StudentsServices service) {
		this.service= service;
	}
	

	@GetMapping
	@ResponseBody
	public Page<Students> findAll(@SortDefault(sort="fullName", direction= Direction.ASC) @PageableDefault(size=50, page =0) Pageable pageable){
		return this.service.findAll(pageable);
	}
	
	@GetMapping("/all")
	@ResponseBody
	public Iterable<Students> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Students> create(@RequestBody Students student){
		Students savedStudent =this.service.create(student);
		
		return new ResponseEntity<>(savedStudent, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Students> update(@PathVariable(value = "id") Integer id, @RequestBody Students student){
		Students savedStudent = this.service.update(id, student);
		
		return new ResponseEntity<>(savedStudent, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Students> findById(@PathVariable(value ="id") Integer id ){
		Students findStudent = this.service.findById(id);			
		return new ResponseEntity<Students>(findStudent, HttpStatus.OK);	
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Students> delete(@PathVariable(value="id") Integer id){
		this.service.delete(id);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	

}
