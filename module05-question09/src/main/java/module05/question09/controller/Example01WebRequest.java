package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import static module05.question09.utils.JoinUtils.join;

/**
 * curl "localhost:8080/actionA?name=John&country=US"
 */
@Controller
public class Example01WebRequest {

    @GetMapping("/actionA")
    @ResponseBody
    public String actionA(WebRequest webRequest) {
        return String.format(
                "Retrieved request with headers = [%s], parameters = [%s]\n",
                join(webRequest.getHeaderNames()),
                join(webRequest.getParameterNames())
        );
    }
}
