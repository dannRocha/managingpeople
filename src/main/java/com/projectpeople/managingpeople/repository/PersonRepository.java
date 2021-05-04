package com.projectpeople.managingpeople.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projectpeople.managingpeople.entity.Person;

//JpaRepository<ClassEntity, TypeIdEntity>
public interface PersonRepository extends JpaRepository<Person, Long> {
  
}