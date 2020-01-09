package com.bolsadeideas.springboot.web.app.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.web.app.exception.NotFoundException;
import com.bolsadeideas.springboot.web.app.models.Courses;
import com.bolsadeideas.springboot.web.app.repositories.CoursesRepository;

@Service
public class CoursesServicesImpl implements CoursesServices {

	private CoursesRepository repository;

    @Autowired
    public CoursesServicesImpl(CoursesRepository repository) {
        this.repository = repository;
    }
    
	@Override
	public Iterable<Courses> findAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}
	
	@Override
	public Page<Courses> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.repository.findAll(pageable);
	}
	
	@Override
	public Courses create(Courses courses) {
		// TODO Auto-generated method stub
		return this.repository.save(courses);
	}

	@Override
	public Courses update(Integer id, Courses course) {
		// TODO Auto-generated method stub
		Courses savedCourse = this.findById(id);
		savedCourse.setName(course.getName());
		savedCourse.setDuration(course.getDuration());
		
		return this.repository.save(savedCourse);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Courses deleteCourse = this.findById(id);
		this.repository.delete(deleteCourse);
	}

	@Override
	public Courses findById(Integer id) {
		Optional<Courses> possibleCourse = this.repository.findById(id);
		if(!possibleCourse.isPresent()) {
			// no encontrado disparar error
			//throw new  NotFoundException();
			throw new EntityNotFoundException("Curso con Id " + id.toString() + " no encontrado en la Base de Datos");
		}
		
		return possibleCourse.get();
		//return this.repository.findById(id).orElseThrow(()-> new NotFoundExceptio NotFoundException()n());
	}


}
