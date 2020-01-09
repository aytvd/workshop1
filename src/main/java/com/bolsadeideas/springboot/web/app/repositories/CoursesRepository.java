package com.bolsadeideas.springboot.web.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.web.app.models.Courses;

public interface CoursesRepository extends PagingAndSortingRepository<Courses, Integer> {

}