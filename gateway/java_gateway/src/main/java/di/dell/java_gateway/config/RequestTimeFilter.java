package di.dell.java_gateway.config;

import org.springframework.core.Ordered;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;

import reactor.core.publisher.Mono;
import org.springframework.web.server.ServerWebExchange;

public class RequestTimeFilter implements GatewayFilter, Ordered {
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
        return chain.filter(exchange).then(
            Mono.fromRunnable(() -> {
                Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                if (startTime != null) {
                    System.out.println(exchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
                }
            })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}