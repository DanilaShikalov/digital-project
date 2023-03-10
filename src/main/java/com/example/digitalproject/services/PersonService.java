package com.example.digitalproject.services;

import com.example.digitalproject.models.dto.persons.*;

import java.util.List;

public interface PersonService {
    PersonGetDTO getEntity(Long id);

    void postEntity(PersonPostDTO postDTO, Long idJob);

    void deleteEntity(Long id);

    void putEntity(PersonPutDTO putDTO, Long id);

    List<PersonGetDTO> getAllEntities();

    void addSubjectsToPerson(Long idPerson, Long idSubject);
}
