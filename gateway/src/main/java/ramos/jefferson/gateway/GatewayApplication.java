package ramos.jefferson.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route("customer", route -> route
						.path("/customer/**")
						.filters(filter -> filter.addRequestHeader("server-gateway", "customer"))
						.uri("http://localhost:8081/customer"))
				.route("product", route -> route
						.path("/product/**")
						.filters(filter -> filter.addRequestHeader("server-gateway", "product"))
						.uri("http://localhost:8082/product"))
				.build();
	}

}
