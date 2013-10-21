package gedcom;
 
import java.util.ArrayList;
import java.util.List;

public class GedcomProcessService {

    // just put these here for development purposes
    // private static String GedcomFilename = "C:/temp/My-Family-2-Sep-2013.ged";
    private static String testFilename = "/Users/michaelcasey/Google Drive/Code/netbeans_projects/gedcom/src/gedcom/Project5_GEDCOM_GoodFormat.ged";
    //private static String FamilyDataFilename = "/Users/michaelcasey/Google Drive/Code/netbeans_projects/gedcom/src/gedcom/familydata.ged";    

    public static void main(String[] args) {
        String filename = new String();

        if (args != null && args.length > 0) {
            filename = args[0];  //  commandline argument
        } else {
            filename = testFilename;
        }

        execute(filename);
    }

    private static void execute(String filename) {
        List<Person> personList = new ArrayList<Person>();
        List<Family> familyList = new ArrayList<Family>();
        ArrayList<String> validatedGedcomLines = new ArrayList<String>();

        try {
        Filedata.loadValidDataToArray(filename,validatedGedcomLines);
        }
        catch(Exception e){
                System.out.println("Exception thrown during loadValidDataToArray, please investigate..");
                e.printStackTrace();
        }

        try {
        Data.processGedcomData(validatedGedcomLines, personList, familyList);
        }
        catch(Exception e){
                System.out.println("Exception thrown during processGedcomData, please investigate..");
                e.printStackTrace();
        }

        try {
        ProcessedData.outputFamilyData(personList, familyList,FamilyDataFilename);
        }
        catch(Exception e){
                System.out.println("Exception thrown during outputFamilyData, please investigate..");
                e.printStackTrace();
        }
    }


}

