package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    private UUID id;
    private String name;
    private Date releaseDate;
    @ManyToOne
    @JoinColumn
    private Band band;
    @OneToMany(mappedBy = "album")
    private List<Track> trackList;

}
