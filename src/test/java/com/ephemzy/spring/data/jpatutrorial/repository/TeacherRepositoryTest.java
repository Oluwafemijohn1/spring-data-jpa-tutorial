package com.ephemzy.spring.data.jpatutrorial.repository;

import com.ephemzy.spring.data.jpatutrorial.entity.Course;
import com.ephemzy.spring.data.jpatutrorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title(".net")
                .credit(3)
                .build();
//        Course course2 = Course.builder()
//                .title("JavaScript")
//                .credit(4)
//                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Lekan")
                .lastName("Kunle")
                .courses(List.of(course))
                .build();

        repository.save(teacher);
    }

}