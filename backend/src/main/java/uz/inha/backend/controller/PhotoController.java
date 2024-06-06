package uz.inha.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.inha.backend.entity.jsonElements.Photo;
import uz.inha.backend.service.jsonObjectsService.PhotoService;

import java.util.List;

@RestController
@RequestMapping("/api/photo")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;
    @GetMapping("/filter")
    public ResponseEntity<List<Photo>> getPhotosByUser(@RequestParam("albumId") Integer albumId){
        return ResponseEntity.ok(photoService.findPhotoByAlbum(albumId));
    }
}
