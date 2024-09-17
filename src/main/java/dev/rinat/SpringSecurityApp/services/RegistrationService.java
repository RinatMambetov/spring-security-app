package dev.rinat.SpringSecurityApp.services;

import dev.rinat.SpringSecurityApp.models.Person;
import dev.rinat.SpringSecurityApp.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PersonsRepository personsRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public RegistrationService(PersonsRepository personsRepository, PasswordEncoder encoder) {
        this.personsRepository = personsRepository;
        this.encoder = encoder;
    }

    @Transactional
    public void register(Person person) {
        person.setPassword(encoder.encode(person.getPassword()));
        personsRepository.save(person);
    }
}
