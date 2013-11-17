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
 * @author michaelcasey
 */
public class PolygamyTest {
    
    public PolygamyTest() {
        setUpClass();
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
     * Test of getPolygamy method, of class Polygamy.
     */
    @Test
    public void testGetPolygamy() {
         System.out.println("getPolygamy");
         List<Family> familyList = new ArrayList<>();
         //create test family
         Family testFamily1 = new Family();
         testFamily1.setHusb("@I1@");
         testFamily1.setWife("@I2@");
         //create test family with polygamous husband
         Family testFamily2 = new Family();
         testFamily2.setHusb("@I1@");
         testFamily2.setWife("@I3@");         
         
         familyList.add(testFamily1);
         familyList.add(testFamily2);
         
         ArrayList<String> expResult = new ArrayList<String>();
         expResult.add("@I1@");
                  
         ArrayList result = Polygamy.getPolygamy(familyList);
         assertEquals(expResult, result);
    }

    /**
     * Test of checkOtherFamilies method, of class Polygamy.
     */
    @Test
    public void testCheckOtherFamilies() {
        System.out.println("checkOtherFamilies");
        System.out.println("This method is implicitly tested in testGetPolygamy");
    }
    
}
