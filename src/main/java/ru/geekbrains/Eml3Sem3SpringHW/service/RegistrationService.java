package ru.geekbrains.Eml3Sem3SpringHW.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public void processRegistration(String name, int age, String email) {
        userService.createUser(name, age, email);
    }
}
