package com.example.digitalproject.models.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String number;
    @OneToMany
    @JoinColumn(name = "person_id")
    private List<Document> documents;
    @ManyToMany
    private List<Subject> subjects;
    @OneToOne
    private Job job;
}