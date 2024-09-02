package com.boubyan.task.controller;


import com.boubyan.task.model.dto.CourseRegistrationRequestDTO;
import com.boubyan.task.model.dto.CourseRegistrationResponseDTO;
import com.boubyan.task.model.dto.LoginResponseDTO;
import com.boubyan.task.model.dto.SemesterCourseDTO;
import com.boubyan.task.service.CourseService;
import com.boubyan.task.service.UserService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "bearerAuth")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/")
    public List<SemesterCourseDTO> getAll() {
        return courseService.getAll();
    }

    @PostMapping("/register")
    public void register(@RequestBody CourseRegistrationRequestDTO request){
        courseService.register(request);
    }

    @DeleteMapping("/cancel/{courseRegistrationId}")
    public void cancel(@PathVariable Long courseRegistrationId) {
        courseService.cancel(courseRegistrationId);
    }
}
