package by.CloudClient.controller;


import by.CloudClient.model.Product;
import by.CloudClient.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ReviewController implements ReviewImpl {

    private final ReviewService service;
    @Autowired
    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @Override
    public Map<Product, List<String>> getReviewAll() {
        return service.getReviewAll();
    }

    @Override
    public List<String> getReviewByProduct(Product product) {
        return service.findReviewByProduct(product);
    }

    @Override
    public void setReviewByProduct(Product product, String message) {
        service.addReviewByProduct(product, message);
    }
}
