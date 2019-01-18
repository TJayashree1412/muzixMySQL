package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackListEmptyException;
import com.stackroute.muzix.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v3")
@Api(value = "Music Resource class level",description = "shows the track information")
public class TrackController {
    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @ApiOperation(value = "Accepts tracks into repository")
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

    @ApiOperation(value = "Returns all tracks present in repository")
    @ApiResponses(
            value ={
                  @ApiResponse(code = 100,message = "100 is the message"),
                    @ApiResponse(code = 200,message = "Successfull")
    }
    )
    @GetMapping("track")
    public  ResponseEntity<?> getAllTracks() throws TrackListEmptyException{

        if(trackService.getAllTracks().isEmpty()){
            throw new TrackListEmptyException("Track repository is empty");
        }return new ResponseEntity<>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @ApiOperation(value = "Returns the track requested by user")
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
