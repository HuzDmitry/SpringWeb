package by.SpringWeb.services;

import by.SpringWeb.models.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
    public void getUser(User user){
        System.out.println("Получен пользователь: "+user.getName());
    }
    public void delUser(User user){
        System.out.println("Удален пользователь: "+user.getName());
    }
    public void sortUser(){
        System.out.println("сортировка пользователей");
    }
    public void calculateUserByAge(){
        System.out.println("вычисление среднего возраста всех пользователей");
    }
    public void filtrUser(int age){
        System.out.println("фильтрация пользователей по возрасту больше: "+age);
    }

}
