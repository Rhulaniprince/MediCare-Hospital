/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package medicare.hospital;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhula
 */
public class patientTest {
    
    private patient instance;
 
    public patientTest() {
    }
 
    @BeforeClass
    public static void setUpClass() {
    }
 
    @AfterClass
    public static void tearDownClass() {
    }
 
    // Create a fresh patient before every test so tests don't depend on order
    @Before
    public void setUp() {
        instance = new patient("P001", "John", "Smith", 45, "Male",
                "Flu", patientCategory.OUTPATIENT);
    }
 
    @After
    public void tearDown() {
    }
 
    /**
     * Test of getPatientID method, of class patient.
     */
    @Test
    public void testGetPatientID() {
        System.out.println("getPatientID");
        String expResult = "P001";
        String result = instance.getPatientID();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of getFirstName method, of class patient.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "John";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of getLastName method, of class patient.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Smith";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of getAge method, of class patient.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        int expResult = 45;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of getGender method, of class patient.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        String expResult = "Male";
        String result = instance.getGender();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of getCondition method, of class patient.
     */
    @Test
    public void testGetCondition() {
        System.out.println("getCondition");
        String expResult = "Flu";
        String result = instance.getCondition();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of getCategory method, of class patient.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        patientCategory expResult = patientCategory.OUTPATIENT;
        patientCategory result = instance.getCategory();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of setFirstName method, of class patient.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        instance.setFirstName("Peter");
        assertEquals("Peter", instance.getFirstName());
    }
 
    /**
     * Test of setLastName method, of class patient.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        instance.setLastName("Jones");
        assertEquals("Jones", instance.getLastName());
    }
 
    /**
     * Test of setAge method, of class patient.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        instance.setAge(50);
        assertEquals(50, instance.getAge());
    }
 
    /**
     * Test of setGender method, of class patient.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        instance.setGender("Female");
        assertEquals("Female", instance.getGender());
    }
 
    /**
     * Test of setCondition method, of class patient.
     */
    @Test
    public void testSetCondition() {
        System.out.println("setCondition");
        instance.setCondition("Recovered");
        assertEquals("Recovered", instance.getCondition());
    }
 
    /**
     * Test of setCategory method, of class patient.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        instance.setCategory(patientCategory.EMERGENCY);
        assertEquals(patientCategory.EMERGENCY, instance.getCategory());
    }
 
    /**
     * Test of displayDetails method, of class patient.
     */
    @Test
    public void testDisplayDetails() {
        System.out.println("displayDetails");
        String result = instance.displayDetails();
        // Check that the key fields all appear in the formatted output
        // rather than asserting the whole string, which is brittle to
        // formatting changes.
        assertTrue(result.contains("Patient ID: P001"));
        assertTrue(result.contains("Name: John"));
        assertTrue(result.contains("LastName: Smith"));
        assertTrue(result.contains("Age: 45"));
        assertTrue(result.contains("Gender: Male"));
        assertTrue(result.contains("Condition: Flu"));
        assertTrue(result.contains("Category: OUTPATIENT"));
    }
    
}
