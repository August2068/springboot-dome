package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.repository.UserRepository;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Override
    public User create(UserPostDTO dto) {
        User user = new User();
        user.setEmail(dto.email);
        user.setPassword(dto.password);
        user.setFirstname(dto.firsName);
        user.setLastname(dto.lastName);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public boolean delete(String id) {
        User user = getById(id);
        if(user!=null){
            user.setFirstname("Redacted");
            user.setLastname("Redacted");
            user.setPhone("Redacted");
            user.setEmail("Redacted");
            user.setPassword("Redacted");
            userRepository.saveAndFlush(user);
            return true;
        }
        return false;
    }

    @Override
    public User getById(String id) {
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public User update(String id, UserPutDTO dto) {
        User user = getById(id);
        if(user != null){
            user.setPhone(dto.phone);
            user.setFirstname(dto.firsName);
            user.setLastname(dto.lastName);
            userRepository.saveAndFlush(user);
        }
        return user;
    }

}
