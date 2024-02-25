package com.zeraki.projectAssessment.controller;

import com.zeraki.projectAssessment.entity.Student;
import com.zeraki.projectAssessment.exception.ConflictException;
import com.zeraki.projectAssessment.exception.NoSuchException;
import com.zeraki.projectAssessment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student, @RequestParam Long courseId, @RequestParam Long instId) throws ConflictException {
        return ResponseEntity.ok(studentService.addStudent(student, courseId, instId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> listAllStudents() throws NoSuchException {
        return ResponseEntity.ok(studentService.listAllStudents());
    }
    @DeleteMapping("/delete")
    ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @PutMapping("/edit")
    ResponseEntity<Student> editStudentName(@RequestBody Student student, @RequestParam Long id) throws ConflictException {
        return ResponseEntity.ok(studentService.editStudentName(student, id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchAllStudents(@RequestParam String name) {
        return ResponseEntity.ok(studentService.searchAllStudents(name));
    }

    @GetMapping("/sort/asc/course")
    public ResponseEntity<List<Student>> getSortStudentByCourse() throws NoSuchException {
        return ResponseEntity.ok(studentService.getSortStudentByCourse());
    }

    @PutMapping("/transfer")
    public ResponseEntity<Student> transferStudent(@RequestParam Long stdId, @RequestParam Long instId) {
        return ResponseEntity.ok(studentService.transferStudent(stdId, instId));
    }

    @PutMapping("/change-course")
    public ResponseEntity<Student> changeCourse(@RequestParam Long stdId, @RequestParam Long courseId) {
        return ResponseEntity.ok(studentService.changeCourse(stdId, courseId));
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Student>> findStudentWithPagination(@RequestParam int offset, @RequestParam int pageSize) {
        return ResponseEntity.ok(studentService.findStudentWithPagination(offset, pageSize));
    }
}