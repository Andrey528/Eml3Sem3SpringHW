package ru.geekbrains.Eml3Sem3SpringHW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.Eml3Sem3SpringHW.domain.User;
import ru.geekbrains.Eml3Sem3SpringHW.service.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().save(user);
        return "User added from body!";
    }

    @PostMapping("/param")
    public String userAddFromParam(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        service.getUserService().createUser(name, age, email);
        return "User added from parameters!";
    }
}
