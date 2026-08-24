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
public class InpatientTest {
    
    private Inpatient instance;
 
    public InpatientTest() {
    }
 
    @BeforeClass
    public static void setUpClass() {
    }
 
    @AfterClass
    public static void tearDownClass() {
    }
 
    // Create a fresh Inpatient before every test so tests don't depend on order
    @Before
    public void setUp() {
        instance = new Inpatient("P100", "Jane", "Doe", 30, "Female",
                "Post-surgery recovery", "Ward 3", "B07");
    }
 
    @After
    public void tearDown() {
    }
 
    /**
     * Test of getWardNumber method, of class Inpatient.
     */
    @Test
    public void testGetWardNumber() {
        System.out.println("getWardNumber");
        String expResult = "Ward 3";
        String result = instance.getWardNumber();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of getBedNumber method, of class Inpatient.
     */
    @Test
    public void testGetBedNumber() {
        System.out.println("getBedNumber");
        String expResult = "B07";
        String result = instance.getBedNumber();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of setWardNumber method, of class Inpatient.
     */
    @Test
    public void testSetWardNumber() {
        System.out.println("setWardNumber");
        instance.setWardNumber("Ward 5");
        assertEquals("Ward 5", instance.getWardNumber());
    }
 
    /**
     * Test of setBedNumber method, of class Inpatient.
     */
    @Test
    public void testSetBedNumber() {
        System.out.println("setBedNumber");
        instance.setBedNumber("B12");
        assertEquals("B12", instance.getBedNumber());
    }
 
    /**
     * Test of displayDetails method, of class Inpatient.
     */
    @Test
    public void testDisplayDetails() {
        System.out.println("displayDetails");
        String result = instance.displayDetails();
        // Should contain the base patient details plus the inpatient-specific
        // ward and bed lines appended by the override.
        assertTrue(result.contains("Patient ID: P100"));
        assertTrue(result.contains("Category: INPATIENT"));
        assertTrue(result.contains("Ward Number: Ward 3"));
        assertTrue(result.contains("Bed Number: B07"));
    }
}
