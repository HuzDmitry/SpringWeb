package by.CloudClient.controller;

import by.CloudClient.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/buy")
public interface BuyImpl {

    @GetMapping
    List<Product> findAll();

    @PostMapping
    void addProduct(@RequestBody Product product);

    @DeleteMapping("/{id}")
    void delProduct(@PathVariable int id);

    @GetMapping("/order")
    String buyOrder();
}
