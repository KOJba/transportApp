package cz.vsb.ekf.group3.service;

import cz.vsb.ekf.group3.dao.FindShip;
import cz.vsb.ekf.group3.dto.Cargo;
import cz.vsb.ekf.group3.dto.Port;
import cz.vsb.ekf.group3.dto.Route;
import cz.vsb.ekf.group3.dto.Ship;
import java.util.Scanner;
import java.util.UUID;

public class Simulation {

    private Port start;
    private Port destination;
    private float distance;
    private Ship ship;

    public Simulation() {

    }

    public void runSim() {
        System.out.println("----- Transport Simulation -----");
        if (getInput() == 0) {
            System.out.println("Calculate transport time?");
            Scanner sc = new Scanner(System.in);
            boolean answer;
            try {
                answer = sc.nextBoolean();
            } catch (java.util.InputMismatchException e) {
                sc.nextLine();
                System.out.println("Incorrect input value. (" + e + ")");
                return;
            } catch (java.util.NoSuchElementException e) {
                System.out.println(e);
                return;
            } catch (IllegalStateException e) {
                System.out.println("Scanner is closed. (" + e + ")");
                return;
            }
            if (answer) {
                Long startTime = System.currentTimeMillis();
                calculateRoute();
                Long endTime = System.currentTimeMillis();
                System.out.println("----- Time: " + (endTime - startTime) + " ms -----");
            }

        }
    }

    private int getInput() {
        for (int i = 1; i < Port.values().length + 1; i++) {
            System.out.println(i + ". " + Port.values()[i - 1]);
        }

        System.out.print("Start port (values 1-10): ");
        int answerStart = getIntInput();
        

        System.out.print("Destination port (values 1-10): ");
        int answerDest = getIntInput();
        try {
            start = Port.values()[answerStart - 1];
            destination = Port.values()[answerDest - 1];
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("Input out of range. " + e);
            return -1;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Distance: ");
        try {
            distance = sc.nextFloat();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input must be a number (float). " + e);
            return -1;
        }
        
        if (distance < 0) {
            System.out.println("Distance cannot be smaller than 0.");
            return -1;
        }
        
        System.out.print("ID ship: ");
        int answer = getIntInput();
        if (answer == -1) {
            System.out.println("Invalid ship id.");
            return -1;
        }
        FindShip find = new FindShip();
        ship = find.findShipByID(answer);
        if (ship == null) {
            System.out.println("Ship with id: " + answer + " does not exist.");
            return -1;
        }

        System.out.println("----- Input -----"
                + "\n   Start: " + start
                + "\n   Destination: " + destination
                + "\n   Distance: " + distance + " km"
                + "\n   Ship: " + ship.getName() + ", ID: " + ship.getId()
                + "\n----- ----- -----");
        return 0;

    }
    
    private Integer getIntInput() {
        int input = 0;
        Scanner sc = new Scanner(System.in);
        try {
            input = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input must be an integer. " + e);
            return -1;
        }
        return input;
    }

    private void calculateRoute() {
        Route route = new Route();
        double travelTime;

        UUID uuid = UUID.randomUUID();
        route.setId(uuid.variant());
        route.setStartPort(start);
        route.setTargetPort(destination);
        route.setDistance(distance);
        route.setShipId(ship.getId());
       

        Integer totalWeight = 0;
        for (Cargo c : ship.getIdCargo()) {
            totalWeight += c.getWeight();
        }
        try {
            travelTime = (distance
                / (ship.getAvgSpeed() - (totalWeight / 100 * 0.2)));
        } catch (ArithmeticException e) {
            System.out.println("An error has occured. Division by zero. " + e);
            return;
        }
        if (travelTime < 0) {
            System.out.println("An error has occured. "
                    + "Travel time is less than 0 (" + travelTime + ").");
            return;
        }

        route.setTravelTime(travelTime);
        int hours = (int) travelTime;
        int minutes = (int) ((travelTime - hours) * 60);

        System.out.println("    Estimated time: " + hours + " h " + minutes + " min");

    }

}
