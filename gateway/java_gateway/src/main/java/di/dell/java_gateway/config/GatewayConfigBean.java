package di.dell.java_gateway.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import di.dell.java_gateway.config.RequestTimeFilter;

@Configuration
public class GatewayConfigBean {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(
                r -> r.path("/employee/**")
                .filters(
                    f -> f
                        // .filter(new RequestTimeFilter())
                        .addRequestHeader("first-request","first-request-header")
                        .addResponseHeader("first-response","first-response-header")
                        .hystrix(
                            h -> h.setName("Hystrix").setFallbackUri("forward:/fallback/message")
                        )
                ) 
                .uri("lb://FIRST-SERVICE")
                .id("employeeModule")
            )

            .route( 
                r-> r.path("/consumer/**")
                .filters(f->f
                            .hystrix(
                                h -> h
                                    .setName("Hystrix")
                                    .setFallbackUri("forward:/fallback/message")
                            )
                    .filter(new RequestTimeFilter())
                    .addRequestHeader("second-request","second-request-header")
                    .addResponseHeader("second-response","second-response-header"))  
                .uri("lb://SECOND-SERVICE")
                .id("consumerModule")
            )
            .build();
    }

}
