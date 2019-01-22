package com.stackroute.muzix.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tracks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    @Id
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
