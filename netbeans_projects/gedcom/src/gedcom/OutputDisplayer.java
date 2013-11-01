package gedcom;
 
import static gedcom.GedcomProcessService.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputDisplayer {

    public static void displayData(List<Person> lPerson, List<Family> lFamily ){
        Person personNode;
        Family familyNode;

        printPersonNode(lPerson);
        printFamilyNode(lFamily, lPerson);
        printDeathBeforeMarriageErrors(lFamily, lPerson);
        
    }

    private static void printDeathBeforeMarriageErrors(List<Family> lFamily, List<Person> lPerson) {
        Person personNode;
        Family familyNode;
        String Death;

        for ( int i = 0 ; i < lFamily.size() ; i++){
            familyNode = lFamily.get(i);
            // using the husband ID get his death
            Death = findPersonNode(lPerson, familyNode.getHusb()).toString();
            poutln(Death);
            // if death is before birth print HUSBerror
            // using the wife ID get her death
            // if death is before birth print WIFE error
        }
        poutln("\r\nDeath before Marriage test");
    }
        
    private static void printFamilyNode(List<Family> lFamily, List<Person> lPerson) {
        Family familyNode;
        poutln("\r\nFamily List:\r\n");
        for ( int i = 0 ; i < lFamily.size() ; i++){
            familyNode = lFamily.get(i);
            pout(familyNode.getIdentifier() + ": ");
            pout("Husband: ");
            pout(findPersonNode(lPerson, familyNode.getHusb()).getName() + ",");
            pout("; Wife: ");
            pout(findPersonNode(lPerson, familyNode.getWife()).getName() + ",");
            pout("; Married: " + familyNode.getMarr());
            if (!familyNode.getDiv().isEmpty()) {
                pout("; Divorced: " + familyNode.getDiv());
            }
            if (familyNode.getAllChildren().size() > 0) {
                pout("; Children: ");
                for (int j = 0; j < familyNode.getAllChildren().size(); j++) {
                    pout(findPersonNode(lPerson, familyNode.getAllChildren().get(j).toString()).getName() + ",");
                    if (j < familyNode.getAllChildren().size() - 1) {
                        pout(" ");
                    }
                }
            }
            pout("\r\n");
        }
    }

    private static void printPersonNode(List<Person> lPerson) {
        Person personNode;
        poutln("\r\nPerson List:\r\n");
        for ( int i = 0 ; i < lPerson.size() ; i++){
            personNode = lPerson.get(i);
            poutln(  personNode.getIndi() + ": " + personNode.getName() +
                    " (" + personNode.getBirt() + " - " + personNode.getDeat() + "), " + personNode.getSex()
            );
        }
    }

    public static Person findPersonNode(List<Person> lPerson, String ID) {
        Person personNode;
        
        for ( int i = 0 ; i < lPerson.size() ; i++) {
            personNode = lPerson.get(i);
            if (personNode.getIndi().equals(ID)) {
                return personNode;
            }
        }
        return personNode = null;
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
