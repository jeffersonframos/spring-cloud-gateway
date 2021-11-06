package ramos.jefferson.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ramos.jefferson.product.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @GetMapping
    public ResponseEntity<List<Product>> get(@RequestHeader("server-gateway") String requestHeader) {
        log.info("Request Headers: {}", requestHeader);
        List<Product> productList = List.of(
                new Product("iPhone", BigDecimal.ZERO),
                new Product("Windows", BigDecimal.ONE),
                new Product("Tesla", BigDecimal.TEN)
        );
        return ResponseEntity.ok(productList);
    }
}
