package by.CloudClient.controller;

import by.CloudClient.model.Product;
import by.CloudClient.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyController implements BuyImpl{

    private final BuyService service;
    @Autowired
    public BuyController(BuyService service) {
        this.service = service;
    }

    @Override
    public List<Product> findAll() {
        return service.getAll();
    }

    @Override
    public void addProduct(Product product) {
        service.addProduct(product);
    }

    @Override
    public void delProduct(int id) {
        service.delProduct(id);
    }

    @Override
    public String buyOrder() {
        return service.buyOrder();
    }
}
