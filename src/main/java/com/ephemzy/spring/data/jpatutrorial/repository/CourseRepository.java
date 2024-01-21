package com.ephemzy.spring.data.jpatutrorial.repository;

import com.ephemzy.spring.data.jpatutrorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
