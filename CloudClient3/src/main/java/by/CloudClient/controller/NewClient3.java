package by.CloudClient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client3")
public class NewClient3 {
    @GetMapping("/")
    public String getMessage(){
        return "клиент 3";
    }
}
