package gedcom;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class BeanProducer {
    
    public static void processGedcomData(ArrayList<String>  validatedGedcomLines
                                         ,List<Person> personList 
                                         ,List<Family> familyList) throws Exception {

        filterPersonInfo(validatedGedcomLines,personList);
        filterFamilyInfo(validatedGedcomLines,familyList);
        
        //for testing output
        System.out.println("Number of families: " + familyList.size());
        System.out.println("Number of persons: " + personList.size());        
        printPersonBeanListToFile(personList);
        printFamilyBeanListToFile(familyList);
                   
    }

    public static void filterFamilyInfo(ArrayList<String>  validatedGedcomLines, List<Family> familyList ){

        for (int i = 0; i < validatedGedcomLines.size(); i++) {
            String [] gedcomlinearray;
            gedcomlinearray = validatedGedcomLines.get(i).split(" ");

            //detect family
            if (isFamilyTag(gedcomlinearray)){
                ArrayList<String> gedcomfamilyarraylist = new ArrayList<String>();
                gedcomfamilyarraylist.add(validatedGedcomLines.get(i));
                i = i + 1;
                gedcomlinearray = validatedGedcomLines.get(i).split(" ");
                while( !isPersonTag(gedcomlinearray) && !isFamilyTag(gedcomlinearray) && (i < validatedGedcomLines.size() && !isEndOfGedcomFile(gedcomlinearray))){
                    gedcomfamilyarraylist.add(validatedGedcomLines.get(i));
                    i = i + 1;
                    gedcomlinearray = validatedGedcomLines.get(i).split(" ");
                }
                createFamilyBean(gedcomfamilyarraylist, familyList);
                i = i -1;
            }
        }
    }

    
    public static void filterPersonInfo(ArrayList<String>  validatedGedcomLines, List<Person> personList ){

        for (int i = 0; i < validatedGedcomLines.size(); i++) {
            String [] gedcomlinearray;
            gedcomlinearray = validatedGedcomLines.get(i).split(" ");
            
            //detect person
            if (isPersonTag(gedcomlinearray)){
                ArrayList<String> gedcompersonarraylist = new ArrayList<String>();
                gedcompersonarraylist.add(validatedGedcomLines.get(i));
                i = i + 1;
                gedcomlinearray = validatedGedcomLines.get(i).split(" ");
                while( !isPersonTag(gedcomlinearray) && !isFamilyTag(gedcomlinearray) && (i < validatedGedcomLines.size() && !isEndOfGedcomFile(gedcomlinearray))){
                    gedcompersonarraylist.add(validatedGedcomLines.get(i));
                    i = i + 1;
                    gedcomlinearray = validatedGedcomLines.get(i).split(" ");
                }
                createPersonBean(gedcompersonarraylist, personList);
                i = i -1;
            }
        } 
    }
    
    public static boolean isPersonTag(String[] gedcomlinearray){
        return ( (gedcomlinearray[1].charAt(0) == '@') && (gedcomlinearray[1].charAt(1) == 'I') );
    }
    
    public static boolean isFamilyTag(String[] gedcomlinearray){
        return ( (gedcomlinearray[1].charAt(0) == '@') && (gedcomlinearray[1].charAt(1) == 'F') );
    }
    public static boolean isEndOfGedcomFile(String[] gedcomlinearray){
        return ( gedcomlinearray[1].equals("TRLR") );
    }    
        
    public static void createPersonBean(ArrayList personarraylist, List<Person> personList){
        Person person = new Person();
        //set person id
        person.setIndi(personarraylist.get(0).toString().split(" ")[1]);
        //set other properties
        for(int i = 0; i < personarraylist.size(); i++){
            String[] personlinearray = personarraylist.get(i).toString().split(" ");
            switch (personlinearray[1]) {              
                case "NAME":        person.setName(personlinearray[2] + " "+ personlinearray[3].replace("/", ""));
                         break;
                case "SEX":         person.setSex(personlinearray[2]);
                         break;
                case "BIRT":        person.setBirt(personarraylist.get(i+1).toString().split(" ")[2] + " " + personarraylist.get(i+1).toString().split(" ")[3] +" "+personarraylist.get(i+1).toString().split(" ")[4] );
                         break;
                case "DEATHDATE":   person.setBirt(personarraylist.get(i+1).toString().split(" ")[2] + " " + personarraylist.get(i+1).toString().split(" ")[3] +" "+personarraylist.get(i+1).toString().split(" ")[4] );
                         break;
                case "FAMS":        person.setFams(personlinearray[2]);
                         break;
                case "FAMC":        person.setFamc(personlinearray[2]);
                         break;    
                default: break;
            }; 
        }
        personList.add(person);
    }
    
    public static void createFamilyBean(ArrayList familyarraylist, List<Family> familyList){
        Family family = new Family();
        //set family id
        family.setIdentifier(familyarraylist.get(0).toString().split(" ")[1]);
        //set other properties
        for(int i = 0; i < familyarraylist.size(); i++){
            String[] familylinearray = familyarraylist.get(i).toString().split(" ");
            switch (familylinearray[1]) {
                case "HUSB":        family.setHusb(familylinearray[2]);
                         break;
                case "WIFE":        family.setWife(familylinearray[2]);
                         break;
                case "CHIL":        family.setChil(familylinearray[2]);
                         break;
                case "DIV":         family.setDiv(familyarraylist.get(i+1).toString().split(" ")[2] + " " + familyarraylist.get(i+1).toString().split(" ")[3] +" "+familyarraylist.get(i+1).toString().split(" ")[4]);
                         break;
                case "MARR":        family.setMarr(familyarraylist.get(i+1).toString().split(" ")[2] + " " + familyarraylist.get(i+1).toString().split(" ")[3] +" "+familyarraylist.get(i+1).toString().split(" ")[4]);
                         break;   
                default: break;
            }; 
        }
        familyList.add(family);
    }
    
    
    private static void printPersonBeanListToFile(List<Person> lPerson) {
        // DEVELOPMENT AID ONLY
        // not finished
        Writer BeanWriter = null;
        String BeanOutFileName = "/Users/michaelcasey/Google Drive/Code/netbeans_projects/gedcom/src/gedcom/personbeans.txt";

        try{
            File beanfile = new File(BeanOutFileName);
            BeanWriter = new BufferedWriter(new FileWriter(beanfile));
            BeanWriter.write("Person Bean Data");
            BeanWriter.write("\r\n\r\n");

            int sz = lPerson.size();
            if (sz > 0){
                for ( int i = 0 ; i < sz ; i++){
                    BeanWriter.write("Person " + i +  
                            " ; " + lPerson.get(i).getIndi() + 
                            " ; " + lPerson.get(i).getName() + 
                            " ; " + lPerson.get(i).getSex() + 
                            " ; " + lPerson.get(i).getBirt() + 
                            " ; " + lPerson.get(i).getDeat() + 
                            " ; " + lPerson.get(i).getFamc() + 
                            " ; " + lPerson.get(i).getFams() + 
                            "");
                    BeanWriter.write("\r\n");
                }
            }

        }  // end of main try block
        catch(Exception e){
                System.out.println("printPersonBeanListToFile problem");
                e.printStackTrace();
        }
        finally {
            try {
                if (BeanWriter != null) {
                    BeanWriter.close();
                }
            } catch (IOException e) {
                System.out.println("printPersonBeanListToFile writer close problem");
                e.printStackTrace();
            }
        }
    }
    
    private static void printFamilyBeanListToFile(List<Family> lFamily) {
        // DEVELOPMENT AID ONLY
        // not finished
        Writer BeanWriter = null;
        String BeanOutFileName = "/Users/michaelcasey/Google Drive/Code/netbeans_projects/gedcom/src/gedcom/familybeans.txt";

        try{
            File beanfile = new File(BeanOutFileName);
            BeanWriter = new BufferedWriter(new FileWriter(beanfile));
            BeanWriter.write("Family Bean Data");
            BeanWriter.write("\r\n\r\n");

            int sz = lFamily.size();
            if (sz > 0){
                for ( int i = 0 ; i < sz ; i++){
                    BeanWriter.write("Family " + i +  
                            " ; " + lFamily.get(i).getIdentifier() + 
                            " ; " + lFamily.get(i).getHusb() + 
                            " ; " + lFamily.get(i).getWife() + 
                            " ; " + lFamily.get(i).getMarr() + 
                            " ; " + lFamily.get(i).getDiv() +
                            " ; " + lFamily.get(i).printAllChildren() +
                            "");
                    BeanWriter.write("\r\n");
                }
            }

        }  // end of main try block
        catch(Exception e){
                System.out.println("printFamilyBeanListToFile problem");
                e.printStackTrace();
        }
        finally {
            try {
                if (BeanWriter != null) {
                    BeanWriter.close();
                }
            } catch (IOException e) {
                System.out.println("printFamilyBeanListToFile writer close problem");
                e.printStackTrace();
            }
        }
    }    
    
}
