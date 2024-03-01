package cs.hse.springWebJavaDemo.features.users.services;

import cs.hse.springWebJavaDemo.features.songs.dto.AlbumDto;
import cs.hse.springWebJavaDemo.features.songs.dto.SongDto;
import cs.hse.springWebJavaDemo.features.songs.repositories.AlbumRepository;
import cs.hse.springWebJavaDemo.features.users.dto.UserDto;
import cs.hse.springWebJavaDemo.features.users.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<String> getFavoritesById(String id) {
        return userRepository.getById(id).getFavoritesAlbumsIds();
    }

    public String tryAddAlbumId(String userId, String albumId) {
        if (userRepository.addToUsersFavorites(userId, albumId) == UserRepository.Status.SUCCESS) {
            return "Album with id=" + albumId + " was successfully added";
        }

        return "ERROR: User with id=" + userId+ " does not exist";
    }
}
