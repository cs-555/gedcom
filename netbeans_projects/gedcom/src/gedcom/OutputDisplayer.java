package gedcom;
 
import static gedcom.GedcomProcessService.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OutputDisplayer {

    public static void displayData(List<Person> lPerson, List<Family> lFamily ){
        Person personNode;
        Family familyNode;

        printPersonNode(lPerson);
        printFamilyNode(lFamily, lPerson);
        printDeathBeforeMarriageErrors(lFamily, lPerson);
        printDeathBeforeBirthErrors(lPerson);
        
    }
    
    public static void printDeathBeforeBirthErrors(List<Person> lPerson){      
        
        
        try {
            ArrayList<Person> results = DeathBeforeBirth.getDeathBeforeBirthErrors(lPerson);
              
            System.out.println("Death Before Birth Errors: \n");
            for (int i = 0; i < results.size(); i++){
                pout("Individal "+ results.get(i).getIndi() + " " +  
                lPerson.get(i).getName() + "'s " + 
                "birthdate "+ results.get(i).getBirt() + " " + 
                "is after their deathdate " + results.get(i).getDeat() + ".\n");
            }
        }
        catch(Exception e){
             System.out.println("Exception thrown during getDeathBeforeBirthErrors, please investigate..");
        } 
        
    }

    private static void printDeathBeforeMarriageErrors(List<Family> lFamily, List<Person> lPerson) {
        Person personNode;
        Family familyNode;
        String marrDate, husbDeath, wifeDeath;
        Date fmarrDate, fdeatDate; // formatted dates
        DateFormat formatter;
        formatter = new SimpleDateFormat("d MMM yyyy");

        poutln("\r\nDeath before Marriage test\r\n");
        for ( int i = 0 ; i < lFamily.size() ; i++){
            familyNode = lFamily.get(i);
            marrDate = familyNode.getMarr();
            husbDeath = findPersonNode(familyNode.getHusb(), lPerson).getDeat();
            wifeDeath = findPersonNode(familyNode.getWife(), lPerson).getDeat();

            if ((!husbDeath.equals("")) && (!marrDate.equals("")) ) {
                try {
                    fmarrDate = formatter.parse(marrDate);
                    fdeatDate = formatter.parse(husbDeath);
                    if (fmarrDate.after(fdeatDate)) {
                        pout("In family " + familyNode.getIdentifier().replaceAll("@", "").replaceAll("F", "") + " ");
                        pout(findPersonNode(familyNode.getHusb(), lPerson).getName());
                        // date.toString() yields 'Sat MMM 99 99:99:99 EDT 9999'
                        pout(" died on " + fdeatDate.toString().substring(4, 10) +
                             " " + fdeatDate.toString().substring(24, 28));
                        poutln(" before the marriage date of " + fmarrDate.toString().substring(4, 10) +
                         " " + fmarrDate.toString().substring(24, 28));
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(OutputDisplayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            // TODO: ADD THE CODE FOR THE WIFE
            if ((!wifeDeath.equals("")) && (!marrDate.equals("")) ) {
                try {
                    fmarrDate = formatter.parse(marrDate);
                    fdeatDate = formatter.parse(wifeDeath);
                    if (fmarrDate.after(fdeatDate)) {
                        pout("In family " + familyNode.getIdentifier().replaceAll("@", "").replaceAll("F", "") + " ");
                        pout(findPersonNode(familyNode.getWife(), lPerson).getName());
                        // date.toString() yields 'Sat MMM 99 99:99:99 EDT 9999'
                        pout(" died on " + fdeatDate.toString().substring(4, 10) +
                             " " + fdeatDate.toString().substring(24, 28));
                        poutln(" before the marriage date of " + fmarrDate.toString().substring(4, 10) +
                         " " + fmarrDate.toString().substring(24, 28));
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(OutputDisplayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        poutln("");

    }
        
    private static void printFamilyNode(List<Family> lFamily, List<Person> lPerson) {
        Family familyNode;
        poutln("\r\nFamily List:\r\n");
        for ( int i = 0 ; i < lFamily.size() ; i++){
            familyNode = lFamily.get(i);
            pout(familyNode.getIdentifier() + ": ");
            pout("Husband: ");
            pout(findPersonNode(familyNode.getHusb(), lPerson).getName() + ",");
            pout("; Wife: ");
            pout(findPersonNode(familyNode.getWife(), lPerson).getName() + ",");
            pout("; Married: " + familyNode.getMarr());
            if (!familyNode.getDiv().isEmpty()) {
                pout("; Divorced: " + familyNode.getDiv());
            }
            if (familyNode.getAllChildren().size() > 0) {
                pout("; Children: ");
                for (int j = 0; j < familyNode.getAllChildren().size(); j++) {
                    pout(findPersonNode(familyNode.getAllChildren().get(j).toString(), lPerson).getName() + ",");
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

    public static Person findPersonNode(String ID, List<Person> lPerson) {
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
