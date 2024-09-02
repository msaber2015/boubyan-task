package com.boubyan.task.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "course_registration")
@Entity
public class CourseRegistration {

    @Id
    @SequenceGenerator(name = "COURSE_REGISTRATION_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "COURSE_REGISTRATION_SEQ")
    @GeneratedValue(generator = "COURSE_REGISTRATION_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "semester_course_id")
    private SemesterCourse semesterCourse;

    @ManyToOne
    @JoinColumn(name = "course_appointment_id")
    private CourseAppointment courseAppointment;
}
