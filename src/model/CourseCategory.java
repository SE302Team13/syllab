package model;

public enum CourseCategory {

	CORE_COURSE, MAJOR_AREA_COURSE, SUPPORTIVE_COURSE, COM_AND_MAN_COURSE, TRANS_SKILL_COURSE;

	@Override
	public String toString() {
		if (this == CourseCategory.COM_AND_MAN_COURSE) {
			return "Communication and Management Skills Course";
		} else if (this == CourseCategory.TRANS_SKILL_COURSE) {
			return "Transferable Skill Course";
		} else {
			String[] arr = this.name().split("_");
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				builder.append(arr[i].substring(0, 1).concat(arr[i].substring(1).toLowerCase().replaceAll("�", "i")));
				if (i != arr.length - 1) {
					builder.append(" ");
				}
			}
			return builder.toString();
		}
	}
}
