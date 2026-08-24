
package medicare.hospital;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Rhula
 */
public class MediCareHospital {

   
    public static void main(String[] args) {
        
        // Creates a Scanner object to get input from the user
       Scanner scanner = new Scanner(System.in);
       
       // Creates an ArrayList to store all registered patients
       ArrayList<patient> patientList = new ArrayList<>();
       
       // Creates an object of the BedManagement class
       // This object is used to allocate, release and display beds
       BedManagement bedManagement = new BedManagement();
       
       // Controls whether the main menu should continue running
       boolean running = true;
       
        // Keeps displaying the menu until the user chooses Exit
        while (running) {
            
        // Display the main menu
        System.out.println("Select Patient Records:");
        System.out.println("1. Register a new patient");
        System.out.println("2. Search for a patient using their patient ID");
        System.out.println("3. Update an existing patient's details");
        System.out.println("4. Delete a patient");
        System.out.println("5. Display all registered patients");
        System.out.println("6. Allocate bed to inpatient");
        System.out.println("7. Release bed");
        System.out.println("8. Display ward layout");
        System.out.println("9. Reports");
        System.out.println("10. Sort patients");
        System.out.println("11. Exit");       
        System.out.print("Enter choice (1-11): ");
        // Gets the user's menu choice
        int system = scanner.nextInt();
        scanner.nextLine();
        // Executes the option selected by the user
        switch (system) {
            
             // CASE 1 - REGISTER A NEW PATIENT
            case 1 -> { 
                
         // Ask the user for the patient's information       
        System.out.println("Enter Patient ID (e.g., P112R1): ");
        String id = scanner.nextLine();
        
        System.out.print("Enter First Name: ");
        String fName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lName = scanner.nextLine();
       
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        
        System.out.print("Enter Condition: ");
        String condition = scanner.nextLine();
         // Ask the user to select the patient's category
        System.out.println("Select Patient Category:");
        System.out.println("1. Inpatient");
        System.out.println("2. Outpatient");
        System.out.println("3. Emergency");
        System.out.print("Enter choice (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        // Stores the selected patient category
        patientCategory category = null;
        // Convert the user's number into a patientCategory value
        switch (choice) {
            case 1 -> category = patientCategory.INPATIENT;
            case 2 -> category = patientCategory.OUTPATIENT;
            case 3 -> category = patientCategory.EMERGENCY;
            
             // If the user enters an invalid category
            default -> System.out.println("Invalid choice. Defaulting to empty category.");
        }
        // Variable that will hold the new patient object
        patient pregistration;
        // Inpatients need additional ward and bed information
         if (category == patientCategory.INPATIENT) {

        System.out.print("Enter Ward Number: ");
        String ward = scanner.nextLine();
        // Create an Inpatient object
        pregistration = new Inpatient(
                id, fName, lName, age, gender, condition,
                ward, "Not Assigned");

        } else {
             // Create a normal patient object for outpatient or emergency patients
            pregistration = new patient(
                    id, fName, lName, age, gender, condition, category);
        }

       // Add the newly registered patient to the ArrayList
       patientList.add(pregistration);
       
        System.out.println("\n--- Registration Complete ---");
        System.out.println(pregistration.displayDetails());
    
        }
            // CASE 2 - SEARCH FOR A PATIENT
            case 2 -> {
                 // Ask for the patient ID to search 
                    System.out.print("Enter Patient ID to search: ");
                    String searchId = scanner.nextLine();
                    // Keeps track of whether a patient was found
                    boolean found = false;
                    
                    // Loop through every patient in the ArrayList
                    for (patient p : patientList) {
                        // Check if the current patient ID matches user input
                        if (p.displayDetails().contains("Patient ID: " + searchId)) { 
                            System.out.println("\n--- Patient Found ---");
                            System.out.println(p.displayDetails());
                            found = true;
                            break;
                        }
                    }
                     // Display a message if no patient was found
                    if (!found) System.out.println("Patient with ID " + searchId + " not found.");
                }
            // CASE 3 - UPDATE PATIENT DETAILS
            case 3 -> {
                 // Ask for the ID of the patient to update
                System.out.print("Enter Patient ID to update: ");
                String updateId = scanner.nextLine();

                boolean found = false;
                // Search through the patient list
                for (patient p : patientList) {
                     // Check if the patient ID matches
                    if (p.getPatientID().equals(updateId)) {
                        found = true;
                        // Update the patient's infomation
                        System.out.print("Enter New First Name: ");
                        p.setFirstName(scanner.nextLine());

                        System.out.print("Enter New Last Name: ");
                        p.setLastName(scanner.nextLine());

                        System.out.print("Enter New Age: ");
                        p.setAge(scanner.nextInt());
                        scanner.nextLine();

                        System.out.print("Enter New Gender: ");
                        p.setGender(scanner.nextLine());

                        System.out.print("Enter New Condition: ");
                        p.setCondition(scanner.nextLine());

                        System.out.println("Select New Patient Category:");
                        System.out.println("1. Inpatient");
                        System.out.println("2. Outpatient");
                        System.out.println("3. Emergency");
                        System.out.print("Enter choice (1-3): ");

                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        // Update the patient category
                        switch (choice) {
                            case 1 -> p.setCategory(patientCategory.INPATIENT);
                            case 2 -> p.setCategory(patientCategory.OUTPATIENT);
                            case 3 -> p.setCategory(patientCategory.EMERGENCY);
                            // Keep the old category if the choice is invalid
                            default -> System.out.println("Invalid category. Previous category kept.");
                        }

                        System.out.println("\n--- Patient Updated Successfully ---");
                        System.out.println(p.displayDetails());
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Patient with ID " + updateId + " not found.");
                }
            }
             // CASE 4 - DELETE A PATIENT
            case 4 -> {  
                    // Ask for the ID of the patient to delete
                    System.out.print("Enter Patient ID to delete: ");
                    String deleteId = scanner.nextLine();
                    boolean removed = false;
                     // Loop through the patient list using an index
                    for (int i = 0; i < patientList.size(); i++) {
                        // Check whether the current patient matches the ID
                        if (patientList.get(i).displayDetails().contains("Patient ID: " + deleteId)) {
                             // Remove the patient from the ArrayList
                            patientList.remove(i);
                            System.out.println("Patient record deleted successfully.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) System.out.println("Patient record not found.");
                }
                    // CASE 5 - DISPLAY ALL PATIENTS
                    case 5 -> {
                        // Check whether there are any patients
                        if (patientList.isEmpty()) {
                            System.out.println("No records found.");
                        } else {
                            System.out.println("\n--- All Registered Patients ---");
                            // Display every patient in the ArrayList
                            for (patient p : patientList) {
                                System.out.println(p.displayDetails());
                                System.out.println("-----------------------------");
                            }
                        }
                    }
                     // CASE 6 - ALLOCATE A BED
                   case 6 -> {
                        // Ask for the patient's ID
                        System.out.print("Enter Patient ID: ");
                        String patientID = scanner.nextLine();

                        boolean found = false;
                        // Search through the patient list
                        for (patient p : patientList) {
                             // Check whether the ID matches
                            if (p.getPatientID().equalsIgnoreCase(patientID)) {

                                found = true;
                                
                                // Ask BedManagement to allocate a bed
                                String allocatedBed = bedManagement.allocateBed(
                                        p.getPatientID(),
                                        p.getCategory()
                                );
                                //checks If a bed was successfully allocated and the patient is an inpatient
                                if (allocatedBed != null && p instanceof Inpatient) {
                                     // Convert the patient into an Inpatient object
                                    Inpatient inpatient = (Inpatient) p;
                                    // Store the allocated bed number
                                    inpatient.setBedNumber(allocatedBed);
                                }

                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Patient not found.");
                        }
                    }
                    // CASE 7 - RELEASE A BED
                  case 7 -> {
                       // Ask for the patient's ID
                    System.out.print("Enter Patient ID: ");
                    String patientID = scanner.nextLine();
                    // Try to release the patient's bed
                    boolean released = bedManagement.releaseBed(patientID);
                    // Try to release the patient's bed
                    if (released) {
                         // Search for the patient
                        for (patient p : patientList) {
                            // Check that the patient is an Inpatient and that the ID matches
                            if (p instanceof Inpatient inpatient
                                    && p.getPatientID().equalsIgnoreCase(patientID)) {
                                // Reset the patient's bed number
                                inpatient.setBedNumber("Not Assigned");

                                break;
                            }
                        }
                    }
                }
             // CASE 8 - DISPLAY WARD LAYOUT
             case 8 -> {
                  // Display the current ward layout
                bedManagement.displayWardLayout();
            }
             
            // CASE 9 - REPORTS
             case 9 -> {
                 
                 System.out.println("REPORTS");
                 System.out.println("1:Display full Report");
                 System.out.println("2:Display all registerd patients");
                 System.out.println("3:Display all available beds");
                 System.out.println("4:Display all occupied beds");
                 System.out.println("5:Display the total number of registered patients");
                 System.out.println("6:Display the total number of occupied beds");
                 System.out.println("7:Display the ward occupancy percentage");
                 System.out.print("Enter choice (1-7): ");
                 int report = scanner.nextInt();
                  scanner.nextLine();
                  // Handle the selected report
                  switch (report) {
                  
                      // FULL HOSPITAL REPORT
                      case 1 -> {
                          
                         System.out.println("\n========== HOSPITAL REPORT ==========");

                        // Registered patients
                        System.out.println("\nRegistered Patients:");

                        if (patientList.isEmpty()) {
                            System.out.println("No registered patients.");
                        } else {
                            for (patient p : patientList) {
                                System.out.println(p.displayDetails());
                                System.out.println("-----------------------------");
                            }
                        }

                        // Available beds
                        System.out.println("\nAvailable Beds:");
                        bedManagement.displayAvailableBeds();

                        // Occupied beds
                        System.out.println("\nOccupied Beds:");
                        bedManagement.displayOccupiedBeds();

                       // Display totals
                        System.out.println("\nTotal Registered Patients: " + patientList.size());
                        System.out.println("Total Occupied Beds: " + bedManagement.getOccupiedBedsCount());
                        // Calculate and display ward occupancy percentage
                        System.out.println("Ward Occupancy: " +
                                String.format("%.1f", bedManagement.getOccupancyPercentage()) + "%");

                        System.out.println("======================================");

                      }
                      // DISPLAY ALL REGISTERED PATIENTS
                      case 2 -> {
                          //Diplays all Registered patients
                        System.out.println("\nRegistered Patients:");

                        if (patientList.isEmpty()) {
                            System.out.println("No registered patients.");
                        } else {
                            for (patient p : patientList) {
                                System.out.println(p.displayDetails());
                                System.out.println("-----------------------------");
                            }
                        }
                      }
                      // DISPLAY AVAILABLE BEDS
                      case 3 -> {
                          //Displays all Available beds
                        System.out.println("\nAvailable Beds:");
                        bedManagement.displayAvailableBeds();
                      }
                       // DISPLAY OCCUPIED BEDS
                      case 4 -> {
                         //Displays all Occupied beds
                        System.out.println("\nOccupied Beds:");
                        bedManagement.displayOccupiedBeds(); 
                      }
                      // TOTAL REGISTERED PATIENTS
                      case 5 -> {
                          //Display the total number of registered patients
                          System.out.println("\nTotal Registered Patients: " + patientList.size());
                      }
                      // TOTAL OCCUPIED BEDS
                      case 6 -> {
                          //Display the total number of occupied beds
                           System.out.println("Total Occupied Beds: " + bedManagement.getOccupiedBedsCount());
                      }
                       // WARD OCCUPANCY
                      case 7 -> {
                           System.out.println("Ward Occupancy: " + String.format("%.1f", bedManagement.getOccupancyPercentage()) + "%");
                      }
                  }
            }
             // CASE 10 - SORT PATIENTS
             case 10 -> {
                System.out.println("\n--- Sort Patients ---");
                System.out.println("1. Sort by Surname");
                System.out.println("2. Sort by Patient ID");
                System.out.print("Enter choice: ");

                int sortChoice = scanner.nextInt();
                scanner.nextLine();

              switch (sortChoice) {
                   // SORT BY SURNAME
                    case 1:
                        // Bubble sort algorithm
                        for (int i = 0; i < patientList.size() - 1; i++) {

                            for (int j = 0; j < patientList.size() - 1 - i; j++) {
                                 // Compare two surnames
                                if (patientList.get(j).getLastName()
                                        .compareToIgnoreCase(patientList.get(j + 1).getLastName()) > 0) {
                                    // Temporarily store the current patient
                                    patient temp = patientList.get(j);
                                     // Swap the two patients
                                    patientList.set(j, patientList.get(j + 1));
                                    patientList.set(j + 1, temp);
                                }
                            }
                        }
                        System.out.println("Patients sorted by surname.");
                        break;
                        // SORT BY PATIENT ID
                    case 2:
                         // Bubble sort algorithm
                        for (int i = 0; i < patientList.size() - 1; i++) {

                            for (int j = 0; j < patientList.size() - 1 - i; j++) {
                                 // Compare two patient IDs
                                if (patientList.get(j).getPatientID()
                                        .compareToIgnoreCase(patientList.get(j + 1).getPatientID()) > 0) {
                                    // Temporarily store the current patient
                                    patient temp = patientList.get(j);
                                     // Swap the two patients
                                    patientList.set(j, patientList.get(j + 1));
                                    patientList.set(j + 1, temp);
                                }
                            }
                        }
                                System.out.println("Patients sorted by Patient ID.");
                                break;
                                // Invalid sorting option
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                }
                }
             // CASE 11 - EXIT PROGRAM
             case 11 -> {
                System.out.println("Exiting MediCare Hospital Management System.");
                scanner.close();
                 // Stop the while loop
                running = false;
            }
             
            default -> System.out.println("Invalid menu choice. Please select 1 through 11."); 
            
      }
    }
    }
    
}
