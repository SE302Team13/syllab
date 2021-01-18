package model;

import java.io.Serializable;

public class SemesterActivity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4684404325720795798L;

	/**
	 * Name of the Semester Activity.
	 */
	private String activityName;
	/**
	 * Number of the occurrence of the activity in one semester.
	 */
	private int number;
	/**
	 * Expected duration for one occurrence of the activity.
	 */
	private int duration;
	/**
	 * Total workload of the activity in hour(s) for one semester.
	 */
	private int workload;

	/**
	 * Constructor does not contain any validation. Arguments should be validated
	 * <b>before</b> passed to this constructor.
	 * 
	 * @param actName  Name of the Semester Activity.
	 * @param number   Number of the occurrence of the activity in one semester.
	 * @param duration Expected duration for one occurrence of the activity.
	 */
	public SemesterActivity(String actName, int number, int duration) {
		this.activityName = actName;
		this.number = number;
		this.duration = duration;
		this.workload = duration * number;
	}

	// Method(s)

	public void recalculateWorkload() {
		workload = duration * number;
	}

	// Getter(s) and Setter(s)

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

	public boolean setActivityName(String activityName) {
		if ((activityName != null) && !(activityName.isBlank())) {
			this.activityName = activityName;
			return true;
		}
		return false;
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
