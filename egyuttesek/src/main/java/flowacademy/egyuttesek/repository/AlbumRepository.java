package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, String> {


    Optional<Album> findByBandId(String id);
}