package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    public List<Album> findByBand(String band) {
        return albumRepository.findByBandContaining(band);
    }

    public List<Album> findAllAlbum() {
        return albumRepository.findAll();
    }

    public Album addAlbum(Album album) {
        return albumRepository.save(
                Album.builder()
                        .id(UUID.randomUUID())
                        .name(album.getName())
                        .build());
    }

}
