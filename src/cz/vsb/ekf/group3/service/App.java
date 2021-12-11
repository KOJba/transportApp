package cz.vsb.ekf.group3.service;

import cz.vsb.ekf.group3.dao.InitialDemoData;
import cz.vsb.ekf.group3.dto.Ship;
import java.util.List;

public class App {

    InitialDemoData data = new InitialDemoData();
    List<Ship> shipList = data.getShips();

    public App() {

    }

    public void run() {
        FindShips finder = new FindShips();
        finder.runFindShips();
        
        Simulation sim = new Simulation();
        sim.runSim();
        
        ExportFile export = new ExportFile();
        export.runExportFile();
    }
}
