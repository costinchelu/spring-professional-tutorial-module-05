package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Map<String, String>, Model, ModelMap Example
 * <br/><br/>
 * <a href="http://localhost:8080/actionM1">GET /actionM1</a>
 * <br/><br/>
 * <a href="http://localhost:8080/actionM2">GET /actionM2</a>
 * <br/><br/>
 * <a href="http://localhost:8080/actionM3">GET /actionM3</a>
 */
@Controller
public class Example13Model {

    @GetMapping("/actionM1")
    public String actionM1(Map<String, String> model) {
        model.put("firstName", "John");
        model.put("lastName", "Doe");
        model.put("email", "John.Doe@corp.com");
        model.put("city", "Los Angeles");
        return "address";
    }

    @GetMapping("/actionM2")
    public String actionM2(Model model) {
        model.addAttribute("firstName", "John");
        model.addAttribute("lastName", "Doe");
        model.addAttribute("email", "John.Doe@corp.com");
        model.addAttribute("city", "Los Angeles");
        return "address";
    }

    @GetMapping("/actionM3")
    public String actionM3(ModelMap model) {
        model.addAttribute("firstName", "John");
        model.addAttribute("lastName", "Doe");
        model.addAttribute("email", "John.Doe@corp.com");
        model.addAttribute("city", "Los Angeles");
        return "address";
    }
}
