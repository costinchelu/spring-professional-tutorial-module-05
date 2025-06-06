package module05.question11.controller;

import module05.question11.ds.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * curl http://localhost:8080/example01A
 * <br/><br/>
 * curl http://localhost:8080/example01B
 */
@Controller
public class Example01ResponseBody {

    @GetMapping("/example01A")
    @ResponseBody
    public String example01A() {
        return "Response Content from example01A\n";
    }

    @GetMapping("/example01B")
    @ResponseBody
    public Person example01B() {
        return new Person("John", "Doe");
    }
}
