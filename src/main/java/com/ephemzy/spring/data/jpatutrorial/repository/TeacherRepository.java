package com.ephemzy.spring.data.jpatutrorial.repository;

import com.ephemzy.spring.data.jpatutrorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
