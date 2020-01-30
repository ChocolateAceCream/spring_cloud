package di.kafka.kafka.service;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    String kafkaTopic = "java_in_user_topic";
    public void send(String message){
        kafkaTemplate.send(kafkaTopic, message);
    }
}