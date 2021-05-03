package com.projectpeople.managingpeople.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

  @GetMapping
  public List<String> getPeople() {
    return new ArrayList<String>();
  }
}