package di.kafka.kafka.controller;

import di.kafka.kafka.service.KafkaSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/kafka/")
public class ApacheKafkaWebController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("message") String message) {
        kafkaSender.send(message);
        logger.debug("This is a debug message, Message sent to the kafka topic successfully");
        logger.info("This is info message, Message sent to the kafka topic successfully");
        logger.warn("This is a warn message, Message sent to the kafka topic successfully");
        logger.error("This is error message,Message sent to the kafka topic successfully");

        try {
            System.out.println(5 / 0);
        } catch (Exception e) {
            logger.error(e);
        }

        return "Message sent to the kafka topic successfully";
    }
}
