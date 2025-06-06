package module05.question11.controller;

import module05.question11.ds.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * <a href="http://localhost:8080/example07A">GET /example07A</a>
 */
@Controller
public class Example07ModelAttribute {

    @GetMapping("/example07A")
    @ModelAttribute
    public Person example07A() {
        return new Person("John", "Doe");
    }
}
