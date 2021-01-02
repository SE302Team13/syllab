package model;

public class Lecturer {
	
	//Field(s)
	
	/**
	 * Name of the lecturer.
	 */
	private String name;
	/**
	 * Surname of the lecturer.
	 */
	private String surname;
	/**
	 * {@link AcademicTitle} for a lecturer.
	 */
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

	public boolean setName(String name) {
		if ((name != null) && (name.isBlank())) {
			this.name = name;
			return true;
		}
		return false;
	}

	public boolean setSurname(String surname) {
		if ((surname != null) && (surname.isBlank())) {
			this.surname = surname;
			return true;
		}
		return false;
	}
	
	public boolean setTitle(AcademicTitle title) {
		if (title != null) {
			this.title = title;
			return true;
		}
		return false;
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
