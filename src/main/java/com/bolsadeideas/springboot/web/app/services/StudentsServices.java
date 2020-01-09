package com.bolsadeideas.springboot.web.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.web.app.models.Students;

public interface StudentsServices {
	
    Students create(Students student);

    Students update(Integer id, Students student);
    
    Iterable<Students> findAll();

    Students findById(Integer id);

    void delete(Integer id);
    
    Page<Students> findAll(Pageable pageable);
}
