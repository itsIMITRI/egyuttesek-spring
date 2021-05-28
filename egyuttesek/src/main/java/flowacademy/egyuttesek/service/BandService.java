package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.repository.BandRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BandService {
    private final BandRepository bandRepository;

    public List<Band> findAllBand() {
        return bandRepository.findAll();
    }

    public Band createBand(Band band){
        return  bandRepository.save(
                Band.builder()
                        .id(UUID.randomUUID())
                        .name(band.getName())
                        .musicGenre(band.getMusicGenre())
                        .build()
        );
}
}
