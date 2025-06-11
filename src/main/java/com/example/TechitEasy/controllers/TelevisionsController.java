package com.example.TechitEasy.controllers;

import com.example.TechitEasy.exceptions.RecordNotFoundException;
import com.example.TechitEasy.models.Television;
import com.example.TechitEasy.repository.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {

    private final TelevisionRepository repos;

    public TelevisionsController(TelevisionRepository repos){
    this.repos = repos;
}

    @PostMapping
    public ResponseEntity<Television> createTeleversions(@RequestBody Television televisions){
        this.repos.save(televisions);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + televisions.getId()).toUriString());

        return ResponseEntity.created(uri).body(televisions);
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions(){
        return ResponseEntity.ok(this.repos.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable int id){
        Optional<Television> op = this.repos.findById(id);

        if (op.isPresent()){
            return ResponseEntity.ok(op.get());
        }
        else {
            //return ResponseEntity.notFound().build();
            throw new RecordNotFoundException("Television with ID "+ id +" was not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable int id, @RequestBody Television televisions){
        Optional<Television> op = this.repos.findById(id);

        if (op.isPresent()){
            televisions.setId(id);
            this.repos.save(televisions);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevisionById(@PathVariable int id){
        Optional<Television> op = this.repos.findById(id);

        if (op.isPresent()){
            this.repos.deleteById(id);

            return ResponseEntity.ok("Television with ID " + id + " deleted successfully.");
        }
        else{
            throw new RecordNotFoundException("Television with ID "+ id +" was not found");
        }
    }

}

