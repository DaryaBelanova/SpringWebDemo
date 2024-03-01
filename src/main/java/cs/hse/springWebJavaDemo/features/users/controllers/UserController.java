package cs.hse.springWebJavaDemo.features.users.controllers;

import cs.hse.springWebJavaDemo.features.songs.dto.AlbumDto;
import cs.hse.springWebJavaDemo.features.users.dto.UserDto;
import cs.hse.springWebJavaDemo.features.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    // Задание:
    // Хотелось бы, чтобы вы написали несколько enpoint-ов, соответствующих спецификации

    // 1) get /users/favorites – получение списка id любимых альбомов пользователя

    // 2) post /users/favorites/add – добавление нового альбома (его id) в фавориты юзера.
    //    В случае, если альбома с таким id нет, или юзера нет в система, нужно вернуть пользователю текст ошибки
    //    id пользователя и id альбома можно передать как в теле запроса, так и в параметрах запроса

    // 3) По завершению работы зайдите в свагер-документацию для того, чтобы протестировать API

    // * Регистрацию пользователей можно не делать, а просто захардкодить список в репозитории
    private final UserService userService;

    @GetMapping("/favorites")
    ResponseEntity<List<String>> getFavoritesById(@RequestParam String id) {
        return ResponseEntity.ok(userService.getFavoritesById(id));
    }

    @PostMapping("/favorites/add")
    ResponseEntity<String> addAlbum(@RequestParam String userId, String albumId) {
        return ResponseEntity.ok(userService.tryAddAlbumId(userId, albumId));
    }
}
