package module05.question11.controller;

import module05.question11.ds.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import static module05.question11.utils.Utils.SLEEP_TIME_SECONDS;
import static module05.question11.utils.Utils.sleep;

/**
 * curl http://localhost:8080/example10A
 */
@Controller
public class Example10DeferredResult {

    @Autowired
    private TaskExecutor taskExecutor;

    private final Logger logger = LoggerFactory.getLogger(Example10DeferredResult.class);

    @GetMapping("/example10A")
    @ResponseBody
    public DeferredResult<Person> example10A() {
        DeferredResult<Person> deferredResult = new DeferredResult<>();

        taskExecutor.execute(() -> {
            logger.info("Sleeping for {} seconds before giving back results...", SLEEP_TIME_SECONDS);
            sleep();
            logger.info("Finished sleeping, giving back results...");
            deferredResult.setResult(new Person("John", "Doe"));
        });

        return deferredResult;
    }
}
