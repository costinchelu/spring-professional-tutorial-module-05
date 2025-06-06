package module05.question11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

import static java.util.Arrays.asList;

/**
 * <a href="http://localhost:8080/example06A">GET /example06A</a>
 * <br/><br/>
 * <a href="http://localhost:8080/example06B">GET /example06B</a>
 */
@Controller
public class Example06Model {

    @GetMapping("/example06A")
    public Model example06A() {
        Model model = new BindingAwareModelMap();
        model.addAttribute("names", asList("John", "Mary", "William", "James"));
        model.addAttribute("cities", asList("New York City", "Tokyo", "Sydney", "Bengaluru"));
        return model;
    }

    @GetMapping("/example06B")
    public Map example06B() {
        return Map.of(
                "names", asList("John", "Mary", "William", "James"),
                "cities", asList("New York City", "Tokyo", "Sydney", "Bengaluru")
        );
    }
}
