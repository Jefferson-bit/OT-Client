package com.crash.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crash.dto.PersonDTO;
import com.crash.entity.Person;
import com.crash.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Transactional
	public PersonDTO save(PersonDTO dto) {
		Person entity = new Person();
		copyDTOToEntity(dto, entity);
		entity = repository.save(entity);
		return new PersonDTO(entity);
	}
	
	private void copyDTOToEntity(PersonDTO dto, Person entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setDateBirth(dto.getDateBirth());
	}

}