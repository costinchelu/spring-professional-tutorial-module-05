package module05.question11.controller;

import module05.question11.ds.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.validation.Valid;
import java.util.Locale;

/**
 * <a href="http://localhost:8080/example05A">GET /example05A</a>
 * <br/><br/>
 * <a href="http://localhost:8080/example05B">GET /example05B</a>
 */
@Controller
public class Example05ViewResponse {

    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    @GetMapping("/example05A")
    public View example05A() throws Exception {
        return thymeleafViewResolver.resolveViewName("hello", Locale.getDefault());
    }

    @GetMapping("/example05B")
    public View example05B(@ModelAttribute Person person) throws Exception {
        return thymeleafViewResolver.resolveViewName("person", Locale.getDefault());
    }

    @PostMapping("/example05B")
    public View example05BSubmit(@ModelAttribute @Valid Person person, BindingResult bindingResult, Model model) throws Exception {
        model.addAttribute("submit", true);
        return thymeleafViewResolver.resolveViewName("person", Locale.getDefault());
    }
}
