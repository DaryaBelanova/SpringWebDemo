package cs.hse.springWebDemo.features.songs.controllers

import cs.hse.springWebDemo.features.songs.dto.SongDto
import cs.hse.springWebDemo.features.songs.services.AlbumService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/music/songs")
class SongController(val songService: AlbumService) {

    @GetMapping
    fun getAllSongs() : ResponseEntity<List<SongDto>> {
        return ResponseEntity.ok(songService.retrieveSongs())
    }

    @GetMapping("/get")
    fun getSongWithId(@RequestParam id: String) : ResponseEntity<SongDto> {
        val song = songService.retrieveSongById(id)
            return ResponseEntity.ok(song)
    }

    @PostMapping("/add")
    fun postASong(@RequestBody song: SongDto) : ResponseEntity<String> {
        val resp = songService.tryAddSong(song)
        if (resp.contains("ERROR")) {
            ResponseEntity.badRequest().body(String)
        }

        return ResponseEntity.ok(resp)
    }
}