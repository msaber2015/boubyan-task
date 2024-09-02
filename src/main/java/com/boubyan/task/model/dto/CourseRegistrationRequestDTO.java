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
public class CourseRegistrationRequestDTO {
    private Set<CourseRegistrationItemDTO> coursesItems;
}