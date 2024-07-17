package org.andrea.demo.tracing.persistence.model;

import lombok.Builder;
import org.andrea.demo.tracing.service.model.Person;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;
import java.time.LocalDate;

@Builder
public record PersonDocument(

  @Id @MongoId String id,

  String firstName,

  String lastName,

  LocalDate dateOfBirth,

  @LastModifiedDate Instant updatedAt

) {

  public static PersonDocument fromDomain(Person person) {
    return PersonDocument.builder()
      .firstName(person.firstName())
      .lastName(person.lastName())
      .dateOfBirth(person.dateOfBirth())
      .build();
  }

  public Person toDomain() {
    return Person.builder().firstName(firstName()).lastName(lastName()).dateOfBirth(dateOfBirth()).build();
  }
}
