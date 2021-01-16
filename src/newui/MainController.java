package newui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.controlsfx.control.textfield.CustomTextField;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;

import initializer.Initializer;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;
import javafx.stage.Modality;
import model.AcademicTitle;
import model.Course;
import model.CourseCategory;
import model.CourseCompetency;
import model.CourseLevel;
import model.CourseType;
import model.EvaluationCriteria;
import model.Language;
import model.Lecturer;
import model.SemesterActivity;
import model.SemesterOptions;
import model.WeeklySubject;
import model.Export;
public class MainController {

	@FXML
	private HBox topPane;
	@FXML
	private HBox buttonToolbar;
	@FXML
	private JFXButton createSyllabus;
	@FXML
	private JFXButton addSyllabus;
	@FXML
	private JFXButton importSyllabus;
	@FXML
	private JFXButton exportSyllabus;
	@FXML
	private JFXButton deleteSyllabus;
	@FXML
	private ImageView closeButton;
	@FXML
	private ImageView minimizeButton;
	@FXML
	private ImageView helpButton;
	@FXML
	private ImageView gitHubButton;
	@FXML
	private JFXListView<Course> courseList;
	@FXML
	private JFXButton saveButton;
	@FXML
	private JFXTabPane generalTabPane;
	@FXML
	private CustomTextField courseNameField;
	@FXML
	private CustomTextField courseCodeField;
	@FXML
	private DatePicker creationDatePicker;
	@FXML
	private JFXListView<String> prerequisitesList;
	@FXML
	private VBox prerequisitesToolbar;
	@FXML
	private JFXButton addPrerequisites;
	@FXML
	private JFXButton deletePrerequisites;
	@FXML
	private JFXComboBox<Language> languageChoice;
	@FXML
	private JFXComboBox<SemesterOptions> semesterChoice;
	@FXML
	private CustomTextField theoreticalHoursField;
	@FXML
	private CustomTextField applicationHoursField;
	@FXML
	private JFXComboBox<CourseType> courseTypeChoice;
	@FXML
	private JFXComboBox<CourseLevel> courseLevelChoice;
	@FXML
	private JFXComboBox<CourseCategory> courseCategoryChoice;
	@FXML
	private TextArea courseDescriptionArea;
	@FXML
	private TextArea courseObjectiveArea;
	@FXML
	private CustomTextField mainCourseBookField;
	@FXML
	private ListView<String> suggestedReadingList;
	@FXML
	private JFXButton addReadingButton;
	@FXML
	private JFXButton deleteReadingButton;
	@FXML
	private TableView<String> learningOutcomesTable;
	@FXML
	private TableColumn<String, String> learningOutcomesTableNumberColumn;
	@FXML
	private TableColumn<String, String> learningOutcomesTableLOColumn;
	@FXML
	private HBox learninOutcomesToolbar;
	@FXML
	private JFXButton addOutcomeButton;
	@FXML
	private JFXButton removeOutcomeButton;
	@FXML
	private VBox coordinatorCreationBox;
	@FXML
	private JFXComboBox<AcademicTitle> coordinatorTitleChoice;
	@FXML
	private CustomTextField coordinatorNameField;
	@FXML
	private CustomTextField coordinatorSurnameField;
	@FXML
	private TableView<String> lecturerTable;
	@FXML
	private TableColumn<String, AcademicTitle> lecturerTableTitleColumn;
	@FXML
	private TableColumn<String, String> lecturerTableNameColumn;
	@FXML
	private TableColumn<String, String> lecturerTableSurnameColumn;
	@FXML
	private TableView<String> assistantTable;
	@FXML
	private TableColumn<String, AcademicTitle> assistantTableTitleColumn;
	@FXML
	private TableColumn<String, String> assistantTableNameColumn;
	@FXML
	private TableColumn<String, String> assistantTableSurnameColumn;
	@FXML
	private VBox lecturerCreationBox;
	@FXML
	private JFXComboBox<AcademicTitle> lecturerTitleChoice;
	@FXML
	private CustomTextField lecturerNameField;
	@FXML
	private CustomTextField lecturerSurnameField;
	@FXML
	private JFXButton addLecturerButton;
	@FXML
	private JFXButton addAssistantButton;
	@FXML
	private JFXButton removeButton;
	@FXML
	private TableView<WeeklySubject> scheduleTable;
	@FXML
	private TableColumn<WeeklySubject, String> scheduleTableWeekColumn;
	@FXML
	private TableColumn<WeeklySubject, String> scheduleTableDescriptionColumn;
	@FXML
	private TableColumn<WeeklySubject, String> scheduleTableRMColumn;
	@FXML
	private TableView<EvaluationCriteria> evaluationCriteriaTable;
	@FXML
	private TableColumn<EvaluationCriteria, String> evaluationCriteriaTableNameColumn;
	@FXML
	private TableColumn<EvaluationCriteria, String> evaluationCriteriaTableCountColumn;
	@FXML
	private TableColumn<EvaluationCriteria, String> evaluationCriteriaTableContributionColumn;
	@FXML
	private HBox evaluationCriteriaToolbar;
	@FXML
	private JFXButton addEvaluationCriteriaButton;
	@FXML
	private JFXButton removeEvaluationCriteriaButton;
	@FXML
	private TableView<SemesterActivity> workloadTable;
	@FXML
	private TableColumn<SemesterActivity, String> workloadTableNameColumn;
	@FXML
	private TableColumn<SemesterActivity, String> workloadTableNumberColumn;
	@FXML
	private TableColumn<SemesterActivity, String> workloadTableHoursColumn;
	@FXML
	private TableColumn<SemesterActivity, String> workloadTableWorkloadColumn;
	@FXML
	private HBox workloadTableToolbar;
	@FXML
	private JFXButton addWorkloadButton;
	@FXML
	private JFXButton removeWorkloadButton;
	@FXML
	private TableView<CourseCompetency> competencyTable;
	@FXML
	private TableColumn<CourseCompetency, String> competencyTableDescriptionColumn;
	@FXML
	private TableColumn<CourseCompetency, String> competencyTableContributionColumn;
	@FXML
	private HBox competencyToolbar;
	@FXML
	private JFXButton addCompetencyButton;
	@FXML
	private JFXButton removeCompetencyButton;

