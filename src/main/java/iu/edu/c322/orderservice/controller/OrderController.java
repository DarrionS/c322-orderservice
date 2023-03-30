package iu.edu.c322.orderservice.controller;

import iu.edu.c322.orderservice.model.Order;
import iu.edu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository repository;


    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@Valid @RequestBody @PathVariable int id) {
        return repository.getOrderById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody Order order){
        return repository.create(order);
    }

    // PUT localhost:808/customers/2
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Order order, @PathVariable int id) {
        repository.update(order,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repository.delete(id);
    }
}
