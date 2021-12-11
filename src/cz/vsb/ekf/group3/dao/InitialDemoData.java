package cz.vsb.ekf.group3.dao;

import cz.vsb.ekf.group3.dto.Cargo;
import cz.vsb.ekf.group3.dto.Ship;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InitialDemoData {
    List<Ship> ships = new ArrayList<>();

    public InitialDemoData() {

        List<Cargo> cargos = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            Cargo cargo = new Cargo();
            cargo.setId(i);
            cargo.setDecription(cargoDecription[(int) (Math.random()*7)]);
            cargo.setWeight(((int) (Math.random() * 1001))/100 * 100);
            cargo.setTotalPrice(new BigDecimal(0));
            cargos.add(cargo);
        }
        
        
        for (int i = 0; i < 20; i++) {
            Ship ship = new Ship();
            ship.setId(i);
            ship.setName(names[i]);
            ship.setIsOnWay(i % 10 != 0);
            ship.setCapacity(0);
            ship.setCountOfTransports(0);
            ship.setAvgSpeed((float) (Math.random() * 101 + 30));
            List<Cargo> shipCargos = new ArrayList<>();
            
            shipCargos.add(cargos.get(i));
            shipCargos.add(cargos.get(i+20));
            
            ship.setIdCargo(shipCargos);
            ships.add(ship);
        }

    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
    
    private static final String[] cargoDecription = {
        "Feeder",
        "General cargo",
        "Container",
        "Bulk and Break Bulk",
        "Multi-purpose",
        "Reefer",
        "Roll-on/roll-off"  
    };
    
    private static final String[] names = {
        "Altmark",
        "Aranui 3",
        "Astron",
        "Akebono Maru",
        "Evergreen", 
        "Ever Golden",
        "Madrid Maersk",
        "Mayflower",
        "MOL Truth",
        "MOL Triumph",
        "MV Alexia",
        "MV Barzan",
        "MV Sea Star",
        "OOCL Hong Kong",
        "Salem",
        "SS Atlantic", 
        "SS Vedic",
        "Truelove",
        "Unsinkable II", 
        "Victory", 
    };

}
