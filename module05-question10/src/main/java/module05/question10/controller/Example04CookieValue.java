package module05.question10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * curl -c cookie.txt -b cookie.txt http://localhost:8080/example04/set-cookie
 * <br/><br/>
 * curl -c cookie.txt -b cookie.txt http://localhost:8080/example04/read-cookie1
 * <br/><br/>
 * curl -c cookie.txt -b cookie.txt http://localhost:8080/example04/read-cookie2
 * <br/><br/>
 * curl -c cookie.txt -b cookie.txt http://localhost:8080/example04/read-cookie3
 * <br/><br/>
 * curl http://localhost:8080/example04/read-cookie3
 * <br/><br/>
 * curl -c cookie.txt -b cookie.txt http://localhost:8080/example04/read-cookie4
 * <br/><br/>
 * curl http://localhost:8080/example04/read-cookie4
 * <br/><br/>
 * curl -c cookie.txt -b cookie.txt http://localhost:8080/example04/read-cookie5
 * <br/><br/>
 * curl http://localhost:8080/example04/read-cookie5
 */
@Controller
public class Example04CookieValue {

    @GetMapping("/example04/set-cookie")
    @ResponseBody
    public String example04(HttpServletResponse servletResponse) {
        servletResponse.addCookie(new Cookie("user-id", "15"));
        return "Cookie set successfully\n";
    }

    @GetMapping("/example04/read-cookie1")
    @ResponseBody
    public String example04ReadCookie1(@CookieValue("user-id") String userId) {
        return String.format("user-id from cookie = [%s]\n", userId);
    }

    @GetMapping("/example04/read-cookie2")
    @ResponseBody
    public String example04ReadCookie2(@CookieValue("user-id") Cookie cookie) {
        return String.format(
                "Received cookie name = [%s], value = [%s]\n",
                cookie.getName(), cookie.getValue()
        );
    }

    @GetMapping("/example04/read-cookie3")
    @ResponseBody
    public String example04ReadCookie3(@CookieValue(value = "user-id", required = false) String userId) {
        return String.format("user-id from cookie = [%s]\n", userId);
    }

    @GetMapping("/example04/read-cookie4")
    @ResponseBody
    public String example04ReadCookie4(@CookieValue(value = "user-id", required = false, defaultValue = "N/A") String userId) {
        return String.format("user-id from cookie = [%s]\n", userId);
    }

    @GetMapping("/example04/read-cookie5")
    @ResponseBody
    public String example04ReadCookie5(@CookieValue(value = "user-id") Optional<String> userId) {
        return String.format("user-id from cookie = [%s]\n", userId.orElse("N/A"));
    }
}
