/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicare.hospital;

/**
 *
 * @author Rhula
 */

// It inherits the properties and methods from the patient class
public class Inpatient extends patient {

    
    private String wardNumber;
    private String bedNumber;
    // Constructor used to create a new Inpatient object
    public Inpatient(String patientID, String firstName, String lastName,
                     int age, String gender, String condition,
                     String wardNumber, String bedNumber) {

        // Calls the constructor of the parent patient class
        super(patientID, firstName, lastName, age, gender, condition,
              patientCategory.INPATIENT);

        // Store the ward number passed into the constructor
        this.wardNumber = wardNumber;
         // Store the bed number passed into the constructor
        this.bedNumber = bedNumber;
    }
    // Returns the ward number of the inpatient
    public String getWardNumber() {
        return wardNumber;
    }
     // Returns the bed number of the inpatient
    public String getBedNumber() {
        return bedNumber;
    }
     // Changes or updates the ward number
    public void setWardNumber(String wardNumber) {
        this.wardNumber = wardNumber;
    }
    // Changes or updates the bed number
    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }
    // Overrides the displayDetails() method from the patient class
    @Override
    public String displayDetails() {
        // First display the normal patient details
         // Then add the inpatient's ward and bed information
        return super.displayDetails()
                + "\nWard Number: " + wardNumber
                + "\nBed Number: " + bedNumber;
    }
}

