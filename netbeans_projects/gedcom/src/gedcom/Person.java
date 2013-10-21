package gedcom;
 
public class Person {

	private String identifier = "";
	private String idType = "";
	private String indi="";
	private String name="";
	private String sex="";
	private String birt="";
	private String deat="";
	private String famc="";
	private String fams="";
	private String trlr="";
	private String note="";
	
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getIndi() {
		return indi;
	}
	public void setIndi(String indi) {
		this.indi = indi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirt() {
		return birt;
	}
	public void setBirt(String birt) {
		this.birt = birt;
	}
	public String getDeat() {
		return deat;
	}
	public void setDeat(String deat) {
		this.deat = deat;
	}
	public String getFamc() {
		return famc;
	}
	public void setFamc(String famc) {
		this.famc = famc;
	}
	public String getFams() {
		return fams;
	}
	public void setFams(String fams) {
		this.fams = fams;
	}
	public String getTrlr() {
		return trlr;
	}
	public void setTrlr(String trlr) {
		this.trlr = trlr;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
