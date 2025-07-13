package com.example.TechitEasy.services;

import com.example.TechitEasy.dtos.RemoteControllerDto;
import com.example.TechitEasy.exceptions.RecordNotFoundException;
import com.example.TechitEasy.models.RemoteController;
import com.example.TechitEasy.repository.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService (RemoteControllerRepository remoteControllerRepository){
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public RemoteControllerDto addRemoteController (RemoteControllerDto remoteControllerDto){
        RemoteController rc = tranferToRemoteController(remoteControllerDto);
        remoteControllerRepository.save(rc);
        return remoteControllerDto;
    }

    public RemoteController tranferToRemoteController(RemoteControllerDto dto){
        var remoteController = new RemoteController();

        remoteController.setId(dto.getId());
        remoteController.setCompatibleWith(dto.getCompatibleWith());

        return remoteController;
    }

    public List<RemoteControllerDto> getAllRemoteControllers(){
        List<RemoteControllerDto> dtos = new ArrayList<>();
        List<RemoteController> remoteControllers = remoteControllerRepository.findAll();
        for (RemoteController rc : remoteControllers){
            dtos.add(transferToDto(rc));
        }
        return dtos;
    }
    public RemoteControllerDto transferToDto(RemoteController remoteController){
        var dto = new RemoteControllerDto();

        dto.id = remoteController.getId();
        dto.compatibleWith = remoteController.getCompatibleWith();
        dto.batteryType = remoteController.getBatteryType();
        dto.name = remoteController.getName();
        dto.brand = remoteController.getBrand();
        dto.price = remoteController.getPrice();
        dto.originalStock = remoteController.getOriginalStock();

        return dto;
    }

    public RemoteControllerDto getRemoteController(long id){
        Optional<RemoteController> remoteController = remoteControllerRepository.findById(id);
        if(remoteController.isPresent()){
            return transferToDto(remoteController.get());
        }else {
            throw new RecordNotFoundException("No Remotecontroller found");
        }
    }

    public void deleteRemoteController(Long id) {
        remoteControllerRepository.deleteById(id);
    }

    public void updateRemoteController(Long id, RemoteControllerDto remoteControllerDto) {
        if(!remoteControllerRepository.existsById(id)) {
            throw new RecordNotFoundException("No remotecontroller found");
        }
        RemoteController storedRemoteController = remoteControllerRepository.findById(id).orElse(null);
        storedRemoteController.setId(remoteControllerDto.getId());
        storedRemoteController.setCompatibleWith(remoteControllerDto.getCompatibleWith());
        storedRemoteController.setBatteryType(remoteControllerDto.getBatteryType());
        storedRemoteController.setName(remoteControllerDto.getName());
        storedRemoteController.setPrice(remoteControllerDto.getPrice());
        storedRemoteController.setBrand(remoteControllerDto.getBrand());
        storedRemoteController.setOriginalStock(remoteControllerDto.getOriginalStock());
        remoteControllerRepository.save(storedRemoteController);
    }
}
