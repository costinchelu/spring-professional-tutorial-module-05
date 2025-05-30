package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.PushBuilder;

/**
 * <a href="http://localhost:8080/actionF/no-push">GET /actionF/no-push</a>
 * <br/><br/>
 * <a href="https://localhost:8443/actionF/with-push">GET /actionF/with-push</a>
 */
@Controller
public class Example06PushBuilder {

    @GetMapping("/actionF/no-push")
    public String actionFNoPush() {
        return "images";
    }

    @GetMapping("/actionF/with-push")
    public String actionFWithPush(PushBuilder pushBuilder) {
        if (pushBuilder != null) {
            pushBuilder.path("/img/b-module02.jpg").push();
            pushBuilder.path("/img/b-module05.jpg").push();
            pushBuilder.path("/img/b-module08.jpg").push();
        }
        return "images";
    }
}
