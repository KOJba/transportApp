package cz.vsb.ekf.group3.dao;

import cz.vsb.ekf.group3.dto.Cargo;
import cz.vsb.ekf.group3.dto.Ship;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToFile extends InitialDemoData {
    public ExportToFile(String filename) {
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.\n    " + e);
        }

        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(stringData());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.\n    " + e);
        }

    }

    private final String stringData() {
        String data = "";
        for (Ship s : super.getShips()) {
            data += s.toString() + "\n";
            
            data += "   Cargo: \n";
            for (Cargo c : s.getIdCargo()) {
                data += "       " + c + "\n";
            }
            data += "\n";
        }
        return data;
    }

}
