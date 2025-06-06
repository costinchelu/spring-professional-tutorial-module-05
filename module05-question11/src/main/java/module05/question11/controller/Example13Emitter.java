package module05.question11.controller;

import module05.question11.ds.Person;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.CompletableFuture;

import static module05.question11.utils.Utils.sleep;
import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * curl -D - http://localhost:8080/example13A
 * <br/><br/>
 * curl -D - http://localhost:8080/example13B
 */
@Controller
public class Example13Emitter {

    @Autowired
    private TaskExecutor taskExecutor;

    @GetMapping("/example13A")
    @ResponseBody
    public ResponseBodyEmitter example13A() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();

        CompletableFuture<Void> completableFuture = CompletableFuture
                .runAsync(() -> {
                    send(emitter, new Person("John", "Doe"), APPLICATION_JSON);
                })
                .thenRunAsync(() -> {
                    send(emitter, new Person("William", "Anderson"), APPLICATION_JSON);
                })
                .thenRun(emitter::complete);

        taskExecutor.execute(completableFuture::join);

        return emitter;
    }

    @GetMapping("/example13B")
    @ResponseBody
    public SseEmitter example13B() {
        SseEmitter emitter = new SseEmitter();

        CompletableFuture<Void> completableFuture = CompletableFuture
                .runAsync(() -> {
                    sleep();
                    send(emitter, new Person("William", "Anderson"), APPLICATION_JSON);
                })
                .thenRunAsync(() -> {
                    sleep();
                    send(emitter, new Person("John", "Doe"), APPLICATION_JSON);
                })
                .thenRun(emitter::complete);

        taskExecutor.execute(completableFuture::join);

        return emitter;
    }

    @SneakyThrows
    private void send(ResponseBodyEmitter emitter, Object object, MediaType mediaType) {
        emitter.send(object, mediaType);
    }
}
