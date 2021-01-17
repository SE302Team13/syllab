package jsonModel;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONParser implements Serializable {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("code")
	@Expose
	private String code;
	@SerializedName("semester")
	@Expose
	private Integer semester;
	@SerializedName("weekly_hours")
	@Expose
	private String weeklyHours;
	@SerializedName("app_hours")
	@Expose
	private String appHours;
	@SerializedName("ieu_credit")
	@Expose
	private String ieuCredit;
	@SerializedName("ects_credit")
	@Expose
	private String ectsCredit;
	@SerializedName("pre_req")
	@Expose
	private String preReq;
	@SerializedName("course_lang")
	@Expose
	private String courseLang;
	@SerializedName("course_type")
	@Expose
	private String courseType;
	@SerializedName("level")
	@Expose
	private String level;
	@SerializedName("lecturers")
	@Expose
	private List<String> lecturers = null;
	@SerializedName("assistants")
	@Expose
	private List<String> assistants = null;
	@SerializedName("coordinators")
	@Expose
	private List<String> coordinators = null;
	@SerializedName("categories")
	@Expose
	private Categories categories;
	@SerializedName("weekly_subjects")
	@Expose
	private List<WeeklySubject> weeklySubjects = null;
	@SerializedName("evaluation")
	@Expose
	private Evaluation evaluation;
	@SerializedName("workload_table")
	@Expose
	private WorkloadTable workloadTable;
	private final static long serialVersionUID = -425109557383564252L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public String getWeeklyHours() {
		return weeklyHours;
	}

	public void setWeeklyHours(String weeklyHours) {
		this.weeklyHours = weeklyHours;
	}

	public String getAppHours() {
		return appHours;
	}

	public void setAppHours(String appHours) {
		this.appHours = appHours;
	}

	public String getIeuCredit() {
		return ieuCredit;
	}

	public void setIeuCredit(String ieuCredit) {
		this.ieuCredit = ieuCredit;
	}

	public String getEctsCredit() {
		return ectsCredit;
	}

	public void setEctsCredit(String ectsCredit) {
		this.ectsCredit = ectsCredit;
	}

	public String getPreReq() {
		return preReq;
	}

	public void setPreReq(String preReq) {
		this.preReq = preReq;
	}

	public String getCourseLang() {
		return courseLang;
	}

	public void setCourseLang(String courseLang) {
		this.courseLang = courseLang;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<String> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<String> lecturers) {
		this.lecturers = lecturers;
	}

	public List<String> getAssistants() {
		return assistants;
	}

	public void setAssistants(List<String> assistants) {
		this.assistants = assistants;
	}

	public List<String> getCoordinators() {
		return coordinators;
	}

	public void setCoordinators(List<String> coordinators) {
		this.coordinators = coordinators;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public List<WeeklySubject> getWeeklySubjects() {
		return weeklySubjects;
	}

	public void setWeeklySubjects(List<WeeklySubject> weeklySubjects) {
		this.weeklySubjects = weeklySubjects;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public WorkloadTable getWorkloadTable() {
		return workloadTable;
	}

	public void setWorkloadTable(WorkloadTable workloadTable) {
		this.workloadTable = workloadTable;
	}

}
