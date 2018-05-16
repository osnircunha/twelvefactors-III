package com.wipro.cloud.musicplayer.repository;

import com.wipro.cloud.musicplayer.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by osnircunha on 12/05/18.
 */
public interface PlayListRepository extends JpaRepository<PlayList, Long> {

    List<PlayList> findByNameEquals(String name);

}
