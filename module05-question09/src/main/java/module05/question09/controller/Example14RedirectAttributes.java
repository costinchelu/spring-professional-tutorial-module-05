package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * <a href="http://localhost:8080/actionN1">GET /actionN1</a>
 * <br/><br/>
 * Action /actionN1 will redirect request to /actionN2
 */
@Controller
public class Example14RedirectAttributes {

    @GetMapping("/actionN1")
    public String actionN1(RedirectAttributes redirectAttributes) {
        // will be sent as a query parameter
        redirectAttributes.addAttribute("firstName", "John");

        // will be sent in a model (session attribute) - valid for redirects
        redirectAttributes.addFlashAttribute("lastName", "Doe");
        redirectAttributes.addFlashAttribute("city", "Los Angeles");

        return "redirect:/actionN2";
    }

    @GetMapping("/actionN2")
    public String actionN2(
            @RequestParam("firstName") String firstName,
            @ModelAttribute("lastName") String lastName,
            @ModelAttribute("city") String city,
            Model model) {
        model.addAttribute("firstName", firstName);
        // lastName and city are already in model (from the redirectAttributes), they do not have to be added

        return "list-attributes";
    }
}
