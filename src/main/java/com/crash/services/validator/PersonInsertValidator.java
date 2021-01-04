package com.crash.services.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.crash.dto.PersonDTO;
import com.crash.entity.Person;
import com.crash.repositories.PersonRepository;
import com.crash.resources.exceptions.FieldMessage;

public class PersonInsertValidator implements ConstraintValidator<PersonInsertValid, PersonDTO> {
	
	@Autowired
	private PersonRepository repository;
	
	@Override
	public void initialize(PersonInsertValid ann) {
	}

	@Override
	public boolean isValid(PersonDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		Person user = repository.findByEmail(dto.getEmail());
		if(user != null ) {
			list.add(new FieldMessage("Email", "Email existente"));
		}
	
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessageError()).addPropertyNode(e.getField())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}