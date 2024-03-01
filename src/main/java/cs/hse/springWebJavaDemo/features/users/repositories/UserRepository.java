package cs.hse.springWebJavaDemo.features.users.repositories;

import cs.hse.springWebJavaDemo.features.songs.dto.AlbumDto;
import cs.hse.springWebJavaDemo.features.songs.repositories.AlbumRepository;
import cs.hse.springWebJavaDemo.features.users.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class UserRepository {
    private final ArrayList<UserDto> users = new ArrayList<>(Arrays.asList(
            new UserDto("1", "name1", Arrays.asList("1", "3")),
            new UserDto("2", "ahahaha", Arrays.asList("2", "4")),
            new UserDto("3", "username123", Arrays.asList("1")))
    );

    public enum Status {
        ERROR,
        SUCCESS
    }

    public UserDto getById(String id) {
        return users.stream().filter(n -> n.getId().equals(id)).findFirst().orElseThrow();
    }
    public Status addToUsersFavorites(String userId, String albumId) {
        if (users.stream().noneMatch(n -> n.getId().equals(userId))) {
            return Status.ERROR;
        }
        getById(userId).getFavoritesAlbumsIds().add(albumId);
        return Status.SUCCESS;
    }
}
