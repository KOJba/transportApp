package cz.vsb.ekf.group3.dto;

import java.util.List;


public class Ship {
    private Integer id;
    private String name;
    private Integer capacity;
    private boolean isOnWay;
    private Integer countOfTransports;
    private float avgSpeed;
    private List<Cargo> idCargo;

    public Ship() {
    
    }
    
    public Ship(Integer id, String name, Integer capacity, boolean isOnWay, Integer countOfTransports, float avgSpeed, List<Cargo> idCargo) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.isOnWay = isOnWay;
        this.countOfTransports = countOfTransports;
        this.avgSpeed = avgSpeed;
        this.idCargo = idCargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public boolean isIsOnWay() {
        return isOnWay;
    }

    public void setIsOnWay(boolean isOnWay) {
        this.isOnWay = isOnWay;
    }

    public Integer getCountOfTransports() {
        return countOfTransports;
    }

    public void setCountOfTransports(Integer countOfTransports) {
        this.countOfTransports = countOfTransports;
    }

    public float getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(float avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public List<Cargo> getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(List<Cargo> idCargo) {
        this.idCargo = idCargo;
    }

    @Override
    public String toString() {
        return "Ship{" + 
                "id=" + id + 
                ", name=" + name + 
                ", capacity=" + capacity + 
                ", isOnWay=" + isOnWay + 
                ", countOfTransports=" + countOfTransports + 
                ", avgSpeed=" + avgSpeed + 
                ", idCargo=" + idCargo + '}';
    }
    
    
    
}
