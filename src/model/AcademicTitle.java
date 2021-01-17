package model;

public enum AcademicTitle {

	RESEARCH_ASSISTANT,
	TEACHING_ASSISTANT,
	INSTRUCTOR,
	LECTURER,
	ASSISTANT_PROFESSOR,
	ASSOCIATE_PROFESSOR,
	FULL_PROFESSOR;
	
	
	
	@Override
	public String toString() {
		String[] arr = this.name().split("_");
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			builder.append(arr[i].substring(0,1).concat(
					arr[i].substring(1).toLowerCase()
					.replaceAll("ý", "i")));
			if (i != arr.length-1) {
				builder.append(" ");
			}
		}
		return builder.toString();
	}
	
	
	public static String[] getTitles() {
		AcademicTitle[] titles = values();
		String[] stringTitles = new String[titles.length];
		for (int i = 0; i < titles.length; i++) {
			stringTitles[i] = titles[i].toString();
		}
		return stringTitles;
	}
	
	public static String tryParse(String academicTitle) {
		for (String validTitle : getTitles()) {
			if (validTitle.equalsIgnoreCase(academicTitle)) {
				return academicTitle;
			}
		}
		return null;
	}
}
