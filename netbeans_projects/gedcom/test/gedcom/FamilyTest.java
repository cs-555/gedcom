/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gedcom;

import java.util.ArrayList;
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
public class FamilyTest {
    
    public FamilyTest() {
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
     * Test of getIdentifier method, of class Family.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        Family instance = new Family();
        String expResult = "";
        String result = instance.getIdentifier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdentifier method, of class Family.
     */
    @Test
    public void testSetIdentifier() {
        System.out.println("setIdentifier");
        String identifier = "";
        Family instance = new Family();
        instance.setIdentifier(identifier);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdType method, of class Family.
     */
    @Test
    public void testGetIdType() {
        System.out.println("getIdType");
        Family instance = new Family();
        String expResult = "";
        String result = instance.getIdType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdType method, of class Family.
     */
    @Test
    public void testSetIdType() {
        System.out.println("setIdType");
        String idType = "";
        Family instance = new Family();
        instance.setIdType(idType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFam method, of class Family.
     */
    @Test
    public void testGetFam() {
        System.out.println("getFam");
        Family instance = new Family();
        String expResult = "";
        String result = instance.getFam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFam method, of class Family.
     */
    @Test
    public void testSetFam() {
        System.out.println("setFam");
        String fam = "";
        Family instance = new Family();
        instance.setFam(fam);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarr method, of class Family.
     */
    @Test
    public void testGetMarr() {
        System.out.println("getMarr");
        Family instance = new Family();
        String expResult = "";
        String result = instance.getMarr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarr method, of class Family.
     */
    @Test
    public void testSetMarr() {
        System.out.println("setMarr");
        String marr = "";
        Family instance = new Family();
        instance.setMarr(marr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHusb method, of class Family.
     */
    @Test
    public void testGetHusb() {
        System.out.println("getHusb");
        Family instance = new Family();
        String expResult = "";
        String result = instance.getHusb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHusb method, of class Family.
     */
    @Test
    public void testSetHusb() {
        System.out.println("setHusb");
        String husb = "";
        Family instance = new Family();
        instance.setHusb(husb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWife method, of class Family.
     */
    @Test
    public void testGetWife() {
        System.out.println("getWife");
        Family instance = new Family();
        String expResult = "";
        String result = instance.getWife();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWife method, of class Family.
     */
    @Test
    public void testSetWife() {
        System.out.println("setWife");
        String wife = "";
        Family instance = new Family();
        instance.setWife(wife);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChil method, of class Family.
     */
    @Test
    public void testGetChil() {
        System.out.println("getChil");
        int i = 0;
        Family instance = new Family();
        String expResult = "";
        String result = instance.getChil(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllChildren method, of class Family.
     */
    @Test
    public void testGetAllChildren() {
        System.out.println("getAllChildren");
        Family instance = new Family();
        String[] expResult = null;
        String[] result = instance.getAllChildren();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printAllChildren method, of class Family.
     */
    @Test
    public void testPrintAllChildren() {
        System.out.println("printAllChildren");
        Family instance = new Family();
        String expResult = "";
        String result = instance.printAllChildren();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListChil method, of class Family.
     */
    @Test
    public void testGetListChil() {
        System.out.println("getListChil");
        Family instance = new Family();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getListChil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChil method, of class Family.
     */
    @Test
    public void testSetChil() {
        System.out.println("setChil");
        String chil = "";
        Family instance = new Family();
        instance.setChil(chil);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiv method, of class Family.
     */
    @Test
    public void testGetDiv() {
        System.out.println("getDiv");
        Family instance = new Family();
        String expResult = "";
        String result = instance.getDiv();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiv method, of class Family.
     */
    @Test
    public void testSetDiv() {
        System.out.println("setDiv");
        String div = "";
        Family instance = new Family();
        instance.setDiv(div);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Family.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Family instance = new Family();
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Family.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        Family instance = new Family();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
