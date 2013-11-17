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
        ArrayList<Family> polygamyList = new ArrayList<Family>();
        Family familyNode, otherFamilyNode;
        String husb, wife, husb2, wife2;         
        for ( int i = 0 ; i < lFamily.size() ; i++){
            familyNode = lFamily.get(i);
            husb = familyNode.getHusb();
            wife = familyNode.getWife();
            for ( int j = 0 ; j < lFamily.size() ; j++){
                if (i != j){
                    otherFamilyNode = lFamily.get(j);
                    husb2 = otherFamilyNode.getHusb();
                    wife2 = otherFamilyNode.getWife();
                    if ( husb.equals(husb2) || wife.equals(wife2) ){
                        //System.out.println("Family1: "+familyNode.getIdentifier()+" "+ husb + " " + wife + " Family2: "+otherFamilyNode.getIdentifier()+" "+ husb2 + " " + wife2 );
                        if (!polygamyList.contains(lFamily.get(i))){
                            polygamyList.add(lFamily.get(i));
                        }
                    }
                }
            }            
        }
        return polygamyList;
    }
    
};
