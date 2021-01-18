package newui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXRadioButton;

import initializer.Initializer;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import jsonModel.*;
import model.Course;
import model.CourseCategory;
import model.CourseLevel;
import model.CourseType;
import model.EvaluationCriteria;
import model.Language;
import model.SemesterActivity;
import model.SemesterOptions;
import model.WeeklySubject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.controlsfx.control.textfield.CustomTextField;

public class ImportController {
	@FXML
	private ImageView closeButton;
	@FXML
	private CustomTextField courseCode;
	@FXML
	private JFXRadioButton langEnglish;
	@FXML
	private ToggleGroup language;
	@FXML
	private JFXRadioButton langTurkish;
	@FXML
	private Button importButton;
	@FXML
	private Button cancelButton;

	public boolean validate() {
		courseCode.commitValue();
		String code = courseCode.getText();
		Pattern pattern = Pattern.compile("[A-Z a-z]{2,3}[0-9]{3}");
		Matcher matcher = pattern.matcher(code);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@FXML
	public void initialize() {
		// Close Button functionality to close the window
		closeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				closeButton.getScene().getWindow().hide();
			}

		});

		// Cancel Button functionality same with the close window button
		cancelButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				closeButton.getScene().getWindow().hide();
			}
		});

		// importButton functionality
		importButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				courseCode.commitValue();
				String codeWithoutSpace = courseCode.getText().replace(" ", "");
				String[] codes = codeWithoutSpace.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
				String newCode = "";
				if (codes.length != 1) {
					newCode = codes[0] + "+" + codes[1];
					newCode = newCode.toUpperCase();
				} else {
					newCode = codes[0].toUpperCase();
				}
					

				String langCode = langTurkish.isSelected() ? "tr" : "en";

				String syllabUrl = "https://syllab.azurewebsites.net/api/syllab?lang=" + langCode + "&code=" + newCode;
				if (validate()) {
					Course course = null;
					new Thread(new Runnable() {

						@Override
						public void run() {
							InputStreamReader reader = null;
							try {
								URL url = new URL(syllabUrl);
								reader = new InputStreamReader(url.openStream());

							} catch (IOException e) {
								Alert alertbox = new Alert(AlertType.ERROR);
								alertbox.setTitle("Invalid Course Code");
								alertbox.setHeaderText("Error");
								alertbox.setContentText("There is no course with this course code in the system."
										+ "If you are certain that this course is valid then contact with developer team.");
								alertbox.initModality(Modality.APPLICATION_MODAL);
								alertbox.initOwner(Main.generalStage);
								alertbox.showAndWait();
							}
							JSONParser parsedObj = new Gson().fromJson(reader, JSONParser.class);
							ArrayList<String> prerequisites = new ArrayList<String>();
							prerequisites.add(parsedObj.getPreReq());
							Language courseLang = parsedObj.getCourseLang().equals("English") ? Language.ENGLISH
									: Language.TURKISH;
							SemesterOptions semester = parsedObj.getSemester() == 0 ? SemesterOptions.FALL
									: (parsedObj.getSemester() == 1 ? SemesterOptions.SPRING : SemesterOptions.BOTH);
							int labHour = Integer.parseInt(parsedObj.getAppHours());
							int theoryHour = Integer.parseInt(parsedObj.getWeeklyHours());
							WorkloadTable table = parsedObj.getWorkloadTable();
							ArrayList<SemesterActivity> workloadTable = generateSemesterActivity(table);
							CourseType type = parsedObj.getCourseType() == "Required" ? CourseType.REQUIRED
									: (parsedObj.getCourseType() == "Elective" ? CourseType.ELECTIVE
											: CourseType.SERVICE);
							String courseCoordinator = parsedObj.getCoordinators().get(0);
							ArrayList<String> courseLecturers = new ArrayList<String>();
							courseLecturers.addAll(parsedObj.getLecturers());
							ArrayList<String> assistants = new ArrayList<String>();
							assistants.addAll(parsedObj.getAssistants());
							Categories categories = parsedObj.getCategories();
							CourseCategory category = CourseCategory.CORE_COURSE;
							if (categories.getMajorArea()) {
								category = CourseCategory.MAJOR_AREA_COURSE;
							} else if (categories.getMediaManSkills()) {
								category = CourseCategory.COM_AND_MAN_COURSE;
							} else if (categories.getSupportiveCourses()) {
								category = CourseCategory.SUPPORTIVE_COURSE;
							} else {
								category = CourseCategory.TRANS_SKILL_COURSE;
							}

							ArrayList<WeeklySubject> weeklySubjects = generateWeeklySubject(
									parsedObj.getWeeklySubjects());
							ArrayList<EvaluationCriteria> evaluationCriterias = generateEvaluationCriteria(
									parsedObj.getEvaluation());

							Course course = new Course(parsedObj.getName(), parsedObj.getCode(), prerequisites,
									courseLang, semester, labHour, theoryHour, workloadTable, type, courseCoordinator,
									courseLecturers, assistants, category, weeklySubjects, evaluationCriterias);

							System.out.println(course.logCourse());
						}
					}).start();
					Initializer.getCourses().add(course);

				}
				closeButton.getScene().getWindow().hide();
			}
		});

	}

	public ArrayList<SemesterActivity> generateSemesterActivity(WorkloadTable table) {
		ArrayList<SemesterActivity> workloadTable = new ArrayList<SemesterActivity>();
		Attendance_ attendance = table.getAttendance();
		Fieldwork_ fieldwork = table.getFieldwork();
		Final_ fin = table.getFinal();
		Homework_ hw = table.getHomework();
		Lab_ lab = table.getLab();
		Midterm_ midterm = table.getMidterm();
		OralExam or = table.getOralExam();
		OutHour out = table.getOutHour();
		Presentation_ pr = table.getPresentation();
		Project_ project = table.getProject();
		Quiz_ quiz = table.getQuiz();
		Seminar_ seminar = table.getSeminar();

		workloadTable.add(new SemesterActivity("Theoretical Course Hours",
				Integer.parseInt(attendance.getNo().equals("") ? "0" : attendance.getNo()),
				Integer.parseInt(attendance.getDuration().equals("") ? "0" : attendance.getDuration())));
		workloadTable.add(new SemesterActivity("Laboratory / Application Hours",
				Integer.parseInt(lab.getNo().equals("") ? "0" : lab.getNo()),
				Integer.parseInt(lab.getDuration().equals("") ? "0" : lab.getDuration())));
		workloadTable.add(new SemesterActivity("Study Hours Out of Class",
				Integer.parseInt(out.getNo().equals("") ? "0" : out.getNo()),
				Integer.parseInt(out.getDuration().equals("") ? "0" : out.getDuration())));
		workloadTable.add(new SemesterActivity("Field Work",
				Integer.parseInt(fieldwork.getNo().equals("") ? "0" : fieldwork.getNo()),
				Integer.parseInt(fieldwork.getDuration().equals("") ? "0" : fieldwork.getDuration())));
		workloadTable.add(new SemesterActivity("Quizzes / Studio Critiques",
				Integer.parseInt(quiz.getNo().equals("") ? "0" : quiz.getNo()),
				Integer.parseInt(quiz.getDuration().equals("") ? "0" : quiz.getDuration())));
		workloadTable.add(new SemesterActivity("Homework / Assignments",
				Integer.parseInt(hw.getNo().equals("") ? "0" : hw.getNo()),
				Integer.parseInt(hw.getDuration().equals("") ? "0" : hw.getDuration())));
		workloadTable.add(
				new SemesterActivity("Presentation / Jury", Integer.parseInt(pr.getNo().equals("") ? "0" : pr.getNo()),
						Integer.parseInt(pr.getDuration().equals("") ? "0" : pr.getDuration())));
		workloadTable.add(
				new SemesterActivity("Project", Integer.parseInt(project.getNo().equals("") ? "0" : project.getNo()),
						Integer.parseInt(project.getDuration().equals("") ? "0" : project.getDuration())));
		workloadTable.add(new SemesterActivity("Seminar / Workshop",
				Integer.parseInt(seminar.getNo().equals("") ? "0" : seminar.getNo()),
				Integer.parseInt(seminar.getDuration().equals("") ? "0" : seminar.getDuration())));
		workloadTable.add(new SemesterActivity("Oral Exam", Integer.parseInt(or.getNo().equals("") ? "0" : or.getNo()),
				Integer.parseInt(or.getDuration().equals("") ? "0" : or.getDuration())));
		workloadTable.add(
				new SemesterActivity("Midterms", Integer.parseInt(midterm.getNo().equals("") ? "0" : midterm.getNo()),
						Integer.parseInt(midterm.getDuration().equals("") ? "0" : midterm.getDuration())));
		workloadTable
				.add(new SemesterActivity("Final Exam", Integer.parseInt(fin.getNo().equals("") ? "0" : fin.getNo()),
						Integer.parseInt(fin.getDuration().equals("") ? "0" : fin.getDuration())));

		return workloadTable;
	}

	public ArrayList<WeeklySubject> generateWeeklySubject(List<jsonModel.WeeklySubject> list) {
		ArrayList<WeeklySubject> weeklySubject = new ArrayList<WeeklySubject>();
		int index = 1;
		for (jsonModel.WeeklySubject subject : list) {
			weeklySubject.add(new WeeklySubject(index, subject.getSubject(), subject.getReading()));
			index++;
		}
		return weeklySubject;
	}

	public ArrayList<EvaluationCriteria> generateEvaluationCriteria(Evaluation evaluation) {
		ArrayList<EvaluationCriteria> evaluationCriteria = new ArrayList<EvaluationCriteria>();

		Attendance attendance = evaluation.getAttendance();
		Fieldwork fieldwork = evaluation.getFieldwork();
		Final fin = evaluation.getFinal();
		Homework hw = evaluation.getHomework();
		Lab lab = evaluation.getLab();
		Midterm midterm = evaluation.getMidterm();
		Portfolios or = evaluation.getPortfolios();
		Presentation pr = evaluation.getPresentation();
		Project project = evaluation.getProject();
		Quiz quiz = evaluation.getQuiz();
		Seminar seminar = evaluation.getSeminar();

		evaluationCriteria.add(new EvaluationCriteria("Theoretical Course Hours",
				Integer.parseInt(attendance.getNo().equals("") ? "0" : attendance.getNo()),
				Integer.parseInt(attendance.getPer().equals("") ? "0" : attendance.getPer()),
				new ArrayList<Integer>()));
		evaluationCriteria.add(new EvaluationCriteria("Laboratory / Application Hours",
				Integer.parseInt(lab.getNo().equals("") ? "0" : lab.getNo()),
				Integer.parseInt(lab.getPer().equals("") ? "0" : lab.getPer()), new ArrayList<Integer>()));
		evaluationCriteria.add(new EvaluationCriteria("Field Work",
				Integer.parseInt(fieldwork.getNo().equals("") ? "0" : fieldwork.getNo()),
				Integer.parseInt(fieldwork.getPer().equals("") ? "0" : fieldwork.getPer()), new ArrayList<Integer>()));
		evaluationCriteria.add(new EvaluationCriteria("Quizzes / Studio Critiques",
				Integer.parseInt(quiz.getNo().equals("") ? "0" : quiz.getNo()),
				Integer.parseInt(quiz.getPer().equals("") ? "0" : quiz.getPer()), new ArrayList<Integer>()));
		evaluationCriteria.add(new EvaluationCriteria("Homework / Assignments",
				Integer.parseInt(hw.getNo().equals("") ? "0" : hw.getNo()),
				Integer.parseInt(hw.getPer().equals("") ? "0" : hw.getPer()), new ArrayList<Integer>()));
		evaluationCriteria.add(new EvaluationCriteria("Presentation / Jury",
				Integer.parseInt(pr.getNo().equals("") ? "0" : pr.getNo()),
				Integer.parseInt(pr.getPer().equals("") ? "0" : pr.getPer()), new ArrayList<Integer>()));
		evaluationCriteria.add(new EvaluationCriteria("Project",
				Integer.parseInt(project.getNo().equals("") ? "0" : project.getNo()),
				Integer.parseInt(project.getPer().equals("") ? "0" : project.getPer()), new ArrayList<Integer>()));
		evaluationCriteria.add(new EvaluationCriteria("Seminar / Workshop",
				Integer.parseInt(seminar.getNo().equals("") ? "0" : seminar.getNo()),
				Integer.parseInt(seminar.getPer().equals("") ? "0" : seminar.getPer()), new ArrayList<Integer>()));
		evaluationCriteria
				.add(new EvaluationCriteria("Oral Exam", Integer.parseInt(or.getNo().equals("") ? "0" : or.getNo()),
						Integer.parseInt(or.getPer().equals("") ? "0" : or.getPer()), new ArrayList<Integer>()));
		evaluationCriteria.add(new EvaluationCriteria("Midterms",
				Integer.parseInt(midterm.getNo().equals("") ? "0" : midterm.getNo()),
				Integer.parseInt(midterm.getPer().equals("") ? "0" : midterm.getPer()), new ArrayList<Integer>()));
		evaluationCriteria
				.add(new EvaluationCriteria("Final Exam", Integer.parseInt(fin.getNo().equals("") ? "0" : fin.getNo()),
						Integer.parseInt(fin.getPer().equals("") ? "0" : fin.getPer()), new ArrayList<Integer>()));

		return evaluationCriteria;
	}
}
