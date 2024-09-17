package dev.rinat.SpringSecurityApp.util;

import dev.rinat.SpringSecurityApp.models.Person;
import dev.rinat.SpringSecurityApp.services.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {

    private final PersonsService personsService;

    @Autowired
    public PersonValidator(PersonsService personsService) {
        this.personsService = personsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> oPerson = personsService.findByUsername(person.getUsername());
        if (oPerson.isPresent()) {
            errors.rejectValue("username", "username.duplicate",
                    "Username already exists");
        }
    }
}
