package com.boubyan.task.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "course_appointments")
@Entity
public class CourseAppointment {

    @Id
    @SequenceGenerator(name = "COURSE_APPOINTMENT_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "COURSE_APPOINTMENT_SEQ")
    @GeneratedValue(generator = "COURSE_APPOINTMENT_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_course_id")
    private SemesterCourse semesterCourse;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    private String time;
}
