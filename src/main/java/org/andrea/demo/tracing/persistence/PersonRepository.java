package org.andrea.demo.tracing.persistence;

import org.andrea.demo.tracing.persistence.model.PersonDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<PersonDocument, String> {
}
