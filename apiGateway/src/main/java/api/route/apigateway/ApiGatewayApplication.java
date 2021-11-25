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
                .route("home_route", r -> r.path("/").and().method("GET")
                        .uri("http://localhost:8081"))
                .route("auth_route", r -> r.path("/login").and().method("GET")
                        .uri("http://localhost:8081"))
                .route("auth_route", r -> r.path("/doLogin").and().method("POST")
                        .uri("http://localhost:8081"))
                .route("register_route", r -> r.path("/register").and().method("GET")
                        .uri("http://localhost:8081"))
                .route("register_route", r -> r.path("/doRegister").and().method("POST")
                        .uri("http://localhost:8081"))
                .route("register_route", r -> r.path("/doLogout").and().method("GET")
                        .uri("http://localhost:8081"))
                .route("users_route", r -> r.path("/api/users/**").and().method("GET", "POST", "PUT", "DELETE")
                        .uri("http://localhost:8081"))
                .route("confirmUser_route", r -> r.path("/userConfirm*").and().method("GET")
                        .uri("http://localhost:8081"))
                .route("covid_alert_route", r -> r.path("/alert/*").and().method("GET")
                        .uri("http://localhost:8082"))
                .route("covid_vaccine_route", r -> r.path("/vaccine").and().method("GET")
                        .uri("http://localhost:8082"))
                .build();
    }
}
