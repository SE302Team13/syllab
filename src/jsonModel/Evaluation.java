package jsonModel;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Evaluation implements Serializable {

	@SerializedName("attendance")
	@Expose
	private Attendance attendance;
	@SerializedName("lab")
	@Expose
	private Lab lab;
	@SerializedName("fieldwork")
	@Expose
	private Fieldwork fieldwork;
	@SerializedName("quiz")
	@Expose
	private Quiz quiz;
	@SerializedName("homework")
	@Expose
	private Homework homework;
	@SerializedName("presentation")
	@Expose
	private Presentation presentation;
	@SerializedName("project")
	@Expose
	private Project project;
	@SerializedName("seminar")
	@Expose
	private Seminar seminar;
	@SerializedName("portfolios")
	@Expose
	private Portfolios portfolios;
	@SerializedName("midterm")
	@Expose
	private Midterm midterm;
	@SerializedName("final")
	@Expose
	private Final _final;
	private final static long serialVersionUID = 3849305757253064172L;

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public Lab getLab() {
		return lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}

	public Fieldwork getFieldwork() {
		return fieldwork;
	}

	public void setFieldwork(Fieldwork fieldwork) {
		this.fieldwork = fieldwork;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Homework getHomework() {
		return homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Seminar getSeminar() {
		return seminar;
	}

	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}

	public Portfolios getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(Portfolios portfolios) {
		this.portfolios = portfolios;
	}

	public Midterm getMidterm() {
		return midterm;
	}

	public void setMidterm(Midterm midterm) {
		this.midterm = midterm;
	}

	public Final getFinal() {
		return _final;
	}

	public void setFinal(Final _final) {
		this._final = _final;
	}
}
