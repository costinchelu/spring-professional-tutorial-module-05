package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZoneId;
import java.util.TimeZone;

import static java.lang.String.format;


/**
 * TimeZone and ZoneId Example
 * <br/><br/>
 * curl localhost:8080/actionJ
 */
@Controller
public class Example10TimeZone {

    @RequestMapping("/actionJ")
    @ResponseBody
    public String actionJ(TimeZone timeZone, ZoneId zoneId) {
        return format("TimeZone = [%s], ZoneId = [%s]\n", timeZone.getDisplayName(), zoneId.getId());
    }
}
