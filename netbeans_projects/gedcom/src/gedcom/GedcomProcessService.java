package gedcom;
 
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GedcomProcessService {
    /** @author Ronny */
    
    public static String FilesPath = "";    
    private static String testFilename = "Project5_GEDCOM_GoodFormat.ged";
    private static String FamilyDataFilename = "familydata.ged";    // For testing purposes

    public static void main(String[] args) {
        String filename = new String();

        File winPC = new File("C:/temp/" + testFilename);
        if (winPC.exists()){  // Alan - this could be done better, but just this for a quick test of GitHub and some useful functionaltiy
            FilesPath = "C:/temp/";
        } else {  // Alan - assume it's Casey's Mac.  Could use other code here for other tests
            FilesPath = "/Users/michaelcasey/Google Drive/Code/netbeans_projects/gedcom/src/gedcom/";
        }
        FamilyDataFilename = FilesPath + FamilyDataFilename;
        
        if (args != null && args.length > 0) {
            filename = args[0];  //  commandline argument
        } else {
            filename = FilesPath + testFilename;
        }

        execute(filename);
    }

    private static void execute(String filename) {
        List<Person> personList = new ArrayList<Person>();
        List<Family> familyList = new ArrayList<Family>();
        ArrayList<String> validatedGedcomLines = new ArrayList<String>();

        try {
        FileLoader.loadValidDataToArray(filename,validatedGedcomLines);
        }
        catch(Exception e){
                System.out.println("Exception thrown during loadValidDataToArray, please investigate..");
                e.printStackTrace();
        }

        try {
        BeanProducer.processGedcomData(validatedGedcomLines, personList, familyList);
        }
        catch(Exception e){
                System.out.println("Exception thrown during processGedcomData, please investigate..");
                e.printStackTrace();
        }

        try {
        OutputDisplayer.displayData(personList, familyList);
        }
        catch(Exception e){
                System.out.println("Exception thrown during outputFamilyData, please investigate..");
                e.printStackTrace();
        }
    }


}

