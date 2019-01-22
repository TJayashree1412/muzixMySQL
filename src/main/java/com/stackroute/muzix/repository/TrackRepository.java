package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
public interface TrackRepository extends MongoRepository<Track,Integer>
{


//    @Query//("SELECT t FROM Track t WHERE t.trackName = ?1")
//    public Track findByName(String trackName);
//
//    @Query//("SELECT t FROM Track t WHERE t.comment = ?1") //?(value)->gives no of parameters
//    public Track findByComment(String comment);


//    public Track findByName(String name);
}
