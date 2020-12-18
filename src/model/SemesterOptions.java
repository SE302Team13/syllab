package model;

public enum SemesterOptions {
	
	FALL,
	SPRING,
	BOTH;
	
	@Override
	public String toString() {
		return this.name().substring(0,1).concat(
				this.name().substring(1).toLowerCase()
				.replaceAll("ý", "i")
				.replaceAll("_", " "));
	}
}
