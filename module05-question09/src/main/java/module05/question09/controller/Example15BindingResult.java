package module05.question09.controller;

import module05.question09.ds.Address;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * <a href="http://localhost:8080/actionO1">GET /actionO1</a>
 */
@Controller
public class Example15BindingResult {

    @GetMapping("/actionO1")
    public String actionO1(@ModelAttribute Address address) {
        return "address-form";
    }

    // This endpoint will be used by actionO1 to submit data that contains the address:
    // John	Doe
    // 455 Larkspur Dr. Apt 23
    // Baviera	CA	92908	United States
    @PostMapping("/actionO1")
    public String actionO1Submit(@ModelAttribute @Valid Address address, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "address-form";
        }

        redirectAttributes.addFlashAttribute(address);
        return "redirect:/actionO1/ok";
    }

    // This endpoint will be used by actionO1 when data was submitted successfully
    @GetMapping("/actionO1/ok")
    public String actionO1Ok(@ModelAttribute Address address) {
        return "address-form-ok";
    }
}
