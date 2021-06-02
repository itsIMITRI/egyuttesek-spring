package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.dto.AlbumResponse2;
import flowacademy.egyuttesek.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class AlbumServiceTest {
    @InjectMocks
    AlbumService albumService;

    @Mock
    AlbumRepository albumRepository;

    @Test
    public void findAllAlbumTest() {
        List<Album> albumList = List.of(
                Album.builder().id("ID01").name("Album Cím1").build(),
                Album.builder().id("ID02").name("Album Cím2").build(),
                Album.builder().id("ID03").name("Album Cím3").build()
        );
        when(albumRepository.findAll()).thenReturn(albumList);

        assertEquals(3, albumService.findAll().size());
    }

    @Test
    void findByBandId() {
        List<Album> albumList = List.of(
                Album.builder().id("A01").name("Album Cím1").band(
                        Band.builder().id("B01").build()
                ).build(),
                Album.builder().id("A02").name("Album Cím1").band(
                        Band.builder().id("B02").build()
                ).build(),
                Album.builder().id("A02").name("Album Cím1").band(
                        Band.builder().id("B03").build()
                ).build()
        );
        BDDMockito.given(albumRepository.findByBandId("B03")).willReturn(Optional.of(Album.builder().id("A02").name("Album Cím1").band(
                Band.builder().id("B03").build()
        ).build()));
//        System.out.println(albumList);
//        List<AlbumResponse2> albums = albumService.findBandById("B03");

    assertEquals(albumService.findBandById("B03"), List.of(new AlbumResponse2("A02","Album Cím1",null, 0)));

    }

//    @Test
//    void findByName() {
//        Band band1 = Band.builder().id("ID1").name("Metallica").build();
//
//        Album album = Album.builder().id("ID01").name("Album Cím1").band(band1).build();
//        when(albumRepository.findByBandNameContaining("Metallica")).thenReturn(List.of(album));
//
//        assertEquals("ID01",albumService.findByName("Metallica").get(0).split(";")[0]);
//    }

}
