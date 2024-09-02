package com.boubyan.task.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "semester_courses")
@Entity
public class SemesterCourse {

    @Id
    @SequenceGenerator(name = "SEMESTER_COURSE_SEQ", initialValue = 1, allocationSize = 1, sequenceName = "SEMESTER_COURSE_SEQ")
    @GeneratedValue(generator = "SEMESTER_COURSE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    private String constructor;

    @OneToMany
    private Set<CourseAppointment> appointments;
}
