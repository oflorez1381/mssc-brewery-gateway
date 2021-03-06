package odfd.com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Profile("google")
//@Configuration
public class GoogleConfig {

    @Bean
    public RouteLocator googleConfiguration(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/googlesearch")
                        .filters(f -> f.rewritePath("/googlesearch(?<segment>/?.*)","/${segment}"))
                    .uri("https://google.com"))
                .build();
    }

}
