package com.projectpeople.managingpeople.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.projectpeople.managingpeople.dto.response.MessageResponseDTO;
import com.projectpeople.managingpeople.entity.Person;
import com.projectpeople.managingpeople.repository.PersonRepository;
 
 
@Service
public class PersonService {
  
  private PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }


  public MessageResponseDTO createPerson(Person person) {
     
    Person savedPerson = personRepository.save(person);

    return MessageResponseDTO
      .builder()
      .message(String.format("Create person with ID %d", savedPerson.getId()))
      .build();
  }
}