package org.andrea.demo.tracing.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.andrea.demo.tracing.service.model.Person;

import java.time.LocalDate;

@Builder
public record PersonDtoOut(

  @JsonProperty(value = "name") @NotNull String firstName,

  @JsonProperty(value = "last_name") @NotNull String lastName,

  @JsonProperty(value = "date_of_birth") @NotNull LocalDate dateOfBirth,

  @JsonProperty(value = "age") Integer age

) {

  @Override
  public Integer age() {
    return dateOfBirth.until(LocalDate.now()).getYears();
  }

  public static PersonDtoOut fromDomain(Person person) {
    return PersonDtoOut.builder()
      .firstName(person.firstName())
      .lastName(person.lastName())
      .dateOfBirth(person.dateOfBirth())
      .build();
  }
}
