package jsonModel;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkloadTable implements Serializable {

	@SerializedName("attendance")
	@Expose
	private Attendance_ attendance;
	@SerializedName("lab")
	@Expose
	private Lab_ lab;
	@SerializedName("out_hour")
	@Expose
	private OutHour outHour;
	@SerializedName("fieldwork")
	@Expose
	private Fieldwork_ fieldwork;
	@SerializedName("quiz")
	@Expose
	private Quiz_ quiz;
	@SerializedName("homework")
	@Expose
	private Homework_ homework;
	@SerializedName("presentation")
	@Expose
	private Presentation_ presentation;
	@SerializedName("project")
	@Expose
	private Project_ project;
	@SerializedName("seminar")
	@Expose
	private Seminar_ seminar;
	@SerializedName("oral_exam")
	@Expose
	private OralExam oralExam;
	@SerializedName("midterm")
	@Expose
	private Midterm_ midterm;
	@SerializedName("final")
	@Expose
	private Final_ _final;
	private final static long serialVersionUID = -7099133574330773753L;

	public Attendance_ getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance_ attendance) {
		this.attendance = attendance;
	}

	public Lab_ getLab() {
		return lab;
	}

	public void setLab(Lab_ lab) {
		this.lab = lab;
	}

	public OutHour getOutHour() {
		return outHour;
	}

	public void setOutHour(OutHour outHour) {
		this.outHour = outHour;
	}

	public Fieldwork_ getFieldwork() {
		return fieldwork;
	}

	public void setFieldwork(Fieldwork_ fieldwork) {
		this.fieldwork = fieldwork;
	}

	public Quiz_ getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz_ quiz) {
		this.quiz = quiz;
	}

	public Homework_ getHomework() {
		return homework;
	}

	public void setHomework(Homework_ homework) {
		this.homework = homework;
	}

	public Presentation_ getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation_ presentation) {
		this.presentation = presentation;
	}

	public Project_ getProject() {
		return project;
	}

	public void setProject(Project_ project) {
		this.project = project;
	}

	public Seminar_ getSeminar() {
		return seminar;
	}

	public void setSeminar(Seminar_ seminar) {
		this.seminar = seminar;
	}

	public OralExam getOralExam() {
		return oralExam;
	}

	public void setOralExam(OralExam oralExam) {
		this.oralExam = oralExam;
	}

	public Midterm_ getMidterm() {
		return midterm;
	}

	public void setMidterm(Midterm_ midterm) {
		this.midterm = midterm;
	}

	public Final_ getFinal() {
		return _final;
	}

	public void setFinal(Final_ _final) {
		this._final = _final;
	}

}