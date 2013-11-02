/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gedcom;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alan
 */
public class OutputDisplayerTest {
    
    public OutputDisplayerTest() {
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
     * Test of displayData method, of class OutputDisplayer.
     */
    @Test
    public void testDisplayData() {
        System.out.println("displayData");
        List<Person> lPerson = null;
        List<Family> lFamily = null;
        OutputDisplayer.displayData(lPerson, lFamily);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPersonNode method, of class OutputDisplayer.
     */
    @Test
    public void testFindPersonNode() {
        System.out.println("findPersonNode");
        List<Person> lPerson = null;
        String ID = "";
        Person expResult = null;
        Person result = OutputDisplayer.findPersonNode(ID, lPerson);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pout method, of class OutputDisplayer.
     */
    @Test
    public void testPout() {
        System.out.println("pout");
        String output = "";
        OutputDisplayer.pout(output);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poutln method, of class OutputDisplayer.
     */
    @Test
    public void testPoutln() {
        System.out.println("poutln");
        String output = "";
        OutputDisplayer.poutln(output);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
