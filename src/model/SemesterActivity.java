package model;

public class SemesterActivity {
	
	private String activityName;
	private int number;
	private int duration;
	private int workload;

	public SemesterActivity(String actName, int number, int duration) {
		this.activityName = actName;
		this.number = number;
		this.duration = duration;
		this.workload = duration * number;
	}
	
	//Method(s)
	
	public void recalculateWorkload() {
		workload = duration * number;
	}

	
	//Getter(s) and Setter(s)
	
	public String getActivityName() {
		return activityName;
	}


	public int getNumber() {
		return number;
	}


	public int getDuration() {
		return duration;
	}


	public int getWorkload() {
		return workload;
	}


	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}


	public boolean setNumber(int number) {
		if (number >= 0) {
			this.number = number;
			recalculateWorkload();
			return true;
		}
		return false;
	}


	public boolean setDuration(int duration) {
		if (duration > 0) {
			this.duration = duration;
			recalculateWorkload();
			return true;
		}
		return false;
	}
	

	
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SemesterActivity) {
			SemesterActivity activity = (SemesterActivity) obj;
			if (this.activityName.equalsIgnoreCase(activity.activityName)) {
				return true;
			}
		}
		return false;
	}
	
	
}
