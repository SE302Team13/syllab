package model;

import java.io.Serializable;
import java.util.ArrayList;
import com.x5.util.AccessAsBean;

public class WeeklySubject implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3741171606080277065L;

	//Field(s)
	
	/**
	 * Shows the week number. Cannot be changed.
	 */
	private int week;
	
	/**
	 * Week description for that week.
	 */
	private String description;
	
	/**
	 * Related Material for the week subject.
	 */
	private String relatedMaterial;
	
	//Constructor(s)
	
	/**
	 * General constructor for {@link WeeklySubject} class. <b>Do not</b> use this constructor.
	 * To get the default {@link WeeklySubject} set
	 * for a course use {@link #createDefaultSemester()} method. 
	 * 
	 * It's given for further development and should not to be used without proper control of
	 * the input values.
	 * Uncontrolled use of this constructor may <b>violate</b> the consistency of the program.
	 * @param week Week number
	 * @param description Description of the week.
	 * @param relatedMaterial Related material for the week.
	 */
	public WeeklySubject (int week, String description, String relatedMaterial) {
		this.week = week;
		this.description = description;
		this.relatedMaterial = relatedMaterial;
	}

	
	//Method(s) 
	
	/**
	 * Combined method for setDescription() and setRelatedMaterial(). It updates the subject
	 * with new values.
	 * @param description New description for the {@code WeeklySubject}.
	 * @param rm New related material for the {@code WeeklySubject}.
	 * @return {@code true} if the change is valid to be applied and change is applied,
	 * return false {@code false} if the change is not valid to be applied. 
	 */
	public boolean updateSubject(String description, String rm) {
		if ((description == null) || description.isBlank()) {
			return false;
		}
		if ((rm == null)) {
			rm = "Not Given";
		}
		this.description = description;
		this.relatedMaterial = rm;
		return true;
	}
	
	/**
	 * Create a semester schedule with 16 weeks. Default option.
	 * This method will be used to create a default {@link Course} object.
	 * @return Returns an <b>ArrayList</b> containing default 16 weeks.
	 */
	public static ArrayList<WeeklySubject> createDefaultSemester() {
		ArrayList<WeeklySubject> defaultSemester = new ArrayList<>();
		for (int i = 0; i < 16; i++) {
			defaultSemester.add(new WeeklySubject(i+1, "Default", "Not Given"));
		}
		return defaultSemester;
	}
	
	/**
	 * Create a semester schedule with custom number of weeks.
	 * @param weekNumber Number of weeks you want in your schedule.
	 * @return Returns an <b>ArrayList</b> containing {@code weekNumber} weeks.
	 */
	public static ArrayList<WeeklySubject> createCustomSemester(int weekNumber) {
		ArrayList<WeeklySubject> semester = new ArrayList<>();
		for (int i = 0; i < weekNumber; i++) {
			semester.add(new WeeklySubject(i+1, "Default", "Not Given"));
		}
		return semester;
	}

	
	
	//Getter(s)
	/**
	 * Returns the week of the subject.
	 * @return Week order of the week.
	 */
	public int getWeek() {
		return week;
	}
	
	
	/**
	 * Return the description for a {@code WeeklySubject} object.
	 * @return Description of the week.
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * Return the related material for a {@code WeeklySubject} object.
	 * @return Related Material of the week.
	 */
	public String getRelatedMaterial() {
		return relatedMaterial;
	}
	
	
	//Setter(s)
	public void setDescription(String description) {
		this.description = description;
	}


	public void setRelatedMaterial(String relatedMaterial) {
		this.relatedMaterial = relatedMaterial;
	}
	

	
	
	
}
