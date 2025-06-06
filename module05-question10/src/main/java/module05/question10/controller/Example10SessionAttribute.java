package module05.question10.controller;

import module05.question10.ds.MutableCountHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

/**
 * curl -b cookie.txt -c cookie.txt http://localhost:8080/example10A
 * <br/><br/>
 * curl -b cookie.txt -c cookie.txt http://localhost:8080/example10B
 * <br/><br/>
 * curl -b cookie.txt -c cookie.txt http://localhost:8080/example10C
 */
@Controller
public class Example10SessionAttribute {

    // mutableCountHolder is created in the interceptor
    @GetMapping("/example10A")
    @ResponseBody
    public String example10A(@SessionAttribute MutableCountHolder mutableCountHolder) {
        mutableCountHolder.increment();
        return String.format("count value = [%d]\n", mutableCountHolder.get());
    }

    @GetMapping("/example10B")
    @ResponseBody
    public String example10B(@SessionAttribute(required = false, name = "non-existent-counter") Integer count) {
        return String.format("count value = [%d]\n", count);
    }

    @GetMapping("/example10C")
    @ResponseBody
    public String example10C(@SessionAttribute("non-existent-counter") Optional<Integer> count) {
        return String.format("count value = [%d]\n", count.orElse(-1));
    }
}
