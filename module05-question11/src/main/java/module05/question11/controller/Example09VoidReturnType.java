package module05.question11.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * curl http://localhost:8080/example09A
 * <br/><br/>
 * curl http://localhost:8080/example09B
 * <br/><br/>
 * curl -D - http://localhost:8080/example09C
 * <br/><br/>
 * <a href="http://localhost:8080/example09D">GET /example09D</a>
 */
@Controller
public class Example09VoidReturnType {

    @GetMapping("/example09A")
    public void example09A(ServletResponse servletResponse) throws IOException {
        servletResponse.getWriter().println("Response from example09A");
    }

    @GetMapping("/example09B")
    public void example09B(OutputStream outputStream) throws IOException {
        outputStream.write("Response from example09B\n".getBytes());
    }

    @GetMapping("/example09C")
    @ResponseStatus(code = HttpStatus.FOUND)
    public void example09B() {
    }

    @GetMapping("/example09D")
    public void example09D() {
    }
}
