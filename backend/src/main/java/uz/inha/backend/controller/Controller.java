package uz.inha.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.inha.backend.entity.jsonElements.Album;
import uz.inha.backend.service.jsonObjectsService.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/api/album")
@RequiredArgsConstructor
public class Controller {
    private final AlbumService albumService;
    public ResponseEntity<List<Album>> getAlbums(@RequestParam("userId") Integer userId){
        return ResponseEntity.ok(albumService.getByUserId(userId));
    }
}
