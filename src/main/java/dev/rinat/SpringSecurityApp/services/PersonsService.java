package dev.rinat.SpringSecurityApp.services;

import dev.rinat.SpringSecurityApp.models.Person;
import dev.rinat.SpringSecurityApp.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonsService {

    private final PersonsRepository personsRepository;

    @Autowired
    public PersonsService(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    public Optional<Person> findByUsername(String username) {
        return personsRepository.findByUsername(username);
    }

}
