/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gedcom;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author michaelcasey
 */
public class DeathBeforeBirthTest {
    
    public DeathBeforeBirthTest() {
        System.out.print("StartBeforeBirthTest");
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

    @Test
    public void testGetDeathBeforeBirthErrors() {
        System.out.println("getDeathBeforeBirthErrors");
        DeathBeforeBirth instance = new DeathBeforeBirth();
        
        //test quantity of errors
        Integer expNumberOfErrors = 3;
        Integer result = instance.getDeathBeforeBirthErrors().size();
        assertEquals(expNumberOfErrors, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }    
    
}
