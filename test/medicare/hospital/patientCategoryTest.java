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
public class patientCategoryTest {
    
     public patientCategoryTest() {
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
     * Test of values method, of class patientCategory.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        patientCategory[] expResult = {
            patientCategory.INPATIENT,
            patientCategory.OUTPATIENT,
            patientCategory.EMERGENCY
        };
        patientCategory[] result = patientCategory.values();
        assertArrayEquals(expResult, result);
    }
 
    /**
     * Test of valueOf method, of class patientCategory.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "INPATIENT";
        patientCategory expResult = patientCategory.INPATIENT;
        patientCategory result = patientCategory.valueOf(name);
        assertEquals(expResult, result);
    }
 
    /**
     * Test that valueOf throws for a name that isn't a valid enum constant.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalidName() {
        System.out.println("valueOf - invalid name");
        patientCategory.valueOf("NOT_A_CATEGORY");
    }
    
}
