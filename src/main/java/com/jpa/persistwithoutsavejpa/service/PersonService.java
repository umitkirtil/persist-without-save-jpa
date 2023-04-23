package com.jpa.persistwithoutsavejpa.service;

import com.jpa.persistwithoutsavejpa.entity.Person;
import com.jpa.persistwithoutsavejpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {


    PersonRepository personRepository;

    public PersonService(@Autowired PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        return this.personRepository.save(person);
    }

    @Transactional
    public void updatePersonNameTransactional(Long tcID, String name) {
        Person currentPersonnel = personRepository.findByTcID(tcID);
        currentPersonnel.setAdi(name);
    }

    public  Person findPersonByTC(Long tcID){
        return findPersonByTC(tcID);
    }
}
