/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gedcom;

import java.util.ArrayList;
import java.util.HashMap;
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
public class FileLoaderTest {
    
    public FileLoaderTest() {
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
     * Test of loadValidDataToArray method, of class FileLoader.
     */
    @Test
    public void testLoadValidDataToArray() {
        System.out.println("loadValidDataToArray");
        String GedcomFilename = "";
        ArrayList<String> GedcomLines = null;
        FileLoader.loadValidDataToArray(GedcomFilename, GedcomLines);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateValidTags method, of class FileLoader.
     */
    @Test
    public void testPopulateValidTags() {
        System.out.println("populateValidTags");
        HashMap<String, String> hm = null;
        FileLoader.populateValidTags(hm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
