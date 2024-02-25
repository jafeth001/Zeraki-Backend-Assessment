package com.zeraki.projectAssessment.repository;

import com.zeraki.projectAssessment.entity.Institution;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    Institution findByName(String name);

    @Query("SELECT i FROM Institution i WHERE i.name LIKE %?1%")
    public List<Institution> searchBYName(String name);

    List<Institution> findByOrderByNameAsc(Sort sort);


}
