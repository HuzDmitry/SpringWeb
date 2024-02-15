package by.CloudClient.controller;

import by.CloudClient.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/review")
public interface ReviewImpl {
    @GetMapping
    Map<Product, List<String>> getReviewAll();
    @GetMapping("/product")
    List<String>getReviewByProduct(@RequestBody Product product);
    @PutMapping
    void setReviewByProduct(@RequestBody Product product,@RequestParam String message);
}
