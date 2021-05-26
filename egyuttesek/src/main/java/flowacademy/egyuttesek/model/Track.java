package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public class Track {
    @Id
    private UUID id;
    private String name;
    private int trackLength;
    private int licensePrice;
    @ManyToOne
    @JoinColumn
    private Album album;
    @ManyToOne
    private MusicService musicService;
}
