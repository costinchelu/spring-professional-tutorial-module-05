package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import static java.lang.String.format;

/**
 * curl -c cookie.txt -b cookie.txt localhost:8080/actionE
 */
@Controller
public class Example05HttpSession {

    @GetMapping("/actionE")
    @ResponseBody
    public String actionE(HttpSession httpSession) {
        Integer counter = (Integer) httpSession.getAttribute("counter");
        if (counter == null) {
            httpSession.setAttribute("counter", 0);
            counter = 0;
        }

        httpSession.setAttribute("counter", ++counter);

        return format("Counter = [%d]\n", counter);
    }
}
