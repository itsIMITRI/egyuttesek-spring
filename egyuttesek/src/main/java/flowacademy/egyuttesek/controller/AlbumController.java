package flowacademy.egyuttesek.controller;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.dto.AlbumResponse;
import flowacademy.egyuttesek.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/album")
public class AlbumController {

    private final AlbumService albumService;
    @GetMapping()
    public List<AlbumResponse> getAllAlbum() {
        return albumService.findAll();
    }

    @GetMapping("/{band}")
    public List<AlbumResponse> getAlbumsByBand(@PathVariable String band) {
        return albumService.findBandById(band);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createAlbum(@RequestBody Album album) {
        albumService.createAlbum(album);
    }

}
