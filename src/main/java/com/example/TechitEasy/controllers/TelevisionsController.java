package com.example.TechitEasy.controllers;

import com.example.TechitEasy.exceptions.RecordNotFoundException;
import com.example.TechitEasy.models.Televisions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {

    Map<Integer, Televisions> televisionsMap = new HashMap<>();

    @PostMapping
    public ResponseEntity<Televisions> createTeleversions(@RequestBody Televisions televisions){
        this.televisionsMap.put(televisions.getId(), televisions);

        return new ResponseEntity<>(televisions, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Map<Integer,Televisions>> getAllTelevisions(){
        return ResponseEntity.ok(this.televisionsMap);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Televisions> getTelevisionById(@PathVariable int id){
        if (this.televisionsMap.containsKey(id)){
            return ResponseEntity.ok(televisionsMap.get(id));
        }
        else {
            //return ResponseEntity.notFound().build();
            throw new RecordNotFoundException("Television with ID "+ id +" was not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Televisions> updateTelevision(@PathVariable int id, @RequestBody Televisions televisions){
        if (this.televisionsMap.containsKey(id)){

            this.televisionsMap.put(id, televisions);
            return ResponseEntity.ok(televisions);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevisionById(@PathVariable int id){

        if (this.televisionsMap.containsKey(id)){
            this.televisionsMap.remove(id);

            return ResponseEntity.ok("Television with ID " + id + " deleted successfully.");
        }
        else{
            throw new RecordNotFoundException("Television with ID "+ id +" was not found");
        }
    }

}

