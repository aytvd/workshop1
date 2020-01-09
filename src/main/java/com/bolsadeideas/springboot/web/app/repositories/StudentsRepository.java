package com.bolsadeideas.springboot.web.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.web.app.models.Students;

public interface StudentsRepository extends PagingAndSortingRepository<Students, Integer> {

}
