package com.zeraki.projectAssessment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    @Column(unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
