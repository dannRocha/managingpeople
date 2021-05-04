package com.projectpeople.managingpeople.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.projectpeople.managingpeople.dto.response.MessageResponseDTO;
import com.projectpeople.managingpeople.dto.request.PersonDTO;
import com.projectpeople.managingpeople.entity.Person;
import com.projectpeople.managingpeople.mappers.PersonMapper;
import com.projectpeople.managingpeople.repository.PersonRepository;
 
 
@Service
public class PersonService {
  
  private PersonRepository personRepository;

  private final PersonMapper personMapper = PersonMapper.INSTANCE;
  
  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }


  public MessageResponseDTO createPerson(PersonDTO personDTO) {
    
    Person personToSave = personMapper.toModel(personDTO);
    Person savedPerson = personRepository.save(personToSave);

    return MessageResponseDTO
      .builder()
      .message(String.format("Create person with ID %d", savedPerson.getId()))
      .build();
  }
}