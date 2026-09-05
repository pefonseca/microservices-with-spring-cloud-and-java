package com.pefonseca.rest.with.spring.boot.and.java.repository;

import com.pefonseca.rest.with.spring.boot.and.java.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
