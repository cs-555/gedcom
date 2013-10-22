package gedcom;
 
import java.util.ArrayList;
import java.util.List;



public class OutputDisplayer {
        /** @author Joseph */
	
	public static void displayData(List<Person> lPerson, List<Family> lFamily ){
		
		System.out.println("Person List:\n");
        for ( int i = 0 ; i < lPerson.size() ; i++){
        	Person person = lPerson.get(i);
        	System.out.println(  
        			person.getIndi() + ": " + person.getName() + 
        			" (" + person.getBirt() + " - " + person.getDeat() + "), " + person.getSex()
                    );
        }
	
        System.out.println("\nFamily List:\n");
        for ( int i = 0 ; i < lFamily.size() ; i++){
        	Family family = lFamily.get(i);
        	System.out.println(
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

}
