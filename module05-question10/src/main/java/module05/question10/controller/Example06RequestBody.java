package module05.question10.controller;

import module05.question10.ds.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Optional;

/**
 * curl -d '{ "firstName": "John", "lastName": "Doe" }' -H 'Content-Type: application/json' http://localhost:8080/example06A
 * <br/><br/>
 * curl -d '{ "firstName": "John", "lastName": "Doe" }' -H 'Content-Type: application/json' http://localhost:8080/example06B
 * <br/><br/>
 * curl -d '{ "firstName": "John", "lastName": "Doe" }' -H 'Content-Type: application/json' http://localhost:8080/example06C
 * <br/><br/>
 * curl -X POST -H 'Content-Type: application/json' http://localhost:8080/example06C
 * <br/><br/>
 * curl -d '{ "firstName": "John", "lastName": "Doe" }' -H 'Content-Type: application/json' http://localhost:8080/example06D
 * <br/><br/>
 * curl -X POST -H 'Content-Type: application/json' http://localhost:8080/example06D
 * <br/><br/>
 * curl -d '{ "firstName": "John", "lastName": "Doe" }' -H 'Content-Type: application/json' http://localhost:8080/example06E
 * <br/><br/>
 * curl -d '{ "firstName": "John1", "lastName": "Doe" }' -H 'Content-Type: application/json' http://localhost:8080/example06E
 * <br/><br/>
 * curl -d '{ "firstName": "John1", "lastName": "Doe2" }' -H 'Content-Type: application/json' http://localhost:8080/example06E
 */
@Controller
public class Example06RequestBody {

    @PostMapping("/example06A")
    @ResponseBody
    public String example06A(@RequestBody String body) {
        return String.format("Received body = [%s]\n", body);
    }

    @PostMapping("/example06B")
    @ResponseBody
    public String example06B(@RequestBody Person person) {
        return String.format("Received person = [%s]\n", person);
    }

    @PostMapping("/example06C")
    @ResponseBody
    public String example06C(@RequestBody(required = false) Person person) {
        return String.format("Received person = [%s]\n", person);
    }

    @PostMapping("/example06D")
    @ResponseBody
    public String example06D(@RequestBody Optional<Person> person) {
        return String.format("Received person = [%s]\n", person.orElse(new Person()));
    }

    @PostMapping("/example06E")
    @ResponseBody
    public String example06E(@RequestBody @Valid Person person, BindingResult bindingResult) {
        return String.format("Received person = [%s], error count = [%d]\n", person, bindingResult.getErrorCount());
    }
}
