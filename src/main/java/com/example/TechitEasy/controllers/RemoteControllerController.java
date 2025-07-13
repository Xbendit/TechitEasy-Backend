package com.example.TechitEasy.controllers;

import com.example.TechitEasy.dtos.RemoteControllerDto;
import com.example.TechitEasy.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("remotecontrollers")
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;

    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @PostMapping
    public ResponseEntity<RemoteControllerDto> addRemoteController(@RequestBody RemoteControllerDto dto){

        RemoteControllerDto dto1 = remoteControllerService.addRemoteController(dto);
        return ResponseEntity.created(null).body(dto1);

    }

    @GetMapping
    public ResponseEntity<List<RemoteControllerDto>> getAllRemotecontrollers() {

        List<RemoteControllerDto> dtos = remoteControllerService.getAllRemoteControllers();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> getRemoteController(@PathVariable("id") Long id){

        RemoteControllerDto dto = remoteControllerService.getRemoteController(id);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteRemoteController(@PathVariable("id") Long id) {
        remoteControllerService.deleteRemoteController(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> updateRemoteController(@PathVariable("id") Long id, @RequestBody RemoteControllerDto dto){
        remoteControllerService.updateRemoteController(id,dto);
        return ResponseEntity.ok(dto);
    }
}
