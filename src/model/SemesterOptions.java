package model;

public enum SemesterOptions {

	FALL, SPRING, BOTH;

	@Override
	public String toString() {
		String[] arr = this.name().split("_");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			builder.append(arr[i].substring(0, 1).concat(arr[i].substring(1).toLowerCase().replaceAll("ý", "i")));
			if (i != arr.length - 1) {
				builder.append(" ");
			}
		}
		return builder.toString();
	}
}
