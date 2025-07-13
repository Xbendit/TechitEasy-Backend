package com.example.TechitEasy.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Televisions")
public class Television {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String brand;
    private double price;
    private double availableSize;
    private int refreshRate;
    private String screenType;
    private String screenQuality;
    private boolean smartTv;
    private boolean wifi;
    private boolean voiceControl;
    private boolean hdr;
    private boolean bluethooth;
    private boolean ambiLight;
    private int originalStock;
    private int sold;

    public Television(){

    }

    @OneToOne
    RemoteController remoteController;

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

    @OneToMany(
            mappedBy = "television",
            cascade = CascadeType.ALL,
            orphanRemoval =true)
    private List<CIModule> ciModules =new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "television_wallbrackets",
            joinColumns = @JoinColumn(name="television_id"),
            inverseJoinColumns = @JoinColumn(name = "wallbracket_id")
    )
    private Set<WallBracket> wallBrackets = new HashSet<>();


    public Television(String type,String brand, Double price, Double availableSize, int refreshRate, String screenType, String screenQuality, boolean smartTv, boolean wifi, boolean voiceControl, boolean hdr, boolean bluethooth, boolean ambiLight, int originalStock, int sold) {
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = voiceControl;
        this.hdr = hdr;
        this.bluethooth = bluethooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this. sold = sold;
    }

    public Television(String type, String brand) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(double availableSize) {
        this.availableSize = availableSize;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public boolean isHdr() {
        return hdr;
    }

    public void setHdr(boolean hdr) {
        this.hdr = hdr;
    }

    public boolean isBluethooth() {
        return bluethooth;
    }

    public void setBluethooth(boolean bluethooth) {
        this.bluethooth = bluethooth;
    }

    public boolean isAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }


    //
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Television{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }

}
