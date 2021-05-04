package com.projectpeople.managingpeople.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.projectpeople.managingpeople.dto.request.PersonDTO;
import com.projectpeople.managingpeople.entity.Person;


@Mapper
public interface PersonMapper {
  
  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  @Mapping(target="birthDay", source="birthDay", dateFormat="dd-MM-yyyy")
  Person toModel(PersonDTO personDTO);

  PersonDTO toDTO(Person personD);  

}