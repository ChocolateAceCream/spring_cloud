package di.dell.java_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;
import di.dell.java_gateway.config.TokenFilter;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("di.dell.java_gateway.config")

public class JavaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaGatewayApplication.class, args);
	}

}
