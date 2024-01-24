package by.SpringWeb.controllers;

import by.SpringWeb.models.User;
import by.SpringWeb.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api")
public class DataProcessingController {
    private final DataProcessingService dataProcessingService;

    @Autowired
    public DataProcessingController(DataProcessingService helloService) {
        this.dataProcessingService = helloService;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        String responce = this.dataProcessingService.getGreeting();

        return new ResponseEntity<>(responce, HttpStatus.OK);
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<User>> sortUsers(@RequestBody List<User> users) {
        return new ResponseEntity<>(dataProcessingService.sortUsersByAge(users), HttpStatus.OK);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ResponseEntity<List<User>> filterUsersByAge(@RequestParam Integer age, @RequestBody List<User> users) {
        return new ResponseEntity<>(dataProcessingService.filterUsersByAge(users, age), HttpStatus.OK);
    }

    @RequestMapping(value = "/average", method = RequestMethod.POST)
    public ResponseEntity<Double> average(@RequestBody List<User> users) {
        return new ResponseEntity<>(dataProcessingService.calculateAverageAge(users), HttpStatus.OK);
    }
}
