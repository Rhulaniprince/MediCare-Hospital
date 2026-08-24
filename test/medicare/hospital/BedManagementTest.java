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
public class BedManagementTest {
 
    public BedManagementTest() {
    }
 
    @BeforeClass
    public static void setUpClass() {
    }
 
    @AfterClass
    public static void tearDownClass() {
    }
 
    @Before
    public void setUp() {
    }
 
    @After
    public void tearDown() {
    }
 
    /**
     * Test of allocateBed method, of class BedManagement.
     */
    @Test
    public void testAllocateBed() {
        System.out.println("allocateBed");
        String patientID = "P001";
        patientCategory category = patientCategory.INPATIENT;
        BedManagement instance = new BedManagement();
        String expResult = "B01";
        String result = instance.allocateBed(patientID, category);
        assertEquals(expResult, result);
    }
 
    /**
     * Test that allocateBed refuses non-inpatient categories.
     */
    @Test
    public void testAllocateBedRejectsNonInpatient() {
        System.out.println("allocateBed - non-inpatient");
        BedManagement instance = new BedManagement();
        String result = instance.allocateBed("P002", patientCategory.OUTPATIENT);
        assertNull(result);
    }
 
    /**
     * Test that allocateBed refuses to double-allocate the same patient.
     */
    @Test
    public void testAllocateBedRejectsDuplicatePatient() {
        System.out.println("allocateBed - duplicate patient");
        BedManagement instance = new BedManagement();
        instance.allocateBed("P001", patientCategory.INPATIENT);
        String result = instance.allocateBed("P001", patientCategory.INPATIENT);
        assertNull(result);
    }
 
    /**
     * Test of releaseBed method, of class BedManagement.
     */
    @Test
    public void testReleaseBed() {
        System.out.println("releaseBed");
        String patientID = "P001";
        BedManagement instance = new BedManagement();
 
        // The patient must actually occupy a bed before it can be released.
        // The original test skipped this step, so releaseBed always found
        // nothing and returned false against an expected true.
        instance.allocateBed(patientID, patientCategory.INPATIENT);
 
        boolean expResult = true;
        boolean result = instance.releaseBed(patientID);
        assertEquals(expResult, result);
    }
 
    /**
     * Test that releasing a patient with no bed returns false.
     */
    @Test
    public void testReleaseBedNoBed() {
        System.out.println("releaseBed - patient has no bed");
        BedManagement instance = new BedManagement();
        boolean result = instance.releaseBed("P999");
        assertFalse(result);
    }
 
    /**
     * Test of displayWardLayout method, of class BedManagement.
     */
    @Test
    public void testDisplayWardLayout() {
        System.out.println("displayWardLayout");
        BedManagement instance = new BedManagement();
        instance.displayWardLayout();
    }
 
    /**
     * Test of displayAvailableBeds method, of class BedManagement.
     */
    @Test
    public void testDisplayAvailableBeds() {
        System.out.println("displayAvailableBeds");
        BedManagement instance = new BedManagement();
        instance.displayAvailableBeds();
    }
 
    /**
     * Test of displayOccupiedBeds method, of class BedManagement.
     */
    @Test
    public void testDisplayOccupiedBeds() {
        System.out.println("displayOccupiedBeds");
        BedManagement instance = new BedManagement();
        instance.displayOccupiedBeds();
    }
 
    /**
     * Test of hasAvailableBed method, of class BedManagement.
     */
    @Test
    public void testHasAvailableBed() {
        System.out.println("hasAvailableBed");
        BedManagement instance = new BedManagement();
        boolean expResult = true;
        boolean result = instance.hasAvailableBed();
        assertEquals(expResult, result);
    }
 
    /**
     * Test that hasAvailableBed returns false once every bed is full.
     */
    @Test
    public void testHasAvailableBedWhenFull() {
        System.out.println("hasAvailableBed - ward full");
        BedManagement instance = new BedManagement();
        for (int i = 0; i < 20; i++) {
            instance.allocateBed("P" + i, patientCategory.INPATIENT);
        }
        assertFalse(instance.hasAvailableBed());
    }
 
    /**
     * Test of getOccupiedBedsCount method, of class BedManagement.
     */
    @Test
    public void testGetOccupiedBedsCount() {
        System.out.println("getOccupiedBedsCount");
        BedManagement instance = new BedManagement();
        int expResult = 0;
        int result = instance.getOccupiedBedsCount();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of getAvailableBedsCount method, of class BedManagement.
     */
    @Test
    public void testGetAvailableBedsCount() {
        System.out.println("getAvailableBedsCount");
        BedManagement instance = new BedManagement();
        int expResult = 20;
        int result = instance.getAvailableBedsCount();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of getOccupancyPercentage method, of class BedManagement.
     */
    @Test
    public void testGetOccupancyPercentage() {
        System.out.println("getOccupancyPercentage");
        BedManagement instance = new BedManagement();
        double expResult = 0.0;
        double result = instance.getOccupancyPercentage();
        assertEquals(expResult, result, 0);
    }
 
    /**
     * Test that occupancy percentage reflects allocated beds correctly.
     */
    @Test
    public void testGetOccupancyPercentageAfterAllocation() {
        System.out.println("getOccupancyPercentage - after allocating 5 beds");
        BedManagement instance = new BedManagement();
        for (int i = 0; i < 5; i++) {
            instance.allocateBed("P" + i, patientCategory.INPATIENT);
        }
        double expResult = 25.0; // 5 of 20 beds = 25%
        double result = instance.getOccupancyPercentage();
        assertEquals(expResult, result, 0.001);
    }
}
