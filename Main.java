
//Sheri Evangelene
// June JUl 23- Aug 3 2026
//Java QAP 4

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DrugFileManager file1 = new DrugFileManager();
        
        // Sample object for testing
        Drug drug1 = new Drug("45A", "LSD", 4.96, 1.4);

        boolean running = true;

        while (running) {
            System.out.println("\n==================================");
            System.out.println("       PERSISTENCE SYSTEM MENU    ");
            System.out.println("==================================");
            System.out.println("1. Save Drug to File");
            System.out.println("2. Read Drug from File");
            System.out.println("3. Save Patient to Database");
            System.out.println("4. Read Patients from Database");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            // Added .trim() here so extra whitespace or stray line breaks won't break option matching
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        file1.saveDrugToFile(drug1);
                        break;

                    case "2":
                        file1.readDrug();
                        break;

                    case "3":
                        System.out.println("Enter the Patients First Name:");
                        String fname = scanner.nextLine();
                        System.out.println("Enter the Patients Last Name:");
                        String lname = scanner.nextLine();
                        System.out.println("Enter the Patients DOB (yyyy-MM-dd):");
                        String DOB = scanner.nextLine();
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date dob = sdf.parse(DOB);
                            Patient patient = new Patient(0, fname, lname, dob);
                            PatientDBManager.savePatient(patient);
                        } catch (Exception ex) {
                            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                        }
                        break;

                    case "4":
                        PatientDBManager.readPatients();
                        break;

                    case "5":
                        System.out.println("Exiting application. Have a great day!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid entry. Please enter a number from 1 to 5.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Global Check caught error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}