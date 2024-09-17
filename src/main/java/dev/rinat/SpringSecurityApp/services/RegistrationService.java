package dev.rinat.SpringSecurityApp.services;

import dev.rinat.SpringSecurityApp.models.Person;
import dev.rinat.SpringSecurityApp.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PersonsRepository personsRepository;

    @Autowired
    public RegistrationService(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @Transactional
    public void register(Person person) {
        personsRepository.save(person);
    }
}
