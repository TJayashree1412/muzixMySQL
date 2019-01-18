//package com.stackroute.muzix.bootstrap;
//
//import com.stackroute.muzix.domain.Track;
//import com.stackroute.muzix.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//@Configuration
//public class SeedData implements CommandLineRunner{
//
//    private TrackRepository trackRepository;
//
//    @Autowired
//    public SeedData(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//    @Override
//    public void run(String... args) throws Exception {
////
////        Track track1 = Track.builder()
////                .trackName("Gali Gali Mein Phita Hun")
////                .comment("Trending song")
////                .build();
//        Track track1=new Track("alone","alan walker");
//        Track track2=new Track("roar","katy perry");
//        Track track3=new Track("apna time aayega","gully boy");
//        Track track4=new Track("love story","taylor swift");
//        trackRepository.save(track1);
//        trackRepository.save(track2);
//        trackRepository.save(track3);
//        trackRepository.save(track4);
//    }
//    //ApplicationListener<ContextRefreshedEvent> {
//
////    @Override
////    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
////        Track track1=new Track("alone","alan walker");
////        Track track2=new Track("roar","katy perry");
////        Track track3=new Track("apna time aayega","gully boy");
////        Track track4=new Track("love story","taylor swift");
////        trackRepository.save(track1);
////        trackRepository.save(track2);
////        trackRepository.save(track3);
////        trackRepository.save(track4);
////    }
//}
