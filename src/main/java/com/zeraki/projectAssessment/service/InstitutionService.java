package com.zeraki.projectAssessment.service;

import com.zeraki.projectAssessment.entity.Course;
import com.zeraki.projectAssessment.entity.Institution;
import com.zeraki.projectAssessment.exception.ConflictException;
import com.zeraki.projectAssessment.exception.NoSuchException;
import com.zeraki.projectAssessment.repository.CourseRepository;
import com.zeraki.projectAssessment.repository.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InstitutionService {
    private final InstitutionRepository institutionRepository;
    private final CourseRepository courseRepository;

    public Institution addInstitution(Institution request) throws ConflictException {
        Institution institution = institutionRepository.findByName(request.getName());
        if (institution == null) {
            return institutionRepository.save(request);
        }
        throw new ConflictException("institution with the same name " + request.getName() + " already exist");
    }

    public List<Institution> getAllInstitutions() throws NoSuchException {
        List<Institution> institutions = institutionRepository.findAll();
        if (institutions.isEmpty()) {
            throw new NoSuchException("no institutions available");
        }
        return institutions;
    }

    public List<Institution> searchInstitutionsByName(String name) {
        if (name != null) {
            return institutionRepository.searchBYName(name);
        }
        return institutionRepository.findAll();
    }

    public List<Institution> getSortedInstitutionsByName() throws NoSuchException {
        Sort sort = Sort.by(Sort.Order.asc("name"));
        List<Institution> institutions = institutionRepository.findByOrderByNameAsc(sort);
        if (institutions.isEmpty()) {
            throw new NoSuchException("no institutions available");
        }
        return institutions;
    }

    public String deleteInstitution(Long id) throws ConflictException, NoSuchException {
        Institution institution = institutionRepository.findById(id).get();
        institutionRepository.deleteById(id);
        return "Instituiton deleted successfully....";
    }

    public Institution updateInstitution(Long id, Institution institution) throws ConflictException {
        Institution existsInstitution = institutionRepository.findById(id).get();
        if (Objects.nonNull(institution.getName()) && !"".equalsIgnoreCase(institution.getName())) {
            existsInstitution.setName(institution.getName());
        }
        return institutionRepository.save(existsInstitution);
    }
}
