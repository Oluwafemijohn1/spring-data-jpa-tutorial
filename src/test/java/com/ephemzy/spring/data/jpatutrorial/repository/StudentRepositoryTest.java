package com.ephemzy.spring.data.jpatutrorial.repository;

import com.ephemzy.spring.data.jpatutrorial.entity.Guardian;
import com.ephemzy.spring.data.jpatutrorial.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("femiogun2@gmail.com")
                .firstName("femi")
                .lastName("ogun")
//                .guardianEmail("guardian@gmail.com")
//                .guardianMobile("081111111111")
//                .guardianName("My Guardian")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("guardian@gmail.com")
                .mobile("081111111111")
                .name("My Guardian")
                .build();

        Student student = Student.builder()
                .emailId("femiogun1@gmail.com")
                .firstName("femi")
                .lastName("ogun")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
}