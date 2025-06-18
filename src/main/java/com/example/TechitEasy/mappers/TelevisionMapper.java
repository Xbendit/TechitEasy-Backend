package com.example.TechitEasy.mappers;

import com.example.TechitEasy.dtos.TelevisionDto;
import com.example.TechitEasy.dtos.TelevisionInputDto;
import com.example.TechitEasy.models.Television;

public class TelevisionMapper {

    public static Television toEntity (TelevisionDto televisionInputDto){
        Television television = new Television(televisionInputDto.type, televisionInputDto.brand,televisionInputDto.price, televisionInputDto.availableSize,televisionInputDto.refreshRate, televisionInputDto.screenType,televisionInputDto.screenQuality, televisionInputDto.smartTv,televisionInputDto.wifi, televisionInputDto.voiceControl,televisionInputDto.hdr, televisionInputDto.bluethooth,televisionInputDto.ambiLight, televisionInputDto.originalStock,televisionInputDto.sold);
        return television;
    }

    public static TelevisionInputDto televisionInputDto (Television television){
        TelevisionInputDto televisionInputDto = new TelevisionInputDto();
        televisionInputDto.id = television.getId();
        televisionInputDto.type = television.getType();
        televisionInputDto.brand = television.getBrand();
        televisionInputDto.price = television.getPrice();
        televisionInputDto.availableSize = television.getAvailableSize();
        televisionInputDto.refreshRate = television.getRefreshRate();
        televisionInputDto.screenType = television.getScreenType();
        televisionInputDto.screenQuality = television.getScreenQuality();
        televisionInputDto.smartTv = television.isSmartTv();
        televisionInputDto.wifi = television.isWifi();
        televisionInputDto.voiceControl = television.isVoiceControl();
        televisionInputDto.hdr = television.isHdr();
        televisionInputDto.bluethooth = television.isBluethooth();
        televisionInputDto.ambiLight = television.isAmbiLight();
        televisionInputDto.originalStock = television.getOriginalStock();
        televisionInputDto.sold = television.getSold();
        return televisionInputDto;
    }
}
