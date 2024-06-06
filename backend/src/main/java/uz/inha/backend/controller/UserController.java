package uz.inha.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.inha.backend.entity.jsonElements.UserJson;
import uz.inha.backend.repository.UserJsonRepository;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserJsonRepository userJsonRepository;
    @GetMapping
    public ResponseEntity<List<UserJson>> getUsers(){
        return ResponseEntity.ok(userJsonRepository.findAll());
    }
}
