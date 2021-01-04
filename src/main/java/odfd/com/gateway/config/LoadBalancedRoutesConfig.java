package odfd.com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local-discovery")
public class LoadBalancedRoutesConfig {

    @Bean
    public RouteLocator loadBalancedRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("beer-service",
                        r -> r.path("/api/v1/beer*", "/api/v1/beer/*", "/api/v1/beerUpc/*")
                                .uri("lb://beer-service"))
                .route("order-service",
                        r -> r.path("/api/v1/customers/**")
                                .uri("lb://order-service"))
                .route("inventory-service",
                        r -> r.path("/api/v1/beer/*/inventory")
                                .uri("lb://inventory-service"))
                .build();
    }

}
