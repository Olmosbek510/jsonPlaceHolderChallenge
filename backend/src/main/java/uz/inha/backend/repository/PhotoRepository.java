package uz.inha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.inha.backend.entity.jsonElements.Photo;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    List<Photo> findPhotoByAlbumId(Integer albumId);
}