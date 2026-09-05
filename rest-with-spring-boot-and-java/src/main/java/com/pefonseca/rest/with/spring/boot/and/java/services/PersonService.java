package com.pefonseca.rest.with.spring.boot.and.java.services;

import com.pefonseca.rest.with.spring.boot.and.java.exception.ResourceNotFoundException;
import com.pefonseca.rest.with.spring.boot.and.java.model.Person;
import com.pefonseca.rest.with.spring.boot.and.java.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all People!");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one Person!");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one Person!");

        Person personDB = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personDB.setFirstName(person.getFirstName());
        personDB.setLastName(person.getLastName());
        personDB.setAddress(person.getAddress());
        personDB.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        Person personDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(personDB);
    }

}
