package module05.question11.controller;

import module05.question11.ds.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

import static module05.question11.utils.Utils.SLEEP_TIME_SECONDS;
import static module05.question11.utils.Utils.log;
import static module05.question11.utils.Utils.sleep;

/**
 * curl http://localhost:8080/example11A
 */
@Controller
public class Example11Callable {

    private final Logger logger = LoggerFactory.getLogger(Example11Callable.class);

    @GetMapping("/example11A")
    @ResponseBody
    public Callable<Person> example11A() {
        return () -> {
            log(logger, Thread.currentThread().getName());
            return new Person("John", "Doe");
        };
    }
}
