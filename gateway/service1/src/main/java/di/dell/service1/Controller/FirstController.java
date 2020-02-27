package di.dell.service1.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employee")
public class FirstController {
    @GetMapping("/message")
    public String test(@RequestHeader("first-request") String header) {
        try { 
            System.out.println(new Date( ) + "\n"); 
            Thread.sleep(1000*6);   // 休眠3秒
            System.out.println(new Date( ) + "\n"); 
         } catch (Exception e) { 
             System.out.println("Got an exception!"); 
         }
        return "This is the message from first service, pre-filter: "+ header;
    }
}