package module05.question09.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.String.format;

/**
 * curl -X GET localhost:8080/actionH
 * <br/><br/>
 * curl -X POST localhost:8080/actionH
 * <br/><br/>
 * curl -X PUT localhost:8080/actionH
 */
@Controller
public class Example08HttpMethod {

    @RequestMapping("/actionH")
    @ResponseBody
    public String actionH(HttpMethod httpMethod) {
        return format("HTTP Method = [%s]\n", httpMethod);
    }
}
