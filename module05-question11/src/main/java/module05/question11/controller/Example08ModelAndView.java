package module05.question11.controller;

import module05.question11.ds.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static java.util.Arrays.asList;

/**
 * <a href="http://localhost:8080/example08A">GET /example08A</a>
 * <br/><br/>
 * <a href="http://localhost:8080/example08B">GET /example08B</a>
 */
@Controller
public class Example08ModelAndView {

    @GetMapping("/example08A")
    public ModelAndView example08A() {
        return new ModelAndView(
                "person-display",
                "person",
                new Person("John", "Doe")
        );
    }

    @GetMapping("/example08B")
    public ModelAndView example08B() {
        return new ModelAndView(
                "names-and-cities",
                Map.of(
                        "names", asList("John", "Mary", "William", "James"),
                        "cities", asList("New York City", "Tokyo", "Sydney", "Bengaluru")
                ),
                HttpStatus.OK
        );
    }
}
