package model;

public class Lecturer {
	
	//Field(s)
	
	private String name;
	private String surname;
	private AcademicTitle title;
	
	
	//Constructor(s)
	
	public Lecturer(String lecName, String lecSurname, AcademicTitle title) {
		this.name = lecName;
		this.surname = lecSurname;
		this.title = title;
	}
	
	
	//Getter(s) and Setter(s)
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
	public String getFullname() {
		return name + " " + surname;
	}

	public AcademicTitle getTitle() {
		return title;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setTitle(AcademicTitle title) {
		this.title = title;
	}
	
	
	/**
	 * Overridden method equals() to identify object with exactly same properties
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Lecturer) {
			Lecturer lec = (Lecturer) obj;
			if (this.name.equalsIgnoreCase(lec.name) && this.surname.equalsIgnoreCase(lec.surname)
					&& this.title == lec.title) {
				return true;
			}
		}
		return false;
	}
	

}
