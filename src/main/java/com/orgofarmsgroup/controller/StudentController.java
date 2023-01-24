package com.orgofarmsgroup.controller;

import com.google.gson.Gson;
import com.orgofarmsgroup.entity.StudentEntity;
import com.orgofarmsgroup.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final Gson jsonHelper;
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;
    @PostMapping
    public StudentEntity post(@RequestBody StudentEntity student) {
        return studentRepository.save(student);
    }
}
