package by.CloudClient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client1")
public class NewClient1 {
    @GetMapping("/")
    public String getMessage(){
        return "привет";
    }
}
