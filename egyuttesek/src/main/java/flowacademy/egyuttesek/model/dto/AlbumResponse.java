package flowacademy.egyuttesek.model.dto;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Track;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class AlbumResponse {

    private String id;
    private String name;
    private Date releaseDate;
    private int trackLenghtSum;


    public AlbumResponse(String id, String name){
        this.id = id;
        this.name = name;
    }

    public static AlbumResponse giveIdName(Album album){
        return new AlbumResponse(album.getId(), album.getName());
    }

    public static AlbumResponse giveIdNameDateTrackLenghtSum(Album album){
        int trackLength = album.getTrackList().stream().map(Track::getTrackLength).reduce(0, Integer::sum);

        return new AlbumResponse(album.getId(), album.getName(), album.getReleaseDate(),trackLength);
    }
}
