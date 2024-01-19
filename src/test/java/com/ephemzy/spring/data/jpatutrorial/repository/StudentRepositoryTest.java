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
                .email("guardian2@gmail.com")
                .mobile("080212345672")
                .name("Guardian2")
                .build();

        Student student = Student.builder()
                .emailId("tolaogun2@gmail.com")
                .firstName("Tolani2")
                .lastName("ogun2")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Tolani2");
        System.out.println("Students by first name = " + students);
    }

    @Test
    public void findByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("to");
        System.out.println("Students  = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("to");
        System.out.println("Students  = " + students);
    }

    @Test
    public void findByLastNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("Students  = " + students);
        System.out.println("studentList size  = " + students.size());
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("tolaogun2@gmail.com");
        System.out.println("Student by email address = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("tolaogun2@gmail.com");
        System.out.println("Student by email address = " + studentFirstName);
    }

    @Test
    public void printStudentFirstNameByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("tolaogun2@gmail.com");
        System.out.println("Student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("tolaogun2@gmail.com");
        System.out.println("Student = " + student);
    }
}