package cz.vsb.ekf.group3.service;

import cz.vsb.ekf.group3.dao.ExportToFile;
import java.util.Scanner;

public class ExportFile {

    public ExportFile() {

    }

    public void runExportFile() {
        System.out.println("Export file with ships and their cargos?");

        Scanner sc = new Scanner(System.in);
        boolean answer = false;
        try {
            answer = sc.nextBoolean();
        } catch (java.util.InputMismatchException e) {
            sc.nextLine();
            System.out.println("Incorrect input value. (" + e + ")");
        } catch (java.util.NoSuchElementException e) {
            System.out.println(e);
        } catch (IllegalStateException e) {
            System.out.println("Scanner is closed. (" + e + ")");
        }

        
        String path = "";
        if (answer) {
            System.out.println("Enter new file path:");
            try {
                path = sc.next();
            } catch (java.util.NoSuchElementException e) {
                System.out.println("Invalid (empty) input. " + e);
            }
            ExportToFile export = new ExportToFile(path);
        }
    }

}
