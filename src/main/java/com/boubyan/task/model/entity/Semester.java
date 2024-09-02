package com.boubyan.task.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "semesters")
@Entity
public class Semester {

    @Id
    @SequenceGenerator(name = "SEMESTER_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "SEMESTER_SEQ")
    @GeneratedValue(generator = "SEMESTER_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ColumnDefault("1")
    private boolean active;
}
