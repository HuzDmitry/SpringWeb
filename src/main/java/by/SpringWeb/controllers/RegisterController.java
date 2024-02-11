package by.SpringWeb.controllers;

import by.SpringWeb.models.User;
import by.SpringWeb.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    @GetMapping("/login")
    public String getMessage(){
        return registerService.getMessage();
    }

    /**
     * Добавление пользователя в список. POST запрос с параметрами.
     *
     */
    @PostMapping("/api/add")
    public void addUser(@RequestParam String name, @RequestParam int age, @RequestParam String email){
        registerService.addUser(name, age, email);
    }

    /**
     * удаление пользователя по номеру
     * @param id
     */
    @DeleteMapping("/api/{id}")
    public void delUser(@PathVariable int id){
        registerService.delUser(id);
    }

    /**
     * Получение пользователя по номеру
     * @param id
     */
    @GetMapping("/api/{id}")
    public User getUser(@PathVariable int id){
        return registerService.getUser(id);
    }

    /**
     * Сортировка пользователей по возрасту
     * @return
     */
    @GetMapping("/user/sort")
    public ResponseEntity<List<User>>sortByAgeUser(){
        return new ResponseEntity<>(registerService.sortByAgeUser(), HttpStatus.OK);
    }

    /**
     * Фильтрация пользователей по возрасту
     * @param age
     * @return
     */
    @GetMapping("/user/filter/{age}")
    public List<User>filterByAgeUser(@PathVariable int age){
        return registerService.filterUsersByAge(age);
    }

    /**
     * вычисление среднего значения возраста пользователей
     * @return
     */
    @GetMapping("/user/calc")
    public Double calculateByAgeUser(){
        return registerService.calculateAverageAge();
    }
    @GetMapping("/api")
    public List<User> getAll(){
        return registerService.getUsersAll();
    }

}
