package module05.question10.controller;

import module05.question10.ds.Address;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * <a href="http://localhost:8080/example09">GET /example09</a>
 * <br/><br/>
 * John	Doe <br/>
 * 455 Larkspur Dr. Apt 23 <br/>
 * Baviera	CA	92908	United States
 */
@Controller
public class Example09ModelAttribute {

    @GetMapping("/example09")
    public String example09(@ModelAttribute Address address) {
        return "address-form";
    }

    @PostMapping("/example09")
    public String example09(@ModelAttribute @Valid Address address, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "address-form";
        else
            return "address-display";
    }
}
