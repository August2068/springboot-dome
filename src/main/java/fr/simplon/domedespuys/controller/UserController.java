package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id){
        return userRepository.findById(Long.valueOf(id));
    }
}
