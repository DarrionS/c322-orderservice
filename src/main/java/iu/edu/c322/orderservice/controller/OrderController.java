package iu.edu.c322.orderservice.controller;

import iu.edu.c322.orderservice.model.*;
import iu.edu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/order/{orderId}")
    public Optional<Order> getOrderById(@PathVariable int orderId) {
        return repository.findById(orderId);
    }

    @GetMapping("/{customerId}")
    public List<Order> getCustomerById(@PathVariable int customerId) {
        return repository.findByCustomerId(customerId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody Order order){
        for(int i = 0; i < order.getItems().size(); i++){
            Item item = order.getItems().get(i);
            item.setOrder(order);
        }
        Order addedOrder = repository.save(order);
        return addedOrder.getId();
    }
}
