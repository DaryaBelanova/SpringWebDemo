package cs.hse.springWebJavaDemo.features.users.dto;

import cs.hse.springWebJavaDemo.features.songs.dto.AlbumDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {
    private String id;
    private String nickname;
    private List<String> favoritesAlbumsIds;
}
