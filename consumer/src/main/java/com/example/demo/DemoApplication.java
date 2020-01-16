package com.example.demo;

import com.example.demo.controllers.ConsumerControllerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
@EnableFeignClients
//@EnableFeignClients("com.example.*")
//@ComponentScan(basePackages = {"com.example.demo.service"})
public class DemoApplication {

    public static void main(String[] args) throws RestClientException, IOException,InterruptedException {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        ConsumerControllerClient consumerControllerClient = ctx.getBean(ConsumerControllerClient.class);
        System.out.println(consumerControllerClient);

        //for(int i=0; i<100; i++){
            //Thread.sleep(60);
            consumerControllerClient.getEmployee();
        //}
    }

    @Bean
    public ConsumerControllerClient consumerControllerClient() {
        return new ConsumerControllerClient();
    }

}


