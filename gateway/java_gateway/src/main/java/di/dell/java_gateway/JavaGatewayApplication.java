package di.dell.java_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@ComponentScan("di.dell.java_gateway.config")
@EnableEurekaClient
@EnableHystrix
public class JavaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaGatewayApplication.class, args);
	}

}
