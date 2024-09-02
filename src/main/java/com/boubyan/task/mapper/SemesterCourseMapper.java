package com.boubyan.task.mapper;

import com.boubyan.task.model.dto.SemesterCourseDTO;
import com.boubyan.task.model.entity.SemesterCourse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SemesterCourseMapper {

    List<SemesterCourseDTO> map(List<SemesterCourse> semesterCourses);
}
