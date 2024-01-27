package com.ephemzy.spring.data.jpatutrorial.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(
        exclude = "course"
)
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            allocationSize = 1,
            sequenceName = "course_material_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL, // it will perform all the defined operations,
            // normal, if the course is not inserted, the course material will not be inserted as well.
            fetch = FetchType.LAZY, // If we want to fetch course material, it will not fetch the course
            // itself unless it is changed to eager
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
