package module05.question09.controller;

import module05.question09.ds.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * curl "http://localhost:8080/actionS?firstName=John&lastName=Doe"
 * <br/><br/>
 * <a href="http://localhost:8080/actionS/simpleForm">GET /actionS/simpleForm</a>
 *
 */
@Controller
public class Example18AnyType {

    @GetMapping("/actionS")
    @ResponseBody
    public String actionS(String firstName, String lastName) {
        return String.format(
                "firstName = [%s], lastName = [%s]\n",
                firstName, lastName
        );
    }

    @GetMapping("/actionS/simpleForm")
    public String actionSSimpleForm(Person person) {
        return "person-form-simple";
    }

    @PostMapping("/actionS/simpleForm")
    public String actionSSimpleFormSubmit(Person person) {
        return "person-display-simple";
    }
}
