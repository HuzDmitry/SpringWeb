package by.CloudClient.service;

import by.CloudClient.model.Product;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ReviewService {
    private final Map<Product, List<String>> review = new HashMap<>();

    public Map<Product, List<String>>  getReviewAll(){
        return review;
    }

    public List<String>findReviewByProduct(Product product){
        return review.get(product);
    }

    public void addReviewByProduct(Product product, String message){
        if (review.containsKey(product)){
            List<String>reviews = review.get(product);
            reviews.add(message);
            review.put(product, reviews);
        }else{
            review.put(product, Arrays.asList(message));
        }
    }
}
