package com.boubyan.task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseAppointmentDTO {
    private Long id;
    private DayOfWeek day;
    private String time;
}
