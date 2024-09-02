package com.boubyan.task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRegistrationItemDTO {
    private Long semesterCourseId;
    private Long courseAppointmentId;
}
