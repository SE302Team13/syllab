package model;

public class WeeklySubject {

	
	//Field(s)
	
	private int week;
	private String description;
	private String relatedMaterial;
	
	
	//Getter(s) and Setter(s)
	
	public int getWeek() {
		return week;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getRelatedMaterial() {
		return relatedMaterial;
	}
	
	public boolean setDescription(String desc) {
		if(!(desc.isBlank())) {
			this.description = desc;
			return true;
		}
		return false;
	}

	public boolean setRelatedMaterial(String rm) {
		if(!(rm.isBlank())) {
			this.description = rm;
			return true;
		}
		return false;
	}

}
