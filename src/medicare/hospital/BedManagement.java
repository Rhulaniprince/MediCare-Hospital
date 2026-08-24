/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicare.hospital;

/**
 *
 * @author Rhula
 */
public class BedManagement {
    // 2D array representing the hospital beds.
    // There are 4 rows with 5 beds in each row, giving 20 beds in total.
    private String[][] beds = {
        {"B01", "B02", "B03", "B04", "B05"},
        {"B06", "B07", "B08", "B09", "B10"},
        {"B11", "B12", "B13", "B14", "B15"},
        {"B16", "B17", "B18", "B19", "B20"}
    };
    // 2D array used to store the Patient ID occupying each bed.
    String[][] bedPatients = new String[4][5];
    
      // Allocate a bed to a patient
    public String allocateBed(String patientID, patientCategory category) {
     // Only patients with the INPATIENT category can receive a bed
    if (category != patientCategory.INPATIENT) {
        System.out.println("Only inpatients can be allocated a hospital bed.");
        return null;
    }

    // Check if patient already has a bed
    for (int row = 0; row < beds.length; row++) {
        for (int col = 0; col < beds[row].length; col++) {
            if (patientID.equals(bedPatients[row][col])) {
                System.out.println("Patient " + patientID +
                        " already occupies bed " + beds[row][col] + ".");
                return null;
            }
        }
    }

    // Find first available bed
    for (int row = 0; row < beds.length; row++) {
        for (int col = 0; col < beds[row].length; col++) {
            if (bedPatients[row][col] == null) {
                String bedNumber = beds[row][col];
                bedPatients[row][col] = patientID;
                System.out.println("Bed " + bedNumber +
                        " allocated to patient " + patientID);
                return bedNumber;
            }
        }
    }

    System.out.println("No beds are currently available.");
    return null;
}
    
    // Release a patient's bed
    public boolean releaseBed(String patientID) {

        for (int row = 0; row < beds.length; row++) {
            for (int col = 0; col < beds[row].length; col++) {

                if (patientID.equals(bedPatients[row][col])) {

                    System.out.println("Bed " + beds[row][col]
                            + " released from patient " + patientID);

                    bedPatients[row][col] = null;

                    return true;
                }
            }
        }

        System.out.println("Patient " + patientID + " does not have a bed.");
        return false;
    }
    
      // Display complete ward layout
    public void displayWardLayout() {

        System.out.println("\n========== WARD LAYOUT ==========");

        for (int row = 0; row < beds.length; row++) {
            for (int col = 0; col < beds[row].length; col++) {

                if (bedPatients[row][col] == null) {
                    System.out.print("[" + beds[row][col] + " Available] ");
                } else {
                    System.out.print("[" + beds[row][col]
                            + " Occupied: " + bedPatients[row][col] + "] ");
                }
            }

            System.out.println();
        }

    }
    
    // Display available beds
    public void displayAvailableBeds() {

        System.out.println("\n========== AVAILABLE BEDS ==========");

        boolean available = false;

        for (int row = 0; row < beds.length; row++) {
            for (int col = 0; col < beds[row].length; col++) {

                if (bedPatients[row][col] == null) {
                    System.out.println(beds[row][col]);
                    available = true;
                }
            }
        }

        if (!available) {
            System.out.println("No beds are available.");
        }

        System.out.println("====================================");
    }
    
    // Display occupied beds
    public void displayOccupiedBeds() {

        System.out.println("\n========== OCCUPIED BEDS ==========");

        boolean occupied = false;

        for (int row = 0; row < beds.length; row++) {
            for (int col = 0; col < beds[row].length; col++) {

                if (bedPatients[row][col] != null) {
                    System.out.println(beds[row][col]
                            + " -> Patient: " + bedPatients[row][col]);

                    occupied = true;
                }
            }
        }

        if (!occupied) {
            System.out.println("No beds are occupied.");
        }

        System.out.println("===================================");
    }
    
    // Check if there are available beds
    public boolean hasAvailableBed() {

        for (int row = 0; row < beds.length; row++) {
            for (int col = 0; col < beds[row].length; col++) {

                if (bedPatients[row][col] == null) {
                    return true;
                }
            }
        }

        return false;
    }
    
    // Total occupied beds
    public int getOccupiedBedsCount() {
        int count = 0;

        for (int row = 0; row < bedPatients.length; row++) {
            for (int col = 0; col < bedPatients[row].length; col++) {
                if (bedPatients[row][col] != null) {
                    count++;
                }
            }
        }

        return count;
    }
    
    // Total available beds
    public int getAvailableBedsCount() {
        return 20 - getOccupiedBedsCount();
    }
    
    // Ward occupancy percentage
    public double getOccupancyPercentage() {
        return (getOccupiedBedsCount() / 20.0) * 100;
    }
}
    
