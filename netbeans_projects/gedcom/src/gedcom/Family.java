package gedcom;
 
import java.util.ArrayList;

public class Family {

	private String fam="";
	private String marr="";
	private String husb="";
	private String wife="";
	private ArrayList<String> chil = new ArrayList<String>();
	private String div="";
	private String date="";
	
	
	public String getFam() {
		return fam;
	}
	public void setFam(String fam) {
		this.fam = fam;
	}
	public String getMarr() {
		return marr;
	}
	public void setMarr(String marr) {
		this.marr = marr;
	}
	public String getHusb() {
		return husb;
	}
	public void setHusb(String husb) {
		this.husb = husb;
	}
	public String getWife() {
		return wife;
	}
	public void setWife(String wife) {
		this.wife = wife;
	}
	
	public String getChil(int i) {
		return chil.get(i);
	}

	public String[] getAllChildren() {
	    return chil.toArray(new String[chil.size()]);        
	}

        public ArrayList<String> getListChil(){
            return chil;
        }
	
	public void setChil(String chil) {
		this.chil.add(chil);
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
