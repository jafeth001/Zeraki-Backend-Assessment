package com.zeraki.projectAssessment.controller;

import com.zeraki.projectAssessment.entity.Institution;
import com.zeraki.projectAssessment.exception.ConflictException;
import com.zeraki.projectAssessment.exception.NoSuchException;
import com.zeraki.projectAssessment.service.InstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution")
@RequiredArgsConstructor
public class InstitutionController {
    private final InstitutionService institutionService;

    @PostMapping("/add")
    public ResponseEntity<Institution> addInstitution(@RequestBody Institution request) throws ConflictException {
        return ResponseEntity.ok(institutionService.addInstitution(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Institution>> getAllInstitutions() throws NoSuchException {
        return ResponseEntity.ok(institutionService.getAllInstitutions());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Institution>> searchInstitutionByName(@RequestParam String name) {
        return ResponseEntity.ok(institutionService.searchInstitutionsByName(name));
    }

    @GetMapping("/sort/asc/name")
    public ResponseEntity<List<Institution>> getSortedInstitutionsByName() throws NoSuchException {
        return ResponseEntity.ok(institutionService.getSortedInstitutionsByName());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteInstitution(@RequestParam Long id) throws ConflictException, NoSuchException {
        return ResponseEntity.ok(institutionService.deleteInstitution(id));
    }

    @PutMapping("/edit")
    public ResponseEntity<Institution> updateInstitution(@RequestBody Institution institution, @RequestParam Long id) throws NoSuchException, ConflictException {
        return ResponseEntity.ok(institutionService.updateInstitution(id, institution));
    }

}
