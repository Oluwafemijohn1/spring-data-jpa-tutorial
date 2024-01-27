package com.ephemzy.spring.data.jpatutrorial.repository;

import com.ephemzy.spring.data.jpatutrorial.entity.Course;
import com.ephemzy.spring.data.jpatutrorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Lankan")
                .lastName("Kanmi")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(4)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecord = PageRequest.of(0,3);

        Pageable secondPageWithTwoRecord = PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecord).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecord).getTotalElements();
        int totalPages = courseRepository.findAll(firstPageWithThreeRecord).getTotalPages();

        System.out.println("Total pages " + totalPages );
        System.out.println("Total element " + totalElements );
        System.out.println("Courses " + courses );
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2,
                Sort.by("title").descending()
                        .and(Sort.by("credit"))
        );
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Courses " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
        System.out.println("Courses Custom" + courses);
        System.out.println("Courses Custom size" + courses.size());
    }

}