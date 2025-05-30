package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

import static java.lang.String.format;

/**
 * <a href="http://localhost:8080/actionG">GET /actionG </a>
 * <br/><br/>
 * use john/john or mary/mary as username and password
 */
@Controller
public class Example07Principal {

    @GetMapping("/actionG")
    @ResponseBody
    public String actionG(Principal principal) {
        return format("Authenticated with principal = [%s]\n", principal.getName());
    }
}
