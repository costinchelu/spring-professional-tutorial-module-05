package module05.question11.controller;

import module05.question11.ds.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * <a href="http://localhost:8080/example04A">GET /example04A</a>
 * <br/><br/>
 * <a href="http://localhost:8080/example04B">GET /example04B</a>
 */
@Controller
public class Example04StringResponse {

    @GetMapping("/example04A")
    public String example04A() {
        return "hello";
    }

    @GetMapping("/example04B")
    public String example04B(@ModelAttribute Person person) {
        return "person";
    }

    @PostMapping("/example04B")
    public String example04BSubmit(@ModelAttribute @Valid Person person, BindingResult bindingResult, Model model) {
        model.addAttribute("submit", true);
        return "person";
    }
}
