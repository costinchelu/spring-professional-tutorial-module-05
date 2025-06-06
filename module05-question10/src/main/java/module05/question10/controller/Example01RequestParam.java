package module05.question10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * curl "http://localhost:8080/example01A?firstName=John&lastName=Doe"
 * <br/><br/>
 * curl "http://localhost:8080/example01B?firstName=John&lastName=Doe"
 * <br/><br/>
 * curl "http://localhost:8080/example01B?firstName=John"
 * <br/><br/>
 * curl "http://localhost:8080/example01C?firstName=John&lastName=Doe"
 * <br/><br/>
 * curl "http://localhost:8080/example01C?firstName=John"
 * <br/><br/>
 * curl "http://localhost:8080/example01D?firstName=John&lastName=Doe"
 * <br/><br/>
 * curl "http://localhost:8080/example01D?firstName=John"
 */
@Controller
public class Example01RequestParam {

    @GetMapping("/example01A")
    @ResponseBody
    public String example01A(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return String.format("Received firstName = [%s], lastName = [%s]\n", firstName, lastName);
    }

    @GetMapping("/example01B")
    @ResponseBody
    public String example01B(@RequestParam("firstName") String firstName, @RequestParam(value = "lastName", required = false) String lastName) {
        return String.format("Received firstName = [%s], lastName = [%s]\n", firstName, lastName);
    }

    @GetMapping("/example01C")
    @ResponseBody
    public String example01C(@RequestParam("firstName") String firstName, @RequestParam(value = "lastName", required = false, defaultValue = "N/A") String lastName) {
        return String.format("Received firstName = [%s], lastName = [%s]\n", firstName, lastName);
    }

    @GetMapping("/example01D")
    @ResponseBody
    public String example01D(@RequestParam("firstName") String firstName, @RequestParam(value = "lastName") Optional<String> lastName) {
        return String.format("Received firstName = [%s], lastName = [%s]\n", firstName, lastName.orElse("N/A"));
    }
}
