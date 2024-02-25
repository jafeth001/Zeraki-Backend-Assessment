package com.zeraki.projectAssessment.repository;

import com.zeraki.projectAssessment.entity.Course;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    public Course findByName(String name);
    @Query("SELECT c FROM Course c WHERE c.name LIKE %?1%")
    public List<Course> searchBYName(String name);

    List<Course> findByOrderByNameAsc(Sort sort);
}
