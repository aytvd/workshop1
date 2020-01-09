package com.bolsadeideas.springboot.web.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.web.app.models.Courses;

public interface CoursesServices {
	
    Courses create(Courses courses);

    Courses update(Integer id, Courses courses);
    
    Iterable<Courses> findAll();

    Courses findById(Integer id);

    void delete(Integer id);
    
    Page<Courses> findAll(Pageable pageable);

}
