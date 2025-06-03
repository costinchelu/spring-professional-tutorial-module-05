package module05.question10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * curl http://localhost:8080/example08A
 * <br/><br/>
 * curl http://localhost:8080/example08B
 * <br/><br/>
 * curl http://localhost:8080/example08C
 * <br/><br/>
 * curl http://localhost:8080/example08D
 */
@Controller
public class Example08RequestAttribute {

    @GetMapping("/example08A")
    @ResponseBody
    public String example08A(@RequestAttribute("processing-time") String processingTime) {
        return String.format("processing time = [%s]\n", processingTime);
    }

    @GetMapping("/example08B")
    @ResponseBody
    public String example08B(@RequestAttribute("processing-time") LocalDateTime processingTime) {
        return String.format("processing time = [%s]\n", processingTime);
    }

    @GetMapping("/example08C")
    @ResponseBody
    public String example08C(@RequestAttribute(value = "non-existing-processing-time", required = false) LocalDateTime processingTime) {
        return String.format("processing time = [%s]\n", processingTime);
    }

    @GetMapping("/example08D")
    @ResponseBody
    public String example08D(@RequestAttribute(value = "non-existing-processing-time", required = false) Optional<LocalDateTime> processingTime) {
        return String.format("processing time = [%s]\n", processingTime.orElse(LocalDateTime.MIN));
    }
}
