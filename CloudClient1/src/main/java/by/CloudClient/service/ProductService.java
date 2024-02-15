package by.CloudClient.service;

import by.CloudClient.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products;

    public ProductService() {
        this.products =new ArrayList<>();
    }

    public Product addProduct(Product product){
        products.add(product);
        return product;
    }
    public Product delProduct(int id){
        Product product =products.stream().filter((n)->n.getId()==id).findFirst().orElseThrow();
        products.remove(product);
        Product.setCount(Product.getCount()-1);
        return product;
    }
    public Product getProduct(int id){
        return products.stream().filter((n)->n.getId()==id).findFirst().orElseThrow();
    }
    public List<Product>getAllProduct(){
        return products;
    }
    public List<Product>generateProduct(){
        products.add(new Product("aple",12));
        products.add(new Product("orange",14));
        products.add(new Product("mango",20));
        return products;
    }


}
