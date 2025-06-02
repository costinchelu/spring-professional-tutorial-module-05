package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

import static java.lang.String.format;

/**
 * curl localhost:8080/actionC
 */
@Controller
public class Example03ServletRequest {

    @GetMapping("/actionC")
    @ResponseBody
    public String actionC(ServletRequest servletRequest) {
        return format("Retrieved request on server = [%s:%d]\n",
                servletRequest.getServerName(),
                servletRequest.getServerPort());
    }
}
