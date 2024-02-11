package by.SpringWeb.models;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDb{

 private final List<User> userList;

    public UserDb() {
        this.userList = Arrays.asList(new User("Dima", 20, "www@mail.com"),
                new User("Ira", 23, "www@mail.com"),
                new User("Kola", 29,"www@mail.com"),
                new User("Natasha", 31 ,"www@gmail.com"));
    }

    public void saveUser(User user){
     userList.add(user);
 }
 public User loadUser(int id){
     return userList.get(id);
 }
 public List<User> getUsers(){
     return userList;
 }
 public User delUser(int id){
     return userList.remove(id);
 }
}

