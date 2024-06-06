package uz.inha.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.inha.backend.entity.User;
import uz.inha.backend.repository.UserRepository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User getById(UUID uuid){
        return userRepository.findById(uuid).orElseThrow();
    }

    public User getByUserName(String username){
        return userRepository.findUserByUsername(username).orElseThrow();
    }
}
