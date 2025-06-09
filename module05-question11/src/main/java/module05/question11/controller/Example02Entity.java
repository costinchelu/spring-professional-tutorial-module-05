package module05.question11.controller;

import module05.question11.ds.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * curl -D - http://localhost:8080/example02A
 * <br/><br/>
 * curl -D - http://localhost:8080/example02B
 */
@Controller
public class Example02Entity {

    @GetMapping("/example02A")
    public HttpEntity<Person> example02A() {
        return new HttpEntity<>(
                new Person("John", "Doe"),
                getCustomHeaders()
        );
    }

    @GetMapping("/example02B")
    public ResponseEntity<Person> example02B() {
        return new ResponseEntity<>(
                new Person("John", "Doe"),
                getCustomHeaders(),
                HttpStatus.FOUND
        );
    }

    private HttpHeaders getCustomHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Person-Version", "v2");
        return httpHeaders;
    }
}
