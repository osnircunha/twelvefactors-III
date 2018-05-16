package com.wipro.cloud.musicplayer.controller;

import com.wipro.cloud.musicplayer.model.PlayList;
import com.wipro.cloud.musicplayer.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by osnircunha on 12/05/18.
 */
@RestController
@RequestMapping("/playlists")
public class PlayListController {

    @Autowired
    private PlayListRepository repository;

    @RequestMapping("/{id}")
    public PlayList findById(@PathVariable("id") Optional<Long> id) throws Exception {
        return this.repository.findOne(id.orElseThrow(Exception::new));
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Optional<PlayList> playList) throws Exception{
        this.repository.save(playList.orElseThrow(Exception::new));
    }

    @RequestMapping
    public List<PlayList> list() {
        return this.repository.findAll();
    }
}
