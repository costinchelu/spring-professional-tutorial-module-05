package module05.question11.controller;

import module05.question11.ds.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.ListenableFutureTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static module05.question11.utils.Utils.SLEEP_TIME_SECONDS;
import static module05.question11.utils.Utils.log;
import static module05.question11.utils.Utils.sleep;

/**
 * curl http://localhost:8080/example12A
 * <br/><br/>
 * curl http://localhost:8080/example12B
 * <br/><br/>
 * curl http://localhost:8080/example12C
 */
@Controller
public class Example12Future {

    @Autowired
    private TaskExecutor taskExecutor;

    private final Logger logger = LoggerFactory.getLogger(Example12Future.class);

    @GetMapping("/example12A")
    @ResponseBody
    public ListenableFuture<Person> example12A() {
        ListenableFutureTask<Person> listenableFutureTask = new ListenableFutureTask<>(() -> {
            log(logger, Thread.currentThread().getName());
            return new Person("John", "Doe");
        });

        listenableFutureTask.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(Person person) {
                logger.info("Task created person = [{}]", person);
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.info("Exception thrown by task = [{}]", ex.getMessage());
            }
        });

        taskExecutor.execute(listenableFutureTask);

        return listenableFutureTask;
    }

    @GetMapping("/example12B")
    @ResponseBody
    public CompletableFuture<Integer> example12B() {
        CompletableFuture<Person> completableFuture = CompletableFuture.supplyAsync(() -> {
            log(logger, Thread.currentThread().getName());
            return new Person("John", "Doe");
        });

        return completableFuture
                .thenApply(person -> String.format("%s %s", person.getFirstName(), person.getLastName()))
                .thenApply(String::length);
    }

    @GetMapping("/example12C")
    @ResponseBody
    public CompletionStage<String> example12C() {
        CompletionStage<Person> completionStage = CompletableFuture.supplyAsync(() -> {
            log(logger, Thread.currentThread().getName());
            return new Person("John", "Doe");
        });

        return completionStage
                .thenApply(person -> String.format("%s %s", person.getFirstName(), person.getLastName()))
                .thenApply(String::toUpperCase);
    }


}
