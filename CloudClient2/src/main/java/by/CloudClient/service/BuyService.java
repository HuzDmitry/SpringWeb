package by.CloudClient.service;


import by.CloudClient.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuyService {

    private final List<Product> buy = new ArrayList<>();


    public void addProduct(Product product){
        buy.add(product);
    }

    public void delProduct(int id){
        buy.remove(id);
    }

    public List<Product>getAll(){
        return buy;
    }

    public String buyOrder(){
        double price = 0;
       for (Product p: buy){
          price = p.getPrice()+price;
       }
       String message = "К оплате: "+price;
        return message;
    }
}
