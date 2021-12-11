package cz.vsb.ekf.group3.dto;

public class Route {
    private Integer id;
    private Port startPort;
    private Port targetPort;
    private float distance;
    private double travelTime;
    private Integer shipId;
    
    public Route() {
    
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Port getStartPort() {
        return startPort;
    }

    public void setStartPort(Port startPort) {
        this.startPort = startPort;
    }

    public Port getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(Port targetPort) {
        this.targetPort = targetPort;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }
    
    
}
