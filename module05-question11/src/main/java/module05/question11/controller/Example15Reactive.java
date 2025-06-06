package module05.question11.controller;

import module05.question11.ds.Person;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static module05.question11.utils.Utils.sleep;

/**
 * curl -D - http://localhost:8080/example15
 */
@Controller
public class Example15Reactive {

    @Autowired
    private TaskExecutor taskExecutor;

    @GetMapping("/example15")
    @ResponseBody
    public Observable<Person> example15() {
        PublishSubject<Person> subject = PublishSubject.create();

        taskExecutor.execute(() -> {
            sleep();

            subject.onNext(new Person("John", "Doe"));
            subject.onNext(new Person("William", "Anderson"));

            subject.onComplete();
        });

        return subject;
    }
}
