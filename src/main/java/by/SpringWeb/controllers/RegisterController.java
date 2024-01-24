package by.SpringWeb.controllers;

import by.SpringWeb.models.User;
import by.SpringWeb.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/reg")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    /**
     * Простое сообщение
     * @return
     */
    @GetMapping(value = "/api")
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<>("Yello",HttpStatus.OK);
    }

    /**
     * Добавление пользователя в список. POST запрос с параметрами.
     * @param name
     * @param age
     * @param email
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestParam String name, @RequestParam int age, @RequestParam String email){
        registerService.addUser(name, age, email);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * удаление пользователя по номеру
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<User> delUser(@RequestParam int id){
        return new ResponseEntity<>(registerService.delUser(id), HttpStatus.OK);
    }

    /**
     * Получение пользователя по номеру
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User>getUser(@RequestParam int id){
        return new ResponseEntity<>(registerService.getUser(id), HttpStatus.OK);
    }

    /**
     * Сортировка пользователей по возрасту
     * @return
     */
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public ResponseEntity<List<User>>sortByAgeUser(){
        return new ResponseEntity<>(registerService.sortByAgeUser(), HttpStatus.OK);
    }

    /**
     * Фильтрация пользователей по возрасту
     * @param age
     * @return
     */
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ResponseEntity<List<User>>filterByAgeUser(@RequestParam int age){
        return new ResponseEntity<>(registerService.filterUsersByAge(age), HttpStatus.OK);
    }

    /**
     * вычисление среднего значения возраста пользователей
     * @return
     */
    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public ResponseEntity<Double>calculateByAgeUser(){
        return new ResponseEntity<>(registerService.calculateAverageAge(), HttpStatus.OK);
    }

}
