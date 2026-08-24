/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicare.hospital;

/**
 *
 * @author Rhula
 */
public class patient {
    
    private String patientID;
    private String FristName;
    private String LastName;
    private int Age;
    private String Gender;
    private String Condition;
    private patientCategory category;
    
     // Constructor used to create a new patient object
    public patient(String patientID,String FristName,String LastName,int Age,String Gender,String Condition,patientCategory category){
        
        // Assign the values received from the constructor
        this.patientID = patientID;
        this.FristName = FristName;
        this.LastName = LastName;
        this.Age = Age;
        this.Gender = Gender;
        this.Condition = Condition;
        this.category = category;
    }    
   
    public String getPatientID() {
        return patientID;
    }

    public String getFirstName() {
        return FristName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return Age;
    }

    public String getGender() {
        return Gender;
    }

    public String getCondition() {
        return Condition;
    }

    public patientCategory getCategory() {
        return category;
    }

    
    public void setFirstName(String firstName) {
        this.FristName = firstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public void setCondition(String condition) {
        this.Condition = condition;
    }

    public void setCategory(patientCategory category) {
        this.category = category;
    }
  // DISPLAY PATIENT DETAILS
    public String displayDetails() {
        // Returns all the patient's information as a String
        return "Patient ID: " + this.patientID + "\n" +
               "Name: " + this.FristName + "\n" +
               "LastName: " + this.LastName + "\n" +
               "Age: " + this.Age + "\n" +
               "Gender: " + this.Gender + "\n" +
               "Condition: " + this.Condition + "\n" +
               "Category: " + this.category;
    }

}
