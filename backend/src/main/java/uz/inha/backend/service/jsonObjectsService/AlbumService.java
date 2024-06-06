package uz.inha.backend.service.jsonObjectsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.inha.backend.dto.jsonDto.AlbumDto;
import uz.inha.backend.entity.jsonElements.Album;
import uz.inha.backend.repository.AlbumRepository;
import uz.inha.backend.repository.UserJsonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final UserJsonRepository userJsonRepository;
    private final AlbumRepository albumRepository;
    public void saveAll(List<AlbumDto> albumDtos) {
        albumDtos.forEach(albumDto -> {
            albumRepository.save(new Album(
                    userJsonRepository.findById(albumDto.getUserId()).orElseThrow(),
                    albumDto.getTitle()
            ));
        });
    }

    public List<Album> getByUserId(Integer userId) {
        return albumRepository.findAlbumByUserId(userId);
    }
}
