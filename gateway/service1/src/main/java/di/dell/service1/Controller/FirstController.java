package di.dell.service1.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class FirstController {
    @GetMapping("/message")
    public String test(@RequestHeader("first-request") String header) {
        return "This is the message from first service, pre-filter: "+ header;
    }
}