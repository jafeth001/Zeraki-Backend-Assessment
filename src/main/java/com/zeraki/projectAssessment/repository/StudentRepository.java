package com.zeraki.projectAssessment.repository;

import com.zeraki.projectAssessment.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1%")
    List<Student> searchBYName(String name);

    List<Student> findByOrderByNameAsc(Sort sort);
}
