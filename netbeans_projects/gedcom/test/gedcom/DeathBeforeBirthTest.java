/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gedcom;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
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
     * Test of getDeathBeforeBirthErrors method, of class DeathBeforeBirth.
     */
    @Test
    public void testGetDeathBeforeBirthErrors() {
        System.out.println("getDeathBeforeBirthErrors");
        //List<Person> lperson = null;
        //ArrayList expResult = null;
        //ArrayList result = DeathBeforeBirth.getDeathBeforeBirthErrors(lperson);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isBirthAfterDeath method, of class DeathBeforeBirth.
     */
    @Test
    public void testIsBirthAfterDeath() {
        System.out.println("isBirthAfterDeath");
        GregorianCalendar birthDate = new GregorianCalendar(2013,10,10);
        GregorianCalendar deathDate = new GregorianCalendar(2012,10,10);
        boolean expResult = true;
        boolean result = DeathBeforeBirth.isBirthAfterDeath(birthDate, deathDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatBirthdate method, of class DeathBeforeBirth.
     */
    @Test
    public void testFormatBirthdate() {
        System.out.println("formatBirthdate");
        String lpersonBirthdate = "3 NOV 2013";
        GregorianCalendar expResult = new GregorianCalendar(2013,10,3);
        GregorianCalendar result = DeathBeforeBirth.formatBirthdate(lpersonBirthdate);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatDeathdate method, of class DeathBeforeBirth.
     */
    @Test
    public void testFormatDeathdate() {
        System.out.println("formatDeathdate");
        String lpersonDeathDate = "3 SEP 2013";
        GregorianCalendar expResult = new GregorianCalendar(2013,8,3);
        GregorianCalendar result = DeathBeforeBirth.formatDeathdate(lpersonDeathDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonthInteger method, of class DeathBeforeBirth.
     */
    @Test
    public void testGetMonthInteger() {
        System.out.println("getMonthInteger");
        String month = "NOV";
        Integer expResult = 10;
        Integer result = DeathBeforeBirth.getMonthInteger(month);
        assertEquals(expResult, result);
    }
    
}
