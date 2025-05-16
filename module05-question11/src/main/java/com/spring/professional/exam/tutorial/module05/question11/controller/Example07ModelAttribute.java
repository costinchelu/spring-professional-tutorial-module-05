package com.spring.professional.exam.tutorial.module05.question11.controller;

import com.spring.professional.exam.tutorial.module05.question11.ds.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class Example07ModelAttribute {

    // Visit http://localhost:8080/example07A
    @GetMapping("/example07A")
    @ModelAttribute
    public Person example07A() {
        return new Person("John", "Doe");
    }
}
