package module05.question11.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * curl -D - http://localhost:8080/example03
 */
@Controller
public class Example03HttpHeaders {

    @GetMapping("/example03")
    public HttpHeaders example03() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("API-Version", "v3");
        httpHeaders.setDate(System.currentTimeMillis());
        httpHeaders.setContentType(MediaType.APPLICATION_XML);

        return httpHeaders;
    }
}
