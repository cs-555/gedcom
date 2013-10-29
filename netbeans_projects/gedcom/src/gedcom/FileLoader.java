package gedcom;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import static gedcom.OutputDisplayer.pout;
import static gedcom.OutputDisplayer.poutln;

public class FileLoader {
    /** @author Alan unless otherwise noted */
    
    static HashMap<String, String> hValidTags = new HashMap<String, String>();

    static public void loadValidDataToArray(String GedcomFilename, ArrayList<String>  GedcomLines) {

        populateValidTags(hValidTags);
        File file = new File(GedcomFilename);
        BufferedReader reader = null;
        int NumOfErrors = 0;
        
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (LineOK(line)) {
                    GedcomLines.add(line);
                } else {
                    NumOfErrors++;
                }
            }
            if (NumOfErrors > 0) {
                poutln("\r\n" + NumOfErrors + " FILE ERRORS LISTED ABOVE" + "\r\n");
                //System.console().writer().println("\r\n" + NumOfErrors + " FILE ERRORS LISTED ABOVE" + "\r\n");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) { //if reader != null then it is still open
                    reader.close(); 
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean LineOK(String text) {
        String [] fields;
        String tagname = "";
        boolean TestResult = true;
        String ErrorMsg;

        fields = text.split(" ");
        ErrorMsg = "";
        if (!isASCII(text)) {
            ErrorMsg += " <non-ASCII characters encountered>";
            TestResult = false;
        } else {

            for (int fieldnum = 0; fieldnum < fields.length; fieldnum++) {
                switch (fieldnum) {
                    case 0: // 1st field
                        if (!((fields[0].equals("0"))||(fields[0].equals("1"))||(fields[0].equals("2")))) {
                            ErrorMsg += " <line must begin with 0-2>";
                            TestResult = false;
                        }
                        if (fields[0].equals("0")){
                            if (((fields[1].startsWith("@")) && fields[2].equals("INDI")) ||
                                ((fields[1].startsWith("@")) && fields[2].equals("FAM"))){ // it's OK
                            } else {
                                if ((fields[1].equals("TRLR")) || (fields[1].equals("NOTE"))) { // it's OK
                                } else {
                                    // COMMENTING OUT THE NEXT LINE IS A GOOD TEST TO SHOW THE REFACTORING TEST WORKS FOR ONLY THE FAMILY OUTPUT FILE
                                    ErrorMsg += " <0 records w/ ID's must be INDI, FAM, TRLR or NOTE>";
                                    TestResult = false;
                                }
                            }
                        }
                        if (fields[0].equals("2") && !fields[1].equals("DATE")){
                            ErrorMsg += " <Level 2 records must DATE>";
                            TestResult = false;
                        }
                        break;
                    case 1: // 2nd field
                        if (((fields[1].startsWith("@")) && fields[2].equals("INDI")) ||
                            ((fields[1].startsWith("@")) && fields[2].equals("FAM"))){ // it's OK
                        } else {
                            tagname = hValidTags.get(fields[1]);
                            if (tagname == null) {
                                ErrorMsg += " <invalid tag>";
                                TestResult = false; 
                            }
                        }
                        if ((fields[1].equals("DATE")) && !(fields[0].equals("2"))) {
                            ErrorMsg += " <DATE records must be level 2>";
                            TestResult = false;
                        }
                        if ((fields[1].equals("NOTE")) && !(fields[0].equals("0"))) {
                            ErrorMsg += " <NOTE records must be level 0>";
                            TestResult = false;
                        }
                        break;
                    default: // no other fields are being checked at this time
                } // end of switch based on the fields
            } // end of for loop that checks the fields
            if (ErrorMsg.length() > 0 ) {
                poutln(text + ErrorMsg);
            }
        } // end of if ASCII check
        
        return(TestResult);
    }
    
    private static boolean isASCII(String text) {
        CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder();
        return asciiEncoder.canEncode(text);
    }
    
    static final void populateValidTags(HashMap<String, String> hm){		
    /** @author Ronny */

        hm.put("INDI", "INDI");
        hm.put("NAME", "NAME");
        hm.put("SEX", "SEX");
        hm.put("BIRT", "BIRT");
        hm.put("DEAT", "DEAT");
        hm.put("FAMC", "FAMC");
        hm.put("FAMS", "FAMS");
        hm.put("FAM", "FAM");
        hm.put("MARR", "MARR");
        hm.put("HUSB", "HUSB");
        hm.put("WIFE", "WIFE");
        hm.put("CHIL", "CHIL");
        hm.put("DIV", "DIV");
        //hm.put("_CURRENT", "_CURRENT");
        hm.put("DATE", "DATE");
        hm.put("TRLR", "TRLR");
        hm.put("NOTE", "NOTE");
    }

}
