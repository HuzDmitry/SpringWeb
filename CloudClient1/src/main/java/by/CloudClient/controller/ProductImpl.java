package by.CloudClient.controller;

import by.CloudClient.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
public interface ProductImpl {
    @GetMapping
    List<Product>findAll();

    @GetMapping("/{id}")
    Product findById(@PathVariable int id);

    @GetMapping("/gen")
    List<Product>generateProduct();

    @DeleteMapping("/{id}")
    Product delProduct(@PathVariable int id);

    @PostMapping
    Product addProduct(@RequestBody Product product);
}
