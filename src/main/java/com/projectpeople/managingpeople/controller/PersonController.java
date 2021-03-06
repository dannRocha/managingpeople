package com.projectpeople.managingpeople.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import javax.validation.Valid;


import com.projectpeople.managingpeople.dto.response.MessageResponseDTO;
import com.projectpeople.managingpeople.dto.request.PersonDTO;
import com.projectpeople.managingpeople.entity.Person;
import com.projectpeople.managingpeople.exception.PersonNotFoundException;
import com.projectpeople.managingpeople.repository.PersonRepository;
import com.projectpeople.managingpeople.service.PersonService;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

  private PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
    return personService.createPerson(personDTO);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<PersonDTO> listAll() {
    return personService.listAll();
  }

  @GetMapping("{id}")
  public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
    return personService.findById(id);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
    personService.deleteById(id);
  }

  @PutMapping("{id}")
  public MessageResponseDTO updateById(
     @PathVariable Long id, @RequestBody @Valid PersonDTO personDTO
  ) throws PersonNotFoundException 
  {
    return personService.updateById(id, personDTO);
  }

}