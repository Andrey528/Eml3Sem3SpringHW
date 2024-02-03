package ru.geekbrains.Eml3Sem3SpringHW.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.Eml3Sem3SpringHW.domain.User;
import ru.geekbrains.Eml3Sem3SpringHW.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, int age, String email) {
        User user = new User(name, age, email);
        userRepository.save(user);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
}
