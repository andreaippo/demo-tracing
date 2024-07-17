package org.andrea.demo.tracing.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.andrea.demo.tracing.service.model.Person;

import java.time.LocalDate;

public record PersonDtoIn(

  @JsonProperty(value = "name") String firstName,

  @JsonProperty(value = "last_name") String lastName,

  @JsonProperty(value = "date_of_birth") LocalDate dateOfBirth
) {

  public Person toDomain() {
    return new Person(firstName(), lastName(), dateOfBirth());
  }
}
