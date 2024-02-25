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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final InstitutionRepository institutionRepository;
    private final CourseRepository courseRepository;

    public Student addStudent(Student student, Long courseId, Long instId) throws ConflictException {
        Student std = studentRepository.findByName(student.getName());
        Course course = courseRepository.findById(courseId).get();
        Institution institution = institutionRepository.findById(instId).get();
        if (std == null) {
            Student newStudent = Student.builder()
                    .institution(institution)
                    .course(course)
                    .name(student.getName())
                    .email(student.getEmail())
                    .phone(student.getPhone())
                    .build();
            return studentRepository.save(newStudent);
        }
        throw new ConflictException("student with same name " + student.getName() + " exits");
    }

    public String deleteStudent(Long id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
        return "student deleted successfully";
    }

    public List<Student> listAllStudents() throws NoSuchException {
        List<Student> students = studentRepository.findAll();
        if (!students.isEmpty()) {
            return students;
        }
        throw new NoSuchException("no students available");
    }

    public Student editStudentName(Student student, Long id) throws ConflictException {
        Student savedstudent = studentRepository.findById(id).get();
        if (Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())) {
            savedstudent.setName(student.getName());
        }
        if (Objects.nonNull(student.getPhone()) && !"".equalsIgnoreCase(student.getPhone())) {
            savedstudent.setPhone(student.getPhone());
        }
        return studentRepository.save(savedstudent);

    }

    public List<Student> searchAllStudents(String name) {
        if (name != null) {
            return studentRepository.searchBYName(name);
        }
        return studentRepository.findAll();
    }

    public Student transferStudent(Long stdId, Long instId) {
        Institution institution = institutionRepository.findById(instId).get();
        Student student = studentRepository.findById(stdId).get();
        student.setInstitution(institution);
        return studentRepository.save(student);
    }

    public Student changeCourse(Long stdId, Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        Student student = studentRepository.findById(stdId).get();
        student.setCourse(course);
        return studentRepository.save(student);
    }

    public List<Student> getSortStudentByCourse() throws NoSuchException {
        Sort sort = Sort.by(Sort.Order.asc("course"));
        List<Student> students = studentRepository.findAll();
        if (!students.isEmpty()) {
            return studentRepository.findByOrderByNameAsc(sort);
        }
        throw new NoSuchException("no available courses");
    }

    public Page<Student> findStudentWithPagination(int offset, int pageSize) {
        Page<Student> students = studentRepository.findAll(PageRequest.of(offset, pageSize));
        return students;
    }

}