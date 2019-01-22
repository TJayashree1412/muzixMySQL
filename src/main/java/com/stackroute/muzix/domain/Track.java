package com.stackroute.muzix.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;

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
    @ApiModelProperty(notes = "name of the Track")
    private String trackName;
    @ApiModelProperty(notes = "comment about the track")
    private String comment;

    public Track(String trackName, String comment) {
        this.trackName = trackName;
        this.comment = comment;
   }
}
