package com.projectpeople.managingpeople.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

import com.projectpeople.managingpeople.dto.response.MessageResponseDTO;
import com.projectpeople.managingpeople.entity.Person;
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
  public MessageResponseDTO createPerson(@RequestBody Person person) {
    return personService.createPerson(person);
  }

  @GetMapping
  public List<String> getPeople() {
    // return personRepository
    //   .findAll()
    //   .stream()
    //   .map(mangaMapper::toDTO)
    //   .collect(Collectors.toList());
    return new ArrayList<String>();
  }
}