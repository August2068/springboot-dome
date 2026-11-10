package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import fr.simplon.domedespuys.view.UserView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IUserService userService;

    @GetMapping("/{id}")
    @JsonView(UserView.UserViewDetail.class)
    public User getUserById(@PathVariable String id){
        return userService.getById(id);
    }
}
