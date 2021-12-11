package cz.vsb.ekf.group3.dto;

import java.math.BigDecimal;

public class Cargo {
    private Integer id;
    private String decription;
    private Integer weight;
    private BigDecimal totalPrice;
    
    public Cargo() {
    
    }

    public Cargo(Integer id, String decription, Integer weight, BigDecimal totalPrice) {
        this.id = id;
        this.decription = decription;
        this.weight = weight;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cargo{" + 
                "id=" + id + 
                ", decription=" + decription + 
                ", weight=" + weight + 
                ", totalPrice=" + totalPrice + '}';
    }
    
    
    
    
}
