package com.wipro.cloud.musicplayer.repository;

import com.wipro.cloud.musicplayer.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by osnircunha on 12/05/18.
 */
public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findByAlbumEquals(String album);

}
