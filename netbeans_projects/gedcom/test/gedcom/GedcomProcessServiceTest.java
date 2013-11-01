package gedcom;

import static gedcom.ResetBaselineFilesForTesting.newBaseLine;
import static gedcom.ResetBaselineFilesForTesting.personBeanFilename;
import static gedcom.ResetBaselineFilesForTesting.familyBeanFilename;
import static gedcom.GedcomProcessService.FamilyDataFilename;
import static gedcom.GedcomProcessService.FilesPath;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/** @author Alan */
public class GedcomProcessServiceTest {
    
    public GedcomProcessServiceTest() {
    }
    
    /** BASELINE FILES MUST BE UPDATED BEFORE BEGINNING REFACTORING
     *  TO BE SURE AN UPDATED IMAGE OF THE CURRENT FEATURE SET IS CAPTURED
     */
    @Test
    public void testRefactoring() {
        Boolean famDataOK = true;
        Boolean persBeanOK = true;
        Boolean famBeanOK = true;
        System.out.println("main");
        String[] args = null;
        GedcomProcessService.main(args);

        // Compare new files to baseline files
        System.out.println("\r\nFiles being compared to test refactoring.");
        famDataOK = CompareFiles(FilesPath + FamilyDataFilename,
                        FilesPath + newBaseLine + FamilyDataFilename);
        if (famDataOK){
            System.out.println(FamilyDataFilename + " is still OK.");
        } else {
            System.out.println(FamilyDataFilename + " OUTPUT HAS CHANGED.");
        }
        
        persBeanOK = CompareFiles(FilesPath + personBeanFilename,
                        FilesPath + newBaseLine + personBeanFilename);
        if (persBeanOK){
            System.out.println(personBeanFilename + " is still OK.");
        } else {
            System.out.println(personBeanFilename + " OUTPUT HAS CHANGED.");
        }
        
        famBeanOK = CompareFiles(FilesPath + familyBeanFilename,
                        FilesPath + newBaseLine + familyBeanFilename);
        if (famBeanOK){
            System.out.println(familyBeanFilename + " is still OK.");
        } else {
            System.out.println(familyBeanFilename + " OUTPUT HAS CHANGED.");
        }
        
        assertTrue(famDataOK && persBeanOK && famBeanOK);
        
    }

    // UPDATED: compare is line by line
    // An error displays both lines with 1> and 2> 
    private static boolean CompareFiles(
        String file1, 
        String file2) {

        BufferedReader reader = null;
        String linea;
        String lineb;
        StringBuilder sba = new StringBuilder();
        StringBuilder sbb = new StringBuilder();
        Boolean compareResult = true;

        try {
            FileInputStream filea = new FileInputStream(file1);
            BufferedReader inputb;
            try (BufferedReader inputa = new BufferedReader
                            (new InputStreamReader(filea))) {
//                while ((linea = inputa.readLine()) != null) {
//                    sba.append(linea);
//                    sba.append("\n\r");
//                }   FileInputStream fileb = new FileInputStream(file2);
//                inputb = new BufferedReader
//                            (new InputStreamReader(fileb));
//                while ((lineb = inputb.readLine()) != null) {
//                    sbb.append(lineb);
//                    sbb.append("\r\n");
//                }
                FileInputStream fileb = new FileInputStream(file2);
                inputb = new BufferedReader
                            (new InputStreamReader(fileb));
                while ( ((linea = inputa.readLine()) != null) && ((lineb = inputb.readLine()) != null) ) {
                    sba.append(linea);
                    sbb.append(lineb);
                    compareResult = compareResult && (linea.equals(lineb));
                    if (!compareResult) {
                        System.out.println("1> " + linea);
                        System.out.println("2> " + lineb);
                    }
                }
            }
            inputb.close();
        } catch (IOException e) {
            System.out.println("outer catch error -- ");
            // e.printStackTrace();
        } finally {
            try {
                if (reader != null) { //if reader != null then it is still open
                    reader.close(); 
                }
            } catch (IOException e) {
                System.out.println("inner catch error -- ");
                // e.printStackTrace();
            }
        }
        //compareResult = compareResult && sba.toString().equals(sbb.toString());
        //compareResult = compareResult && (sba.length() == sbb.length());
        return(compareResult);
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
}

