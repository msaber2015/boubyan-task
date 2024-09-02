package com.boubyan.task.specification;

import com.boubyan.task.model.entity.SemesterCourse;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SemesterCourseSpecification implements Specification<SemesterCourse> {

    private Long semesterId;
    private String semesterName;
    private Long courseId;
    private String courseName;
    private Boolean semesterActive;

    @Override
    public Predicate toPredicate(Root<SemesterCourse> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        if (this.getCourseId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("semester").get("id"), this.getSemesterId()));
        }
        if (this.getSemesterName() != null) {
            predicates.add(criteriaBuilder.equal(root.get("semester").get("name"), this.getSemesterName()));
        }
        if (this.getSemesterActive() != null) {
            predicates.add(criteriaBuilder.equal(root.get("semester").get("isActive"), this.getSemesterActive()));
        }
        if (this.getCourseId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("course").get("id"), this.getCourseId()));
        }
        if (this.getSemesterName() != null) {
            predicates.add(criteriaBuilder.equal(root.get("course").get("name"), this.getCourseName()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
