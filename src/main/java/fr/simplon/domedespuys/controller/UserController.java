package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import fr.simplon.domedespuys.view.UserView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(UserView.UserViewDetail.class)
    public User createUser(@Valid @RequestBody UserPostDTO dto){
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(UserView.UserViewDetail.class)
    public User updateUser(@PathVariable String id, @Valid @RequestBody UserPutDTO dto){
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable String id){
        return userService.delete(id);
    }
}
