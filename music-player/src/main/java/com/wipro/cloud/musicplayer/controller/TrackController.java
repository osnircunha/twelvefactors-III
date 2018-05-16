package com.wipro.cloud.musicplayer.controller;

import com.wipro.cloud.musicplayer.model.Track;
import com.wipro.cloud.musicplayer.repository.TrackRepository;
import org.jmusixmatch.MusixMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * Created by osnircunha on 12/05/18.
 */
@RestController
@RequestMapping("/tracks")
public class TrackController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TrackRepository repository;

    @Autowired
    private MusixMatch musixMatch;

    @RequestMapping("/{id}")
    public Track getTrackById(@PathVariable("id") Optional<Long> id) throws Exception {
        return this.repository.getOne(id.orElseThrow(Exception::new));
    }

    @RequestMapping
    public List<Track> find(@RequestParam(required = false, name = "album") Optional<String> album) throws Exception {
        return album.map(s -> this.repository.findByAlbumEquals(s)).orElseGet(() -> this.repository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveTrack(@RequestBody Optional<Track> optionalTrack) throws Exception {
        Track track = optionalTrack.orElseThrow(Exception::new);

        org.jmusixmatch.entity.track.Track mtrack = this.musixMatch.getMatchingTrack(track.getName(), track.getArtist());

        track.setLyricUrl(mtrack.getTrack().getTrackShareUrl());
        this.repository.save(track);
    }

}
