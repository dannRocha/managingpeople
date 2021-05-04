package com.projectpeople.managingpeople.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.projectpeople.managingpeople.dto.response.MessageResponseDTO;
import com.projectpeople.managingpeople.dto.request.PersonDTO;
import com.projectpeople.managingpeople.entity.Person;
import com.projectpeople.managingpeople.exception.PersonNotFoundException;
import com.projectpeople.managingpeople.mappers.PersonMapper;
import com.projectpeople.managingpeople.repository.PersonRepository;
 

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

 
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
    
    return messageResponseDTO(
      String.format("Create person with ID %d", savedPerson.getId())
    );
  }


  public List<PersonDTO> listAll() {
    return personRepository
      .findAll()
      .stream()
      .map(personMapper::toDTO)
      .collect(Collectors.toList());
  }


  public PersonDTO findById(Long id) throws PersonNotFoundException {
    return personMapper
      .toDTO(verifyIfExist(id));
  }


  public void deleteById(Long id) throws PersonNotFoundException {
    verifyIfExist(id);
    personRepository.deleteById(id);
  }

  public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
    
    verifyIfExist(id);

    Person personToSave = personMapper.toModel(personDTO);
    Person savedPerson = personRepository.save(personToSave);

    return messageResponseDTO(
      String.format("Updated person with ID %d", savedPerson.getId())
    );

  }


  private Person verifyIfExist(Long id) throws PersonNotFoundException {
    return personRepository
      .findById(id)
      .orElseThrow(() -> new PersonNotFoundException(id));

  }

  private MessageResponseDTO messageResponseDTO(String message) {
    return MessageResponseDTO
      .builder()
      .message(message)
      .build();
  }
}