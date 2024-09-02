package com.boubyan.task.service;

import com.boubyan.task.config.security.AuthUtil;
import com.boubyan.task.mapper.SemesterCourseMapper;
import com.boubyan.task.model.dto.CourseRegistrationRequestDTO;
import com.boubyan.task.model.dto.SemesterCourseDTO;
import com.boubyan.task.model.entity.CourseAppointment;
import com.boubyan.task.model.entity.CourseRegistration;
import com.boubyan.task.model.entity.SemesterCourse;
import com.boubyan.task.repository.CourseRegistrationRepository;
import com.boubyan.task.repository.SemesterCourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CourseService {

    private final SemesterCourseRepository semesterCourseRepository;
    private final SemesterCourseMapper semesterCourseMapper;
    private final AuthUtil authUtil;
    private final CourseRegistrationRepository courseRegistrationRepository;

    @Cacheable("courses")
    public List<SemesterCourseDTO> getAll() {
        return semesterCourseMapper.map(semesterCourseRepository.findBySemesterActiveTrueOrderBySemesterIdAsc());
    }

    public void register(CourseRegistrationRequestDTO request) {
        List<CourseRegistration> courses = request.getCoursesItems().stream().map(item -> CourseRegistration.builder()
                .semesterCourse(SemesterCourse.builder().id(item.getSemesterCourseId()).build())
                .courseAppointment(CourseAppointment.builder().id(item.getCourseAppointmentId()).build())
                .user(authUtil.getUserDetails())
                .build()).toList();
        courseRegistrationRepository.saveAll(courses);
    }

    public void cancel(Long courseRegistrationId) {
        courseRegistrationRepository.deleteById(courseRegistrationId);
    }
}
