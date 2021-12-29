package com.example.b2_song_validate.repository;

import com.example.b2_song_validate.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SongRepository extends JpaRepository<Song,Integer> {
}
