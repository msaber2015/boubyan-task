package com.boubyan.task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private double salary;
}
