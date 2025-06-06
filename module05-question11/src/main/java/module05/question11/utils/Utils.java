package module05.question11.utils;

import lombok.SneakyThrows;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static final int SLEEP_TIME_SECONDS = 5;

    @SneakyThrows
    public static void sleep() {
        Thread.sleep(TimeUnit.SECONDS.toMillis(SLEEP_TIME_SECONDS));
    }

    public static void log(Logger logger, String threadName) {
        logger.info("Pretending to run long operation for {} seconds in thread {}", SLEEP_TIME_SECONDS, threadName);
        sleep();
        logger.info("Pretended long operation finished, returning value...");
    }
}
