package com.bolsadeideas.springboot.web.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.web.app.models.Courses;
import com.bolsadeideas.springboot.web.app.models.Students;
import com.bolsadeideas.springboot.web.app.repositories.StudentsRepository;

@Service
public class StudentsServicesImpl implements StudentsServices {

	private StudentsRepository repository;
	
	@Autowired
	public StudentsServicesImpl(StudentsRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Students create(Students student) {
		// TODO Auto-generated method stub
		return this.repository.save(student);
	}

	@Override
	public Students update(Integer id, Students student) {
		// TODO Auto-generated method stub
		Students savedStudent = this.findById(id);
		savedStudent.setFullName(student.getFullName());
		
		return this.repository.save(savedStudent);

	}

	@Override
	public Iterable<Students> findAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Students findById(Integer id) {
		Optional<Students> possibleStudent = this.repository.findById(id);
		if(!possibleStudent.isPresent()) {
			// no encontrado disparar error
		}
		return possibleStudent.get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Students deleteStudent = this.findById(id);
		this.repository.delete(deleteStudent);

	}

	@Override
	public Page<Students> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return  this.repository.findAll(pageable);
	}

}
