/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gedcom;

import java.util.ArrayList;
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
public class BeanProducerTest {
    
    public BeanProducerTest() {
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
     * Test of processGedcomData method, of class BeanProducer.
     */
    @Test
    public void testProcessGedcomData() throws Exception {
        System.out.println("processGedcomData");
        ArrayList<String> validatedGedcomLines = null;
        List<Person> personList = null;
        List<Family> familyList = null;
        BeanProducer.processGedcomData(validatedGedcomLines, personList, familyList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filterFamilyInfo method, of class BeanProducer.
     */
    @Test
    public void testFilterFamilyInfo() {
        System.out.println("filterFamilyInfo");
        ArrayList<String> validatedGedcomLines = null;
        List<Family> familyList = null;
        BeanProducer.filterFamilyInfo(validatedGedcomLines, familyList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filterPersonInfo method, of class BeanProducer.
     */
    @Test
    public void testFilterPersonInfo() {
        System.out.println("filterPersonInfo");
        ArrayList<String> validatedGedcomLines = null;
        List<Person> personList = null;
        BeanProducer.filterPersonInfo(validatedGedcomLines, personList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPersonTag method, of class BeanProducer.
     */
    @Test
    public void testIsPersonTag() {
        System.out.println("isPersonTag");
        String[] gedcomlinearray = null;
        boolean expResult = false;
        boolean result = BeanProducer.isPersonTag(gedcomlinearray);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFamilyTag method, of class BeanProducer.
     */
    @Test
    public void testIsFamilyTag() {
        System.out.println("isFamilyTag");
        String[] gedcomlinearray = null;
        boolean expResult = false;
        boolean result = BeanProducer.isFamilyTag(gedcomlinearray);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEndOfGedcomFile method, of class BeanProducer.
     */
    @Test
    public void testIsEndOfGedcomFile() {
        System.out.println("isEndOfGedcomFile");
        String[] gedcomlinearray = null;
        boolean expResult = false;
        boolean result = BeanProducer.isEndOfGedcomFile(gedcomlinearray);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPersonBean method, of class BeanProducer.
     */
    @Test
    public void testCreatePersonBean() {
        System.out.println("createPersonBean");
        ArrayList personarraylist = null;
        List<Person> personList = null;
        BeanProducer.createPersonBean(personarraylist, personList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFamilyBean method, of class BeanProducer.
     */
    @Test
    public void testCreateFamilyBean() {
        System.out.println("createFamilyBean");
        ArrayList familyarraylist = null;
        List<Family> familyList = null;
        BeanProducer.createFamilyBean(familyarraylist, familyList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
