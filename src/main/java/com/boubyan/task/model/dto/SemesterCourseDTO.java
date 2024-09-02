package com.boubyan.task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SemesterCourseDTO {
    private Long id;
    private CourseDTO course;
    private SemesterDTO semester;
    private String constructor;
    private Set<CourseAppointmentDTO> appointments;
}
