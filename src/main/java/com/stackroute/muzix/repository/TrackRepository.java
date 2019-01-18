package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer>
{


    @Query("SELECT t FROM Track t WHERE t.trackName = ?1")
    public Track findbyTrackName(String trackName);

    @Query("SELECT t FROM Track t WHERE t.comment = ?1") //?(value)->gives no of parameters
    public Track findbyComment(String comment);

//
//    public Track findByName(String name);
}
