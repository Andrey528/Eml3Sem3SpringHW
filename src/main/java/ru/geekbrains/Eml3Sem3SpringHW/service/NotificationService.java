package ru.geekbrains.Eml3Sem3SpringHW.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.Eml3Sem3SpringHW.domain.User;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void sendNotification(String s) {
        System.out.println(s);
    }
}
