package by.CloudClient.controller;

import by.CloudClient.model.Product;
import by.CloudClient.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductImpl{

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @Override
    public List<Product> findAll() {
        return service.getAllProduct();
    }

    @Override
    public Product findById(int id) {
        return service.getProduct(id);
    }

    @Override
    public List<Product> generateProduct() {
        return service.generateProduct();
    }

    @Override
    public Product delProduct(int id) {
        return service.delProduct(id);
    }

    @Override
    public Product addProduct(Product product) {
        return service.addProduct(product);
    }
}
