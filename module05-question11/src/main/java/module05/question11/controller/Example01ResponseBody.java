package module05.question11.controller;

import module05.question11.ds.Person;
import module05.question11.ds.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * curl http://localhost:8080/example01A
 * <br/><br/>
 * curl http://localhost:8080/example01B
 * <br/><br/>
 * curl http://localhost:8080/example01C
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

    // Need getters and an all args constructor in the Team and Person classes
    // this will return a JSON
    @GetMapping("/example01C")
    @ResponseBody
    public Team example01C() {
        return new Team(1, "Team 1", (List.of(new Person("John", "Doe"))));
    }
}
