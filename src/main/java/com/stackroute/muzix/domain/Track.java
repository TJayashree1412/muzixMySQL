package com.stackroute.muzix.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackId;
    private String trackName;
    private String comment;

    public Track(String trackName, String comment) {
        this.trackName = trackName;
        this.comment = comment;
   }
}
