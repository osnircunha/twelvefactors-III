package com.wipro.cloud.musicplayer.config;

import org.jmusixmatch.MusixMatch;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by osnircunha on 12/05/18.
 */
@Configuration
public class AppConfiguration {

    @Value("${musixmatch.apikey}")
    private String musicApiKey;

    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MusixMatch getMusixMatch() {
        return new MusixMatch(this.musicApiKey);
    }

}
