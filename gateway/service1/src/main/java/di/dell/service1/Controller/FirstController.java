package di.dell.service1.Controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
public class FirstController {
    @GetMapping("/message")
    public String test() {
        return "This is the message from first service";
    }
}