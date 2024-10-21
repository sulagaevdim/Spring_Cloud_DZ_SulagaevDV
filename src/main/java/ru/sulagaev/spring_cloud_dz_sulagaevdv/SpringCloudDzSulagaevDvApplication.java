package ru.sulagaev.spring_cloud_dz_sulagaevdv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudDzSulagaevDvApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDzSulagaevDvApplication.class, args);
    }
    @Bean
    public RouteLocator customRouteLokator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Products", r -> r.path("/products/**").uri("http://localhost:8081/"))
                .route("Cart", r -> r.path("/cart/**").uri("http://localhost:8082/"))
                .route("Reviews", r -> r.path("/reviews/**").uri("http://localhost:8083/"))
                .build();
    }
}
