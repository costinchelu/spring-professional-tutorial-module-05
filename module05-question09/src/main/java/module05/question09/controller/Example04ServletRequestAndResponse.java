package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import static java.lang.String.format;

/**
 * curl localhost:8080/actionD
 */
@Controller
public class Example04ServletRequestAndResponse {

    @GetMapping("/actionD")
    @ResponseBody
    public void actionD(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        servletResponse.getOutputStream()
                .println(
                format("Retrieved request on server = [%s:%d]",
                        servletRequest.getServerName(),
                        servletRequest.getServerPort()
                )
        );
    }
}
