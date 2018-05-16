package com.wipro.cloud.musicplayer.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by osnircunha on 12/05/18.
 */
@Data
@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String artist;

    private String album;

    private String lyricUrl;
}
