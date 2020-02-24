package di.dell.java_gateway.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfigBean {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/employee/**")
                    .uri("http://localhost:9408")
                    .id("employeeModule"))
            .route( r-> r.path("/consumer/**")
                    .uri("http://localhost:9407")
                    .id("consumerModule"))
            .build();
    }
}
