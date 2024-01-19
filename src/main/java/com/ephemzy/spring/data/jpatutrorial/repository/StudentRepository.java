package com.ephemzy.spring.data.jpatutrorial.repository;

import com.ephemzy.spring.data.jpatutrorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /**
     * JPA Query creation methods <a href="https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html">Link here</a>
     * */
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student  s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student  s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);
}
