package cz.vsb.ekf.group3.service;

import cz.vsb.ekf.group3.dao.FindShip;
import cz.vsb.ekf.group3.dto.Cargo;
import cz.vsb.ekf.group3.dto.Ship;
import java.util.Scanner;

public class FindShips extends App {

    public void runFindShips() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to search for a ship?");

        // create catch and exeptions
        boolean answer = false;
        try {
            answer = sc.nextBoolean();
        } catch (java.util.InputMismatchException e) {
            sc.nextLine();
            System.out.println("Incorrect input value. (" + e +")");
        } catch (java.util.NoSuchElementException e) {
            System.out.println(e);
        } catch (IllegalStateException e) {
            System.out.println("Scanner is closed. (" + e + ")");
        }

        if (!answer) {
            return;
        }

        sc.nextLine();

        System.out.println("Enter ID or a name of the ship:");
        //Object identification = sc.nextLine();

        FindShip findShip = new FindShip();
        Ship ship;

        if (sc.hasNextInt()) {
            Integer id = sc.nextInt();
            ship = findShip.findShipByID(id);
            if (ship == null) {
                System.out.println("Cannot find ship with ID:" + id);
                return;
            }
        } else if (sc.hasNext()) {
            String name = sc.nextLine();
            ship = findShip.findShipByName((String) name);
            if (ship == null) {
                System.out.println("Cannot find ship with name: " + name);
                return;
            }
        } else {
            Object input = sc.next();
            System.out.println("The input: " + input + " is invalid.");
            return;
        }
        System.out.println("Found ship: " + ship.getName() + ", ID: " + ship.getId() + "\n"
                + "        Capacity: " + ship.getCapacity() + "\n"
                + "        Ship on the way: " + ship.isIsOnWay() + "\n"
                + "        Count of transports: " + ship.getCountOfTransports() + "\n"
                + "        Average speed: " + ship.getAvgSpeed() + " km/h\n"
                + "    List of cargos: ");
        for (Cargo c : ship.getIdCargo()) {
            System.out.println("        " + c);
        }
    }
}
