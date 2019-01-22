package com.stackroute.muzix.bootstrap;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SeedDataApplicationRunner implements ApplicationRunner {
    private TrackRepository trackRepository;

    @Autowired
    public SeedDataApplicationRunner(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {


            Track track1=new Track(1,"alone","alan walker");
            Track track2=new Track(2,"roar","katy perry");
            Track track3=new Track(3,"apna time aayega","gully boy");
            Track track4=new Track(4,"love story","taylor swift");
            trackRepository.save(track1);
            trackRepository.save(track2);
            trackRepository.save(track3);
            trackRepository.save(track4);
    }
}
