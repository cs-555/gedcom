/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gedcom;
import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;
/**
 *
 * @author michaelcasey
 */
public class DeathBeforeBirth {
    
    public static ArrayList getDeathBeforeBirthErrors(List<Person> lperson){
        
        ArrayList<Person> bdateAfterDeathErrorsList = new ArrayList<Person>();
        for(int i = 0; i < lperson.size(); i++ ){
            
           if ( !lperson.get(i).getBirt().equals("") && !lperson.get(i).getDeat().equals("") ){
               
                //get birthdate
                GregorianCalendar bdateFull = formatBirthdate(lperson.get(i).getBirt());
                //get deathdate
                GregorianCalendar deathDateFull = formatDeathdate(lperson.get(i).getDeat());
                //check birth after death
                if (isBirthAfterDeath(bdateFull, deathDateFull) ){
                    bdateAfterDeathErrorsList.add(lperson.get(i));
                }               
           }
        }        
        return bdateAfterDeathErrorsList;
    }
    
    public static boolean isBirthAfterDeath(GregorianCalendar birthDate,GregorianCalendar deathDate ){
        return birthDate.after(deathDate);
    };
    
    public static GregorianCalendar formatBirthdate(String lpersonBirthdate ){
        String[] personBdateArray = lpersonBirthdate.split(" ");
        Integer bdateDay = Integer.parseInt( personBdateArray[0] );
        Integer bdateMonth = getMonthInteger( personBdateArray[1] );
        Integer bdateYear = Integer.parseInt( personBdateArray[2] );
        GregorianCalendar bdateFull = new GregorianCalendar(bdateYear,bdateMonth,bdateDay);
        return bdateFull;
    }
    
    public static GregorianCalendar formatDeathdate(String lpersonDeathDate ){
        String[] personDeathDateArray = lpersonDeathDate.split(" ");
        Integer deathDay = Integer.parseInt( personDeathDateArray[0] );
        Integer deathMonth = getMonthInteger( personDeathDateArray[1] );
        Integer deathYear = Integer.parseInt( personDeathDateArray[2] );
        GregorianCalendar deathDateFull = new GregorianCalendar(deathYear,deathMonth,deathDay);         
        return deathDateFull;   
    }

    public static Integer getMonthInteger(String month) {
        
            Integer monthInt = 0;
            switch (month.toUpperCase()) {              
                case "JAN": monthInt = 0;
                            break;
                case "FEB": monthInt = 1;
                            break;
                case "MAR": monthInt = 2;
                            break;
                case "APR": monthInt = 3;
                            break;
                case "MAY": monthInt = 4;
                            break;
                case "JUN": monthInt = 5;
                            break;
                case "JUL": monthInt = 6;
                            break;
                case "AUG": monthInt = 7;
                            break;
                case "SEP": monthInt = 8;
                            break;
                case "OCT": monthInt = 9;
                            break;
                case "NOV": monthInt = 10;
                            break;
                case "DEC": monthInt = 11;
                            break;                     
                default:    monthInt = 12;
                            break;
            };
            return monthInt;
    }
    

};
