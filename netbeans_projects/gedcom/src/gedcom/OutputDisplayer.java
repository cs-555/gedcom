package gedcom;
 
import static gedcom.GedcomProcessService.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputDisplayer {
        /** @author Joseph */
	
	public static void displayData(List<Person> lPerson, List<Family> lFamily ){
		
		poutln("\r\nPerson List:\r\n");
        for ( int i = 0 ; i < lPerson.size() ; i++){
        	Person person = lPerson.get(i);
        	poutln(  
        			person.getIndi() + ": " + person.getName() + 
        			" (" + person.getBirt() + " - " + person.getDeat() + "), " + person.getSex()
                    );
        }
	
        poutln("\r\nFamily List:\r\n");
        for ( int i = 0 ; i < lFamily.size() ; i++){
        	Family family = lFamily.get(i);
        	poutln(
                    family.getIdentifier() + ": " + 
                    "Husband: " + findPeople(lPerson, family.getHusb()) + 
                    "; Wife: " + findPeople(lPerson, family.getWife()) + 
                    "; Married: " + family.getMarr() + 
                    "; Divorced: " + family.getDiv() +
                    "; Children: " + findPeople(lPerson, family.printAllChildren()) +
                    "");
        }
		
	}
	
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
