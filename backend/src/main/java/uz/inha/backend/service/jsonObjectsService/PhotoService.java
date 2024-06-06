package uz.inha.backend.service.jsonObjectsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.inha.backend.dto.jsonDto.PhotoDto;
import uz.inha.backend.entity.jsonElements.Photo;
import uz.inha.backend.repository.AlbumRepository;
import uz.inha.backend.repository.PhotoRepository;

import java.util.List;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class PhotoService {
    private final AlbumRepository albumRepository;
    private final PhotoRepository photoRepository;
    public void saveAll(List<PhotoDto> photos) {
        photos.forEach(photoDto -> {
            photoRepository.save(new Photo(
                    albumRepository.findById(photoDto.getAlbumId()).orElseThrow(),
                    photoDto.getTitle(),
                    photoDto.getUrl(),
                    photoDto.getThumbnailUrl()
            ));
        });
    }
}
