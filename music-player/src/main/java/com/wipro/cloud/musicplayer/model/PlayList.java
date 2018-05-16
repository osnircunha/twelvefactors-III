package com.wipro.cloud.musicplayer.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by osnircunha on 12/05/18.
 */
@Data
@Entity
public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Track.class)
    private List<Track> tracks;
}
