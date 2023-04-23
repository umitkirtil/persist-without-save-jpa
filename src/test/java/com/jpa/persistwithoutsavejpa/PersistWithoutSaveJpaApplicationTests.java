package com.jpa.persistwithoutsavejpa;

import com.jpa.persistwithoutsavejpa.entity.Person;
import com.jpa.persistwithoutsavejpa.repository.PersonRepository;
import com.jpa.persistwithoutsavejpa.service.PersonService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class PersistWithoutSaveJpaApplicationTests {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.personService = new PersonService(this.personRepository);
    }

    @Test
    void persistPersonWithoutCallingSaveMethod() {

        Person umit = Person.builder()
                .adi("Umit")
                .tcID(55555555555l)
				.soyadi("KIRTIL")
				.build();

        personService.savePerson(umit);
        assertEquals("Umit" , umit.getAdi());


        personService.updatePersonNameTransactional(55555555555l , "Gulay");
        assertEquals("Gulay" , personService.findPersonByTC(55555555555l));
    }

}
