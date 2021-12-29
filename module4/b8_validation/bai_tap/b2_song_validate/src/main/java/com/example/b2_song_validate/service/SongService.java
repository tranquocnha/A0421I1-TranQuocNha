package com.example.b2_song_validate.service;

import com.example.b2_song_validate.model.Song;

public interface SongService {
    Iterable<Song> findAll();

    Song findById(Integer id);

    void save(Song song);
}
