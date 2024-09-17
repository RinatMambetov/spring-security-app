package dev.rinat.SpringSecurityApp.controllers;

import dev.rinat.SpringSecurityApp.models.Person;
import dev.rinat.SpringSecurityApp.services.RegistrationService;
import dev.rinat.SpringSecurityApp.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final PersonValidator personValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthController(PersonValidator personValidator, RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerPage(@ModelAttribute("person") Person person) {
        return "auth/register";
    }

    @PostMapping("/register")
    public String performRegister(@ModelAttribute("person") @Valid Person person,
                                  BindingResult result) {
        personValidator.validate(person, result);
        if (result.hasErrors()) {
            return "auth/register";
        }

        registrationService.register(person);

        return "redirect:/auth/login";
    }
}
