package by.SpringWeb.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDb{
 private final List<User> userList;

    public UserDb() {
        this.userList = new ArrayList<>();
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

