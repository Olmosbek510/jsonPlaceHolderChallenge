package uz.inha.backend.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.inha.backend.dto.jsonDto.*;
import uz.inha.backend.entity.Role;
import uz.inha.backend.entity.User;
import uz.inha.backend.entity.enums.RoleName;
import uz.inha.backend.entity.jsonElements.Photo;
import uz.inha.backend.entity.jsonElements.UserJson;
import uz.inha.backend.repository.RoleRepository;
import uz.inha.backend.repository.UserJsonRepository;
import uz.inha.backend.repository.UserRepository;
import uz.inha.backend.service.jsonObjectsService.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@RequiredArgsConstructor
@Component
public class Runner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserJsonRepository userJsonRepository;
    private final TodoService todoService;
    private final PostService postService;
    private final CommentService commentService;
    private final AlbumService albumService;
    private final PhotoService photoService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String create;

    @Override
    public void run(String... args) throws Exception {
        if (create.equals("create")) {
            genData();
        }
    }

    private void genData() {
        roleRepository.saveAll(List.of(
                Role.builder()
                        .roleName(RoleName.ROLE_ADMIN)
                        .build(),
                Role.builder()
                        .roleName(RoleName.ROLE_USER)
                        .build()

        ));
        userRepository.saveAll(List.of(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("123"))
                        .age(19)
                        .roles(List.of(roleRepository.findRoleByRoleName(RoleName.ROLE_ADMIN)))
                        .build(),
                User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("1234"))
                        .roles(List.of(roleRepository.findRoleByRoleName(RoleName.ROLE_USER)))
                        .age(18)
                        .build()
        ));
    }

    public void genUsers() {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/users")).GET().build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            List<UserJson> list = objectMapper.readValue(response.body(), new TypeReference<>() {
            });
            userJsonRepository.saveAll(list);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void genTodos() {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/todos")).GET().build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            List<TodoDto> todoDtos = objectMapper.readValue(response.body(), new TypeReference<>() {});
            todoService.saveAll(todoDtos);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void genPosts(){
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/posts")).GET().build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            List<PostDto> postDtos = objectMapper.readValue(response.body(), new TypeReference<>() {});
            postService.saveAll(postDtos);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void genComments(){
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/comments")).GET().build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            List<CommentDto> commentDtos = objectMapper.readValue(response.body(), new TypeReference<>() {});
            commentService.saveAll(commentDtos);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void genAlbums(){
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/albums")).GET().build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            List<AlbumDto> albumDtos = objectMapper.readValue(response.body(), new TypeReference<>() {});
            albumService.saveAll(albumDtos);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void genPhotos(){
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/photos")).GET().build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            List<PhotoDto> photos = objectMapper.readValue(response.body(), new TypeReference<>() {});
            photoService.saveAll(photos);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
