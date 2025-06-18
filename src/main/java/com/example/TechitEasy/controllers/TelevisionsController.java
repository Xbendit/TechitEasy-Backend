package com.example.TechitEasy.controllers;

import com.example.TechitEasy.dtos.TelevisionDto;
import com.example.TechitEasy.dtos.TelevisionInputDto;
import com.example.TechitEasy.exceptions.RecordNotFoundException;
import com.example.TechitEasy.mappers.TelevisionMapper;
import com.example.TechitEasy.models.Television;
import com.example.TechitEasy.repository.TelevisionRepository;
import com.example.TechitEasy.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {

    private final TelevisionService service;
    private final TelevisionService televisionService;

    /*private final TelevisionRepository repos;*/

    /*public TelevisionsController(TelevisionRepository repos){
    this.repos = repos;
}*/
    public TelevisionsController(TelevisionService service, TelevisionService televisionService){
        this.service = service;
        this.televisionService = televisionService;
    }

    @PostMapping
    public ResponseEntity<TelevisionInputDto> createTeleversions(@Valid @RequestBody TelevisionDto televisionDto){


        Television television = this.service.createTelevision(televisionDto);

        TelevisionInputDto televisionInputDto = TelevisionMapper.televisionInputDto(television);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + televisionInputDto.id).toUriString());

        return ResponseEntity.created(uri).body(televisionInputDto);
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions(){
        List<Television> televisions = televisionService.getTelevision();
        return ResponseEntity.ok(televisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionInputDto> getTelevisionById(@PathVariable int id) {
      return ResponseEntity.ok(TelevisionMapper.televisionInputDto(this.service.getTelevision(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionInputDto> updateTelevision(@PathVariable int id, @RequestBody TelevisionInputDto televisionsInputDto){
        TelevisionInputDto updateTelevision = this.service.updateTelevision(id, televisionsInputDto);
        return ResponseEntity.ok(updateTelevision);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevisionById(@PathVariable int id){
        String result = service.deleteTelevision(id);
        return ResponseEntity.ok(result);

    }

}

