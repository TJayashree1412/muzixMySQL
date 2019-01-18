package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v3")
public class TrackController {
    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> savetrack(@RequestBody Track track){
        ResponseEntity<?> responseEntity;
        try{
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<Track>(track, HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String >(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("track")
    public  ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<>(trackService.getAllTracks(),HttpStatus.OK);
    }

// localhost:8082/api/v3/trackbyId?trackId=1
    @GetMapping("trackbyId")
    public ResponseEntity<?> getTrackbyid(@RequestParam int trackId){
        ResponseEntity<?> responseEntity;
        try{
            Track track=trackService.getTrack(trackId);
            responseEntity=new ResponseEntity<Track>(track,HttpStatus.OK);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String >(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("trackbyName")
    public ResponseEntity<?> getTrackbyName(@RequestParam String trackName){
        ResponseEntity<?> responseEntity;
        try{
            Track track=trackService.getTrackbyName(trackName);
            responseEntity=new ResponseEntity<Track>(track,HttpStatus.OK);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String >(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("trackbyComment")
    public ResponseEntity<?> getTrackbyComment(@RequestParam String comment){
        ResponseEntity<?> responseEntity;
        try{
            Track track=trackService.getTrackbyComment(comment);
            responseEntity=new ResponseEntity<Track>(track,HttpStatus.OK);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String >(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){
        ResponseEntity<?> responseEntity;
        try{
            trackService.updateTrack(track);
            responseEntity=new ResponseEntity<Track>(track,HttpStatus.OK);
        }
//        catch (Exception e){
//            responseEntity=new ResponseEntity<String >(e.getMessage(),HttpStatus.CONFLICT);
//        }
        catch (Exception ex)
        {
            responseEntity= new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("track/{trackId}")
    public ResponseEntity<?> deletetrack(@PathVariable("trackId") int trackId){
        ResponseEntity<?> responseEntity;
        try{
            String mesage=trackService.removeTrack(trackId);
            responseEntity=new ResponseEntity<String>(mesage,HttpStatus.OK);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String >(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
