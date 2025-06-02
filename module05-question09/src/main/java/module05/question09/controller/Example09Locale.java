package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

import static java.lang.String.format;

/**
 * curl -H "Accept-Language: en" localhost:8080/actionI
 * <br/><br/>
 * curl -H "Accept-Language: es" localhost:8080/actionI
 * <br/><br/>
 * curl -H "Accept-Language: ro" localhost:8080/actionI
 */
@Controller
public class Example09Locale {

    @RequestMapping("/actionI")
    @ResponseBody
    public String actionI(Locale locale) {
        return format("Locale = [%s]\n", locale.getDisplayName());
    }
}
