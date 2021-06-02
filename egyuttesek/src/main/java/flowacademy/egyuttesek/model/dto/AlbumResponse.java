package flowacademy.egyuttesek.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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


    public static AlbumResponse giveIdName(Album album){
        return new AlbumResponse(album.getId(), album.getName());
    }


}
