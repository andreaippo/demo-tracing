package org.andrea.demo.tracing.service;

import lombok.RequiredArgsConstructor;
import org.andrea.demo.tracing.persistence.PersonRepository;
import org.andrea.demo.tracing.persistence.model.PersonDocument;
import org.andrea.demo.tracing.service.model.Person;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  public Person create(Person person) {
    return personRepository.save(PersonDocument.fromDomain(person)).toDomain();
  }

  public Collection<Person> getAll() {
    return personRepository.findAll().stream().map(PersonDocument::toDomain).toList();
  }
}
