package gedcom;
 
import java.io.Writer;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import static gedcom.OutputDisplayer.pout;
import static gedcom.OutputDisplayer.poutln;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class GedcomProcessService {
    /** @author Ronny */
    
    public static String FilesPath = "";    
    //public static String testFilename = "Project5_GEDCOM_sprint1TestFile.ged";
    //public static String testFilename = "Project5_GEDCOM_sprint2TestFile.ged";
    //public static String testFilename = "Project5_GEDCOM_sprint3TestFile.ged";
    //public static String testFilename = "testfile.txt";
    //public static String FamilyDataFilename = "familydata.ged";
    public static String FamilyDataFilename = "familydata.out";
    public static Writer writer = null;

    public static void main(String[] args) {
        String filename;

        Path pfamDatasrc;
        pfamDatasrc = FileSystems.getDefault().getPath("C:/temp");

        // Set the FilesPath for different platforms
        //File winPC = new File("C:/temp/" + testFilename);
        File winPC = new File("C:/temp/");
        if (winPC.exists()){  // Alan - this could be done better, but just this for a quick test of GitHub and some useful functionaltiy
            FilesPath = "C:/temp/";
        } else {  // Alan - assume it's Casey's Mac.  Could use other code here for other tests
            FilesPath = "/Users/mcasey/NetBeansProjects/gedcom/netbeans_projects/gedcom/src/gedcom/";
            //MC Home Computer 
            //FilesPath = "/Users/michaelcasey/Google Drive/Code/netbeans_projects/gedcom/src/gedcom/"
        }
        // FamilyDataFilename = FilesPath + FamilyDataFilename;
        
        if (args != null && args.length > 0) {
            filename = args[0];  //  commandline argument
        } else {
            //filename = FilesPath + testFilename;
            filename = FilesPath;
        }

        execute(filename);
    }

    private static void execute(String filename) {
        List<Person> personList = new ArrayList<>();
        List<Family> familyList = new ArrayList<>();
        ArrayList<String> validatedGedcomLines = new ArrayList<>();
        //ArrayList<String> validatedGedcomLines = new ArrayList<String>();

        try { // sets up writer for global access. See pout/poutln in class OutputDisplayer
            File outfile = new File(FilesPath + FamilyDataFilename);
            writer = new BufferedWriter(new FileWriter(outfile));
        } catch (IOException e){
            System.out.println("Exception thrown opening writer, please investigate..");
            // e.printStackTrace();
        }

        try {
        FileLoader.loadValidDataToArray(filename,validatedGedcomLines);
        }
        catch(Exception e){
                System.out.println("Exception thrown during loadValidDataToArray, please investigate..");
                // e.printStackTrace();
        }

        try {
        BeanProducer.processGedcomData(validatedGedcomLines, personList, familyList);
        }
        catch(Exception e){
                System.out.println("Exception thrown during processGedcomData, please investigate..");
                //e.printStackTrace();
        }

        try {
            // COMMENT OUT THE NEXT LINE TO PROVE THE REFEACTOR TEST WORKS CORRECTLY
            OutputDisplayer.displayData(personList, familyList);
        }
        catch(Exception e){
                System.out.println("Exception thrown during outputFamilyData, please investigate..");
                //e.printStackTrace();
        }
        
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e){
            System.out.println("Exception thrown trying to close writer, please investigate..");
            //e.printStackTrace();
        }
    }


}

