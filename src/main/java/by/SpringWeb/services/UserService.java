package by.SpringWeb.services;

import by.SpringWeb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final NotificationService notificationService;

    @Autowired
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public String getMessage() {
        return "Hello";
    }
}
