package cz.vsb.ekf.group3.dao;

import cz.vsb.ekf.group3.dto.Ship;
import java.util.Objects;

public class FindShip extends InitialDemoData{
    
    public Ship findShipByID(Integer id) {
        for (Ship ship : super.getShips()) {
            if (Objects.equals(ship.getId(), id)) {
                return ship;
            }
        }
        return null;
    }
    public Ship findShipByName(String name) {
        for (Ship ship : super.getShips()) {
            if (Objects.equals(name, ship.getName())) {
                return ship;
            }
        }
        return null;
    }
}
