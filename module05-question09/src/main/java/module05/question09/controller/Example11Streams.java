package module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * InputStream and OutputStream Example
 * <br/><br/>
 * curl -X POST -H "Content-Type: application/octet-stream" -d "{ request body content }" localhost:8080/actionK
 */
@Controller
public class Example11Streams {

    @RequestMapping("/actionK")
    @ResponseBody
    public void actionK(InputStream inputStream, OutputStream outputStream) throws IOException {
        inputStream.transferTo(outputStream);
        outputStream.write(10);
    }
}
