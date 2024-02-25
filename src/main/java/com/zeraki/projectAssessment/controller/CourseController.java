package com.zeraki.projectAssessment.controller;

import com.zeraki.projectAssessment.entity.Course;
import com.zeraki.projectAssessment.entity.Institution;
import com.zeraki.projectAssessment.exception.ConflictException;
import com.zeraki.projectAssessment.exception.NoSuchException;
import com.zeraki.projectAssessment.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) throws ConflictException {
        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getByAll() throws NoSuchException {
        return ResponseEntity.ok(courseService.getByAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Course>> getBysearching(@RequestParam String name) {
        return ResponseEntity.ok(courseService.getBysearching(name));
    }

    @GetMapping("/sort/asc/name")
    public ResponseEntity<List<Course>> getSortedCoursesByName() throws NoSuchException {
        return ResponseEntity.ok(courseService.getSortedCoursesByName());
    }

    @PutMapping("/edit")
    public ResponseEntity<Course> editCourse(@RequestBody Course course, @RequestParam Long id) throws ConflictException {
        return ResponseEntity.ok(courseService.editCourse(course, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCourse(@RequestParam Long id) throws ConflictException {
        return ResponseEntity.ok(courseService.deleteCourse(id));
    }


}
