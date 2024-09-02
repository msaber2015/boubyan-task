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
@Table(name = "courses")
@Entity
public class Course {

    @Id
    @SequenceGenerator(name = "COURSE_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "COURSE_SEQ")
    @GeneratedValue(generator = "COURSE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;
}
