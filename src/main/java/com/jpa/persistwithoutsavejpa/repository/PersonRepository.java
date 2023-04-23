package com.jpa.persistwithoutsavejpa.repository;

import com.jpa.persistwithoutsavejpa.entity.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, ObjectId> {
    Person findByTcID(Long tcID);
}
