/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gedcom;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author michaelcasey
 */
public class Polygamy {
            
    public static ArrayList getPolygamy(List<Family> lFamily){
        ArrayList<String> polygamyList = new ArrayList<String>();
        Family familyNode, otherFamilyNode;
        String husb, wife, husb2, wife2;         
        for ( int i = 0 ; i < lFamily.size() ; i++){
            familyNode = lFamily.get(i);
            husb = familyNode.getHusb();
            wife = familyNode.getWife();
            polygamyList = checkOtherFamilies(lFamily, i, wife, husb, polygamyList);          
        }
        return polygamyList;
    }
    
    public static ArrayList checkOtherFamilies(List<Family> lFamily, int currentFamilyNumber, String wife, String husb, ArrayList polygamyList){
        for ( int j = 0 ; j < lFamily.size() ; j++){
            if (currentFamilyNumber != j){
                Family otherFamilyNode;
                String husb2, wife2;   
                otherFamilyNode = lFamily.get(j);
                husb2 = otherFamilyNode.getHusb();
                wife2 = otherFamilyNode.getWife();
                if ( husb.equals(husb2) ){
                    if (!polygamyList.contains(husb)){
                        polygamyList.add(husb);
                    }
                } 
                if ( wife.equals(wife2) ){
                    if (!polygamyList.contains(wife)){
                        polygamyList.add(wife);
                    }
                }
            }
        }         
        return polygamyList;
    }
        
};
