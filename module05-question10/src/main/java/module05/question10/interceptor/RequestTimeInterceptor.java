package module05.question10.interceptor;

import module05.question10.ds.MutableCountHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

// this will set a new attribute by intercepting each request, and we can get this attribute in /example08A or /example08B endpoints
@Component
public class RequestTimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("processing-time", LocalDateTime.now());

        if (request.getSession().getAttribute("mutableCountHolder") == null)
            request.getSession().setAttribute("mutableCountHolder", new MutableCountHolder());

        return true;
    }
}
