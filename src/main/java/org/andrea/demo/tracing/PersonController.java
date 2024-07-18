package org.andrea.demo.tracing;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.andrea.demo.tracing.rest.dto.PersonDtoIn;
import org.andrea.demo.tracing.rest.dto.PersonDtoOut;
import org.andrea.demo.tracing.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/persons")
@RequiredArgsConstructor
public class PersonController {

  private final PersonService personService;

  @PostMapping
  @Observed
  public ResponseEntity<PersonDtoOut> create(@RequestBody PersonDtoIn toCreate) {
    log.info("In controller create");
    return ResponseEntity.ok(PersonDtoOut.fromDomain(personService.create(toCreate.toDomain())));
  }

  @GetMapping
  @Observed
  public ResponseEntity<List<PersonDtoOut>> getAll() {
    log.info("In controller getAll");
    return ResponseEntity.ok(personService.getAll().stream().map(PersonDtoOut::fromDomain).toList());
  }

}