	// Positions for the event
	private double mouseXPosition = 0;
	private double mouseYPosition = 0;

	@FXML
	public void initialize() {
		


		// Close Button functionalities
		closeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Platform.exit();
			}
		});

		// Minimize button functionalities
		minimizeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Main.generalStage.setIconified(true);
			}
		});

		// Course List connecting
		courseList.setItems(Initializer.getCourses());

		// Adding draggability
		topPane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				mouseXPosition = event.getX();
				mouseYPosition = event.getY();
			}
		});

		topPane.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Main.generalStage.setX(event.getScreenX() - mouseXPosition);
				Main.generalStage.setY(event.getScreenY() - mouseYPosition);
				;
			}
		});

		// Selection mode arrangement
		courseList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		// CreationDate disabling
		creationDatePicker.setDisable(true);

		// Save operation
		saveButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				// Required Commits
				courseNameField.commitValue();
				courseCodeField.commitValue();
				languageChoice.commitValue();
				semesterChoice.commitValue();
				theoreticalHoursField.commitValue();
				applicationHoursField.commitValue();
				courseTypeChoice.commitValue();
				courseLevelChoice.commitValue();
				courseCategoryChoice.commitValue();
				courseDescriptionArea.commitValue();
				courseObjectiveArea.commitValue();
				coordinatorTitleChoice.commitValue();
				coordinatorNameField.commitValue();
				coordinatorSurnameField.commitValue();
				mainCourseBookField.commitValue();

				// Selected Course
				Course selectedCourse = courseList.getSelectionModel().getSelectedItem();

				// Actions to take
				selectedCourse.setCourseName(courseNameField.getText());
				selectedCourse.setCode(courseCodeField.getText());
				selectedCourse.setPrerequisites(new LinkedHashSet<>(prerequisitesList.getItems()));
				selectedCourse.setCourseLang(languageChoice.getValue());
				selectedCourse.setSemester(semesterChoice.getValue());
				selectedCourse.setTheoreticalHour(Integer.parseInt(theoreticalHoursField.getText()));
				selectedCourse.setLabHour(Integer.parseInt(applicationHoursField.getText()));
				selectedCourse.setType(courseTypeChoice.getValue());
				selectedCourse.setLevel(courseLevelChoice.getValue());

				String coordinatorFullName = coordinatorTitleChoice.getValue().toString() + " "
						+ coordinatorNameField.getText() + " " + coordinatorSurnameField.getText();
				selectedCourse.setCourseCoordinator(coordinatorFullName);
				selectedCourse.setCourseLecturers(new LinkedHashSet<>(lecturerTable.getItems()));
				selectedCourse.setAssistants(new LinkedHashSet<>(assistantTable.getItems()));
				selectedCourse.setCourseObjective(courseObjectiveArea.getText());
				selectedCourse.setCourseDescription(courseDescriptionArea.getText());
				selectedCourse.setLearningOutcomes(new LinkedHashSet<>(learningOutcomesTable.getItems()));
				selectedCourse.setCourseCategory(courseCategoryChoice.getValue());
				selectedCourse.setCourseSchedule(new LinkedHashSet<>(scheduleTable.getItems()));
				selectedCourse.setCourseTextBook(mainCourseBookField.getText());
				selectedCourse.setSuggestedReading(new LinkedHashSet<>(suggestedReadingList.getItems()));
				selectedCourse.setEvaluationCriterias(new LinkedHashSet<>(evaluationCriteriaTable.getItems()));
				selectedCourse.setWorkloadTable(new LinkedHashSet<>(workloadTable.getItems()));
				selectedCourse.setCourseCompetencies(new LinkedHashSet<>(competencyTable.getItems()));
			}
		});

		createSyllabus.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Initializer.getCourses().add(new Course());
			}
		});

		// Add Syllabus Button
		addSyllabus.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				FileChooser chooser = new FileChooser();
				chooser.getExtensionFilters().add(new ExtensionFilter("Syllabus File", "*.syb"));
				chooser.setTitle("Choose a syllabus file");
				File chosenFile = chooser.showOpenDialog(Main.generalStage);
				if ((chosenFile != null) && (chosenFile.exists())) {
					Initializer.importCourse(chosenFile);
				}
			}
		});

		// Import Syllabus from Internet Button
		importSyllabus.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				Stage minorStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				try {
					loader.setLocation(Path.of("src", "newui", "fxml", "import.fxml").toUri().toURL());
				} catch (MalformedURLException e) {
					Alert alertbox = new Alert(AlertType.ERROR);
					alertbox.setHeaderText("Error");
					alertbox.setContentText("Crucial error has been occured about the import section."
							+ "Please notify the developers.");
					alertbox.initModality(Modality.APPLICATION_MODAL);
					alertbox.initOwner(Main.generalStage);
					return;
				}
				BorderPane importScene;
				try {
					importScene = loader.load();
				} catch (IOException e) {
					Alert alertbox = new Alert(AlertType.ERROR);
					alertbox.setHeaderText("Error");
					alertbox.setContentText("Crucial error has been occured about the import section."
							+ "Please notify the developers.");
					alertbox.initModality(Modality.APPLICATION_MODAL);
					alertbox.initOwner(Main.generalStage);
					return;
				}
				minorStage.initModality(Modality.APPLICATION_MODAL);
				minorStage.initOwner(Main.generalStage);
				minorStage.initStyle(StageStyle.UNDECORATED);
				minorStage.setScene(new Scene(importScene));
				minorStage.showAndWait();
			};
		});

		// Export button function
		exportSyllabus.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Course selected = courseList.getSelectionModel().getSelectedItem();
				Export export = new Export();
				FileChooser chooser = new FileChooser();
				chooser.getExtensionFilters().add(new ExtensionFilter("Syllabus File", "*.syb"));
				chooser.getExtensionFilters().add(new ExtensionFilter("HTML File", "*.html"));
				chooser.setTitle("Choose a save location");
				File chosenFile = chooser.showSaveDialog(Main.generalStage);
				if ((chosenFile != null) && !(chosenFile.exists())) {
					// Exporter method will be called from here
					export.export(selected, chosenFile.toString());
				}
			}
		});

		// Delete Button Function
		deleteSyllabus.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int selectIndex = courseList.getSelectionModel().getSelectedIndex();
				if (selectIndex != -1) {
					Initializer.getCourses().remove(selectIndex);
				}
			}
		});

		// GitHub button functions
		gitHubButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				try {
					Desktop.getDesktop().browse(new URL("https://github.com/SE302Team13/syllab").toURI());
				} catch (IOException | URISyntaxException e) {
					Alert alertbox = new Alert(AlertType.ERROR);
					alertbox.setHeaderText("Error");
					alertbox.setContentText("Github page is not accessible." + "Please notify the developers.");
					alertbox.initModality(Modality.APPLICATION_MODAL);
					alertbox.initOwner(Main.generalStage);
					return;
				}
			}
		});

		
		//Prerequisites Modifications
		addPrerequisites.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				prerequisitesList.getItems().add("New prerequisite");
			}
		});

		deletePrerequisites.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int index = prerequisitesList.getSelectionModel().getSelectedIndex();
				if (index != -1) {
					prerequisitesList.getItems().remove(index);
				}
			}
		});
		

		//TODO Create a better cell creation factory by callback function
		//Makes prerequisites list editable
		prerequisitesList.setCellFactory(TextFieldListCell.forListView());
		
		
		//Defining Combo boxes
		languageChoice.getItems().addAll(Language.values());
		semesterChoice.getItems().addAll(SemesterOptions.values());
		courseTypeChoice.getItems().addAll(CourseType.values());
		courseLevelChoice.getItems().addAll(CourseLevel.values());
		courseCategoryChoice.getItems().addAll(CourseCategory.values());
		coordinatorTitleChoice.getItems().addAll(AcademicTitle.values());
		lecturerTitleChoice.getItems().addAll(AcademicTitle.values());
		
		
		
		//TRYIT Try different effect and apply you like most
		//Button Effect and Styling Example
		createSyllabus.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, new CornerRadii(30), BorderWidths.DEFAULT)));
		createSyllabus.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), null)));
		addSyllabus.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, new CornerRadii(30), BorderWidths.DEFAULT)));
		addSyllabus.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), null)));
		
		
		//Learning outcomes table data updating
		learningOutcomesTableLOColumn.cellValueFactoryProperty().set(new Callback<TableColumn.CellDataFeatures<String,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<String, String> param) {
				
				return new SimpleStringProperty(param.getValue());
			}
		});
		
		learningOutcomesTableNumberColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<String, String> param) {
				int index = param.getTableView().getItems().indexOf(param.getValue());
				return new SimpleStringProperty(String.valueOf(index +1));
			}
		});
		
		scheduleTableDescriptionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<WeeklySubject,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<WeeklySubject, String> param) {
				return new SimpleStringProperty(param.getValue().getDescription());
			}
		});
		scheduleTableWeekColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<WeeklySubject,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<WeeklySubject, String> param) {
				return new SimpleStringProperty(String.valueOf(param.getValue().getWeek()));
			}
		});
		scheduleTableDescriptionColumn.cellFactoryProperty().set(TextFieldTableCell.forTableColumn());
		scheduleTableRMColumn.cellFactoryProperty().set(TextFieldTableCell.forTableColumn());
		
		evaluationCriteriaTableNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<EvaluationCriteria,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
				return new SimpleStringProperty(param.getValue().getName());
			}
		});
		evaluationCriteriaTableCountColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<EvaluationCriteria,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
				return new SimpleStringProperty(String.valueOf(param.getValue().getCount()));
			}
		});
		evaluationCriteriaTableContributionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<EvaluationCriteria,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
				return new SimpleStringProperty(String.valueOf(param.getValue().getContribution()));
			}
		});
		evaluationCriteriaTableContributionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		evaluationCriteriaTableCountColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		evaluationCriteriaTableNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		//Reactive course list implementation
		courseList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {
			
			@Override
			public void changed(ObservableValue<? extends Course> observable, Course oldValue, Course newValue) {
				Course currentCourse = courseList.getSelectionModel().getSelectedItem();
				courseNameField.setText(currentCourse.getCourseName());
				courseCodeField.setText(currentCourse.getCode());
				creationDatePicker.setValue(currentCourse.getCreationDate().toLocalDate());
				prerequisitesList.getItems().clear();
				prerequisitesList.getItems().addAll(currentCourse.getPrerequisites());
				languageChoice.setValue(currentCourse.getCourseLang());
				semesterChoice.setValue(currentCourse.getSemester());
				theoreticalHoursField.setText(String.valueOf(currentCourse.getTheoreticalHour()));
				applicationHoursField.setText(String.valueOf(currentCourse.getLabHour()));
				courseTypeChoice.setValue(currentCourse.getType());
				courseLevelChoice.setValue(currentCourse.getLevel());
				courseCategoryChoice.setValue(currentCourse.getCourseCategory());
				courseDescriptionArea.setText(currentCourse.getCourseDescription());
				courseObjectiveArea.setText(currentCourse.getCourseObjective());
				mainCourseBookField.setText(currentCourse.getCourseTextBook());
				
				suggestedReadingList.getItems().clear();
				suggestedReadingList.getItems().addAll(currentCourse.getSuggestedReading());
				
				learningOutcomesTable.getItems().clear();
				learningOutcomesTable.getItems().addAll(currentCourse.getLearningOutcomes());
				
				lecturerTable.getItems().clear();
				lecturerTable.getItems().addAll(currentCourse.getCourseLecturers());
				
				assistantTable.getItems().clear();
				assistantTable.getItems().addAll(currentCourse.getAssistants());
				
				scheduleTable.getItems().clear();
				scheduleTable.getItems().addAll(currentCourse.getCourseSchedule());
				
				evaluationCriteriaTable.getItems().clear();
				evaluationCriteriaTable.getItems().addAll(currentCourse.getEvaluationCriterias());
				
				workloadTable.getItems().clear();
				workloadTable.getItems().addAll(currentCourse.getWorkloadTable());
				
				competencyTable.getItems().clear();
				competencyTable.getItems().addAll(currentCourse.getCourseCompetencies());
			}
		});  
		
		
		//TEST COURSE WILL BE DELETED AT THE END
		Course test = new Course();
		test.addLearningOutcome("Testing Outcome");
		test.addLearningOutcome("Testing Outcome222");
		test.addLearningOutcome("Testing Outcome333");
		ArrayList<Integer> contributions = new ArrayList<>();
		contributions.add(1);
		contributions.add(0);
		contributions.add(0);
		test.addCriteria("Exam", 3, 24, contributions);
		Initializer.getCourses().add(test);
	}

}
