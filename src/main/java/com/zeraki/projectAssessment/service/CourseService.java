package com.zeraki.projectAssessment.service;

import com.zeraki.projectAssessment.entity.Course;
import com.zeraki.projectAssessment.entity.Institution;
import com.zeraki.projectAssessment.entity.Student;
import com.zeraki.projectAssessment.exception.ConflictException;
import com.zeraki.projectAssessment.exception.NoSuchException;
import com.zeraki.projectAssessment.repository.CourseRepository;
import com.zeraki.projectAssessment.repository.InstitutionRepository;
import com.zeraki.projectAssessment.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstitutionRepository institutionRepository;
    private final StudentRepository studentRepository;

    public Course addCourse(Course course) throws ConflictException {
        Course newCourse = courseRepository.findByName(course.getName());
        if (newCourse == null) {
            return courseRepository.save(course);
        }
        throw new ConflictException("course with the same name " + course.getName() + " already exists");
    }

    public List<Course> getByAll() throws NoSuchException {
        List<Course> courses = courseRepository.findAll();
        if (!courses.isEmpty()) {
            return courses;
        }
        throw new NoSuchException("no courses available");
    }

    public List<Course> getBysearching(String name) {
        List<Course> courses = courseRepository.searchBYName(name);
        if (courses != null) {
            return courses;
        }
        return courseRepository.findAll();
    }

    public List<Course> getSortedCoursesByName() throws NoSuchException {
        Sort sort = Sort.by(Sort.Order.asc("name"));
        List<Course> courses = courseRepository.findByOrderByNameAsc(sort);
        if (!courses.isEmpty()) {
            return courses;
        }
        throw new NoSuchException("no available courses");
    }

    public Course editCourse(Course course, Long id) throws ConflictException {
        Course savedcourse = courseRepository.findById(id).get();
        Course name = courseRepository.findByName(savedcourse.getName());
        if (Objects.nonNull(course.getName()) && !"".equalsIgnoreCase(course.getName())) {
            savedcourse.setName(course.getName());
        }
        return courseRepository.save(savedcourse);
    }


    public String deleteCourse(Long id) throws ConflictException {
        Course course = courseRepository.findById(id).get();
        courseRepository.deleteById(id);
        return "course successfully deleted";
    }

}

