package di.dell.service2.Controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/consumer")
public class SecondController {
    @GetMapping("/message")
    public String test() {
        return "This is the message from second service";
    }
}