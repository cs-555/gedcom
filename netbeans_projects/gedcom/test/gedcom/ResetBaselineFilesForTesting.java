package gedcom;

import com.sun.org.apache.xpath.internal.operations.And;
import static java.nio.file.StandardCopyOption.*;
import static gedcom.GedcomProcessService.FamilyDataFilename;
import static gedcom.GedcomProcessService.FilesPath;
//import static gedcom.GedcomProcessService.testFilename;
import java.io.File;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import static org.junit.Assert.*;


public class ResetBaselineFilesForTesting {
/** @author Alan */

    // YOU MUST SET THIS STRING TO A NEW BASELINE WHEN THE PROGRAM IS CHANGED
    // THE BASELINE FILES ARE ONLY USED WHEN PERFROMING REFACTORING
    public static String newBaseLine = "baseline4";
    public static String personBeanFilename = "personbeans.txt";  // could be made global public in GedcomProcessService.java & chg in BeanProducer
    public static String familyBeanFilename = "familybeans.txt";  // could be made global public in GedcomProcessService.java & chg in BeanProducer
    
    public ResetBaselineFilesForTesting() {
    }

    @Test
    public void testResetBaselines() throws Exception {
        //String noteBeanFile;

        String[] args = null;
        GedcomProcessService.main(args);
        System.out.println("\r\nThis method will create a new baseline file set for testing the project output.");
        // FamilyDataFilename = "afamilydata.ged"; // This was to test the file missing logic.  Can eventually be deleted
        
        // Duplicate code from GedcomProcessService.main(args) to set the FilesPath for different platforms
        //File winPC = new File("C:/temp/" + testFilename);
        File winPC = new File("C:/temp/");
        if (winPC.exists()){  // Alan - this could be done better, but just this for a quick test of GitHub and some useful functionaltiy
            FilesPath = "C:/temp/";
        } else {  // Alan - assume it's Casey's Mac.  Could use other code here for other tests
            FilesPath = "/Users/mcasey/NetBeansProjects/gedcom/netbeans_projects/gedcom/src/gedcom/";
        }

        // Confirm existing baseline files will not be overwritten
        // Must always preserve old baseline files
        Boolean filesExist = false;
        File baseLnfamData = new File(FilesPath + newBaseLine + FamilyDataFilename);
        File baseLnpersBeans = new File(FilesPath + newBaseLine + personBeanFilename);
        File baseLnfamBeans = new File(FilesPath + newBaseLine + familyBeanFilename);
        if (baseLnfamData.exists()) { filesExist = true; }
        if (baseLnpersBeans.exists()) { filesExist = true; } 
        if (baseLnfamBeans.exists()) { filesExist = true; }
        System.out.println(newBaseLine + FamilyDataFilename + " exists: " + baseLnfamData.exists());
        System.out.println(newBaseLine + personBeanFilename + " exists: " + baseLnpersBeans.exists());
        System.out.println(newBaseLine + familyBeanFilename + " exists: " + baseLnfamBeans.exists());
        if (filesExist){
            System.out.println("1 or more " + newBaseLine + " files exist.");
            System.out.println("existing " + newBaseLine + " cannot be overwritten\r\n");
            System.out.println("Change newBaseLine String in ResetBaselineFilesForTesting test class.\r\n\r\n");
            fail("READ HERE >>> " 
              + "One or more of the files listed above exist and can't be overwritten");
        } else {
            System.out.println("No " + newBaseLine + "files are present. Baseline reset continuing.");
        }
        
        // Test line to confirm to logic below
        // FamilyDataFilename = "a" + FamilyDataFilename;
        
        // Confirm all the required files exist to create baseline files
        filesExist = true;
        File famData = new File(FilesPath + FamilyDataFilename);
        File persBeans = new File(FilesPath + personBeanFilename);
        File famBeans = new File(FilesPath + familyBeanFilename);
        if (!famData.exists()) { filesExist = false; }
        if (!persBeans.exists()) { filesExist = false; }
        if (!famBeans.exists()) { filesExist = false; }
        System.out.println(FamilyDataFilename + "exists: " + famData.exists());
        System.out.println(personBeanFilename + "exists: " + persBeans.exists());
        System.out.println(familyBeanFilename + "exists: " + famBeans.exists());
        if (!filesExist){
            System.out.println("One or more of the files required do not exist.  Baseline Reset halted.");
            fail("READ HERE >>> " 
              + "One or more of the files required do not exist.  Baseline Reset halted.");
        } else {
            System.out.println("Required files are present.");
        }

        // Copy the output of the program into the baseline files for testing
        Path pathfamDatasrc = Paths.get(FilesPath + FamilyDataFilename);
        Path pathfamDatadest = Paths.get(FilesPath + newBaseLine + FamilyDataFilename);
        Files.copy(pathfamDatasrc, pathfamDatadest,COPY_ATTRIBUTES);
        
        Path pathpersBeanssrc = Paths.get(FilesPath + personBeanFilename);
        Path pathpersBeansdest = Paths.get(FilesPath + newBaseLine + personBeanFilename);
        Files.copy(pathpersBeanssrc, pathpersBeansdest,COPY_ATTRIBUTES);

        Path pathfamBeanssrc = Paths.get(FilesPath + familyBeanFilename);
        Path pathfamBeansdest = Paths.get(FilesPath + newBaseLine + familyBeanFilename);
        Files.copy(pathfamBeanssrc, pathfamBeansdest,COPY_ATTRIBUTES);
        
        // Confirm the baseline files were created
        File newBaseLnfamData = new File(FilesPath + newBaseLine + FamilyDataFilename);
        File newBaseLnpersBeans = new File(FilesPath + newBaseLine + personBeanFilename);
        File newBaseLnfamBeans = new File(FilesPath + newBaseLine + familyBeanFilename);
        System.out.println(newBaseLine + FamilyDataFilename + " exists: " + newBaseLnfamData.exists());
        System.out.println(newBaseLine + personBeanFilename + " exists: " + newBaseLnpersBeans.exists());
        System.out.println(newBaseLine + familyBeanFilename + " exists: " + baseLnfamBeans.exists());
        if (newBaseLnfamData.exists() && newBaseLnpersBeans.exists() && newBaseLnfamBeans.exists()){
            System.out.println(newBaseLine + " files were created.  Tests using baseline files can be run.\r\n");
        } else {
            fail("Some" + newBaseLine + " files were NOT created. "
               + "Please investigate before runing tests using baseline files.\r\n");
            
        }
        
    }
   
}
