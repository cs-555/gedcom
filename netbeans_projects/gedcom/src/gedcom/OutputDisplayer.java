package gedcom;
 
import static gedcom.GedcomProcessService.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputDisplayer {
    /** @author Joseph */

    public static void displayData(List<Person> lPerson, List<Family> lFamily ){
        Person personNode;
        Family familyNode;
        
        poutln("\r\nPerson List:\r\n");
        for ( int i = 0 ; i < lPerson.size() ; i++){
        personNode = lPerson.get(i);
        poutln(  personNode.getIndi() + ": " + personNode.getName() + 
          " (" + personNode.getBirt() + " - " + personNode.getDeat() + "), " + personNode.getSex()
        );
    }

    poutln("\r\nFamily List:\r\n");
    for ( int i = 0 ; i < lFamily.size() ; i++){
        familyNode = lFamily.get(i);
//        OLD CODE: CAN BE DELETED AFTER MERGED
//        poutln(
//            familyNode.getIdentifier() + ": " + 
//            "Husband: " + findPeople(lPerson, familyNode.getHusb()) + 
            //"Husband: " + findPeople(lPerson, familyNode.getHusb()) + 
//            "; Wife: " + findPeople(lPerson, familyNode.getWife()) + 
//            "; Married: " + familyNode.getMarr() + 
//            "; Divorced: " + familyNode.getDiv() +
//            "; Children: " + findPeople(lPerson, familyNode.printAllChildren()) +
//            ""
//        );
        pout(familyNode.getIdentifier() + ": ");
        //  OLD CODE: pout("Husband: " + findPeople(lPerson, familyNode.getHusb()));
        pout("Husband: ");
        pout(findPerson(lPerson, familyNode.getHusb()).getName() + ",");
        //  OLD CODE: pout("; Wife: " + findPeople(lPerson, familyNode.getWife()));
        pout("; Wife: ");
        pout(findPerson(lPerson, familyNode.getWife()).getName() + ",");
        pout("; Married: " + familyNode.getMarr());
        pout("; Divorced: " + familyNode.getDiv());
        //  OLD CODE: poutln("; Children: " + findPeople(lPerson, familyNode.printAllChildren()));
        pout("; Children: ");
        //poutln(findPeople(lPerson, familyNode.printAllChildren()));
        for (int j = 0; j < familyNode.getAllChildren().size(); j++) {
            pout(findPerson(lPerson, familyNode.getAllChildren().get(j).toString()).getName() + ",");
            // this is messy for now so the refactor is perfect
            // previous routine did a trim so the last child shouldn't have a space after it
            // but this can be changed when refactoring is done to clean it up
            // previous routine also has an unnecessary ',' in the output after the last child
            if (j < familyNode.getAllChildren().size() - 1) {
                pout(" ");
            }
        }
        pout("\r\n");
    }

    }

    // REFACTORED: Wanted to use a single routine for finding a person node
    // Will allow use of this routine when looking up dates for Death before Marriage
    // previous findPeople was returning a string only of real use for outputting
    public static Person findPerson(List<Person> lPerson, String ID) {
        Person personNode;
        
        for ( int i = 0 ; i < lPerson.size() ; i++) {
            personNode = lPerson.get(i);
            if (personNode.getIndi().equals(ID)) {
                return personNode;
            }
        }
        return personNode = null;
    }
    
    //  OLD CODE: CAN BE DELETED AFTER MERGE
    public static String findPeople(List<Person> lPerson, String index){
            String names = "";
            String[] indexes = index.trim().split("\\s+");

            for (int i = 0; i<indexes.length; i++){
                    for ( int j = 0 ; j < lPerson.size() ; j++){
                            if( lPerson.get(j).getIndi().trim().equals(indexes[i].trim()) ) names += lPerson.get(j).getName() + ", ";
                    }
            }
            return names.trim();
    }

    // following 2 methods to allow multiple outputs w/single line throughout the program
    public static void pout(String output) {
        System.out.print(output);
        try {
            writer.write(output);
        } catch (IOException ex) {
            System.out.print("pout writer problem, please investigate");
        }
    }

    public static void poutln(String output) {
        System.out.println(output);
        try {
            writer.write(output);
            writer.write("\r\n");
        } catch (IOException ex) {
            System.out.print("pout writer problem, please investigate");
        }
    }
        
}
