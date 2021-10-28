package api.route.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("pudding_route", r -> r.path("/pudding/**").and().method("GET")
                        .uri("http://localhost:8080"))
                .route("pie_route", r -> r.path("/pie/**").and().method("GET")
                        .uri("http://localhost:8081"))
                .route("users_route", r -> r.path("/api/users/**").and().method("GET", "POST", "PUT", "DELETE")
                        .uri("http://localhost:8081"))
                .build();
    }

}
