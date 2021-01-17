package jsonModel;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categories implements Serializable {

	@SerializedName("core_course")
	@Expose
	private Boolean coreCourse;
	@SerializedName("major_area")
	@Expose
	private Boolean majorArea;
	@SerializedName("supportive_courses")
	@Expose
	private Boolean supportiveCourses;
	@SerializedName("media_man_skills")
	@Expose
	private Boolean mediaManSkills;
	@SerializedName("trans_skills")
	@Expose
	private Boolean transSkills;
	private final static long serialVersionUID = -8310938181088344889L;

	public Boolean getCoreCourse() {
		return coreCourse;
	}

	public void setCoreCourse(Boolean coreCourse) {
		this.coreCourse = coreCourse;
	}

	public Boolean getMajorArea() {
		return majorArea;
	}

	public void setMajorArea(Boolean majorArea) {
		this.majorArea = majorArea;
	}

	public Boolean getSupportiveCourses() {
		return supportiveCourses;
	}

	public void setSupportiveCourses(Boolean supportiveCourses) {
		this.supportiveCourses = supportiveCourses;
	}

	public Boolean getMediaManSkills() {
		return mediaManSkills;
	}

	public void setMediaManSkills(Boolean mediaManSkills) {
		this.mediaManSkills = mediaManSkills;
	}

	public Boolean getTransSkills() {
		return transSkills;
	}

	public void setTransSkills(Boolean transSkills) {
		this.transSkills = transSkills;
	}

}
