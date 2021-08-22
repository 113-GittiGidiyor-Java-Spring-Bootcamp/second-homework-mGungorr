package dev.patika.homework.controller;

import dev.patika.homework.model.Courses;
import dev.patika.homework.model.Instructors;
import dev.patika.homework.service.CourseService;
import dev.patika.homework.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
    InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructors>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(),HttpStatus.OK);
    }
}
