package org.andrea.demo.tracing.service.model;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Person(

  String firstName,

  String lastName,

  LocalDate dateOfBirth

) {
}
