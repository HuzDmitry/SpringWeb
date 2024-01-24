package by.SpringWeb.services;

import by.SpringWeb.models.User;
import by.SpringWeb.models.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Создать сервис "RegistrationService",
// который принимает на вход данные о пользователе (имя, возраст, email),
// создает пользователя с помощью UserService, затем использует DataProcessingService для
// добавления пользователя в список и выполнения операций над этим списком.
// После выполнения каждой операции, использовать NotificationService для вывода информации
// о выполненной операции.
@Service
public class RegisterService {

    private final UserService userService;
    private  final DataProcessingService dataProcessingService;
    private  final NotificationService notificationService;
    private  final UserDb userDb;

    @Autowired
    public RegisterService(UserService userService, DataProcessingService dataProcessingService, NotificationService notificationService, UserDb userDb) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
        this.notificationService = notificationService;
        this.userDb = userDb;
    }

    /**Добавление пользователя в список.
     * @param name
     * @param age
     * @param email
     */
    public void addUser(String name, int age, String email){
        User us = userService.createUser(name, age, email);
        userDb.saveUser(us);
        notificationService.notifyUser(us);
    }

    /**
     * Просмотр пользователя по номеру.
     * @param id
     * @return
     */
    public User getUser(int id){
        User us = userDb.loadUser(id);
        notificationService.getUser(us);
        return us;
    }

    /**
     * Удаление пользователя по порядковому номеру.
     * @param id
     * @return
     */
    public User delUser(int id){
        User us = userDb.delUser(id);
        notificationService.delUser(us);
        return us;
    }

    /**
     * Сортировка пользователей по возрасту
     * @return
     */
    public List<User> sortByAgeUser(){
        notificationService.sortUser();
        return dataProcessingService.sortUsersByAge(userDb.getUsers());
    }

    /**
     * Фильтрация пользователей по возрасту
     * @param age
     * @return
     */
    public List<User> filterUsersByAge( int age) {
        notificationService.filtrUser(age);
        return dataProcessingService.filterUsersByAge(userDb.getUsers(), age);
    }

    /**
     * Вычисление среднего значения всех пользователей
     * @return
     */
    public double calculateAverageAge() {
        notificationService.calculateUserByAge();
        return dataProcessingService.calculateAverageAge(userDb.getUsers());
    }
}
