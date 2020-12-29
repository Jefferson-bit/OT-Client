package com.crash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crash.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
