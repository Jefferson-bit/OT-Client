package com.crash.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.crash.entity.Person;
import com.crash.services.validator.PersonInsertValid;

@PersonInsertValid
public class PersonDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Campo não pode ser vazio")
	private String name;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message = "Favor entrar com um email valido")
	private String email;
	private Instant dateBirth;

	public PersonDTO() {
	}

	public PersonDTO(Long id, String name, String cpf, String email, Instant dateBirth) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.dateBirth = dateBirth;
	}

	public PersonDTO(Person entity) {
		id = entity.getId();
		name = entity.getName();
		this.cpf = entity.getCpf();
		email = entity.getEmail();
		dateBirth = entity.getDateBirth();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Instant dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
