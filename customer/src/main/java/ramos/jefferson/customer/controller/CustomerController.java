package ramos.jefferson.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ramos.jefferson.customer.model.Customer;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    @GetMapping
    public ResponseEntity<List<Customer>> get(@RequestHeader("server-gateway") String requestHeader) {
        log.info("Request Headers: {}", requestHeader);
        List<Customer> customerList = List.of(
                new Customer("Steve", "Jobs"),
                new Customer("Bill", "Gates"),
                new Customer("Elon", "Musk")
        );
        return ResponseEntity.ok(customerList);
    }
}
