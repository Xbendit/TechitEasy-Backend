package com.example.TechitEasy.services;

import com.example.TechitEasy.dtos.TelevisionDto;
import com.example.TechitEasy.dtos.TelevisionInputDto;
import com.example.TechitEasy.exceptions.RecordNotFoundException;
import com.example.TechitEasy.mappers.TelevisionMapper;
import com.example.TechitEasy.models.Television;
import com.example.TechitEasy.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos){
        this.repos = repos;
    }

    public Television createTelevision(TelevisionDto televisionInputDto){
        return this.repos.save(TelevisionMapper.toEntity(televisionInputDto));
    }

    public Television getTelevision(int id){
        return this.repos.findById(id).orElseThrow(()-> new RecordNotFoundException("Television " + id +  " not found!"));
    }

    public String deleteTelevision(int id){
        if(!repos.existsById(id)) {
            throw new RecordNotFoundException("Television " + id +  " not found!");
        }
        repos.deleteById(id);
        return "Television " + id + " successfully deleted";
    }

    public List<Television> getTelevision(){
        List<Television> televisions = repos.findAll();
        if (televisions.isEmpty()){
            throw new RecordNotFoundException("No televisions in the database...");
        }
        return televisions;
    }

    public TelevisionInputDto updateTelevision(int id, TelevisionInputDto televisionInputDto){
        Television television = repos.findById(id)
                .orElseThrow(()->new RecordNotFoundException("Television" + id + "not found!"));

        television.setType(televisionInputDto.type);
        television.setBrand(televisionInputDto.brand);
        television.setPrice(televisionInputDto.price);
        television.setAvailableSize(televisionInputDto.availableSize);
        television.setRefreshRate(televisionInputDto.refreshRate);
        television.setScreenType(televisionInputDto.screenType);
        television.setScreenQuality(televisionInputDto.screenQuality);
        television.setSmartTv(televisionInputDto.smartTv);
        television.setWifi(televisionInputDto.wifi);
        television.setVoiceControl(televisionInputDto.voiceControl);
        television.setHdr(televisionInputDto.hdr);
        television.setBluethooth(televisionInputDto.bluethooth);
        television.setAmbiLight(televisionInputDto.ambiLight);
        television.setOriginalStock(televisionInputDto.originalStock);
        television.setSold(televisionInputDto.sold);

        Television savedTelevision = repos.save(television);

        return TelevisionMapper.televisionInputDto(savedTelevision);

    }

}
