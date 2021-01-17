package newui;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.validation.ValidateEvent;

import com.jfoenix.animation.alert.JFXAlertAnimation;
import com.jfoenix.controls.JFXAlert;
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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
	private JFXComboBox<String> coordinatorTitleChoice;
	@FXML
	private CustomTextField coordinatorNameField;
	@FXML
	private CustomTextField coordinatorSurnameField;
	@FXML
	private TableView<String> lecturerTable;
	@FXML
	private TableColumn<String, String> lecturerTableTitleColumn;
	@FXML
	private TableColumn<String, String> lecturerTableNameColumn;
	@FXML
	private TableColumn<String, String> lecturerTableSurnameColumn;
	@FXML
	private TableView<String> assistantTable;
	@FXML
	private TableColumn<String, String> assistantTableTitleColumn;
	@FXML
	private TableColumn<String, String> assistantTableNameColumn;
	@FXML
	private TableColumn<String, String> assistantTableSurnameColumn;
	@FXML
	private VBox lecturerCreationBox;
	@FXML
	private JFXComboBox<String> lecturerTitleChoice;
	@FXML
	private CustomTextField lecturerNameField;
	@FXML
	private CustomTextField lecturerSurnameField;
	@FXML
	private JFXButton addLecturerButton;
	@FXML
	private JFXButton addAssistantButton;
	@FXML
	private JFXButton removeLecturerButton;
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
				String title = coordinatorTitleChoice.getValue();
				String name = coordinatorNameField.getText();
				String surname = coordinatorSurnameField.getText();
				if ((title != null) && (name != null) && (surname != null)) {
					String coordinatorFullName = title + "//" + name + "//" + surname;
					selectedCourse.setCourseCoordinator(coordinatorFullName);
				}
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

				courseList.refresh();
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
					try {
						Initializer.load(chosenFile);
					} catch (ClassNotFoundException | IOException e) {
						JFXAlert<String> alert = new JFXAlert<>(Main.generalStage);
						alert.setTitle("Local Import Error");
						alert.setHeaderText("Error");
						alert.setContentText("A crucial error has been occured on the local import function."
								+ "Please notify the developers.");
						alert.initModality(Modality.APPLICATION_MODAL);
						alert.showAndWait();
					}
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
					alertbox.setTitle("Online Import Error");
					alertbox.setHeaderText("Error");
					alertbox.setContentText("A crucial error has been occured on the online import function."
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
				if ((chosenFile != null)) {
					export.export(selected, chosenFile.toString());
					/*
					 * TODO INSPECT HERE
					 */
					/*
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						new HTMLViewer(chosenFile);
					} catch (IOException e) {
						JFXAlert<Boolean> alert = new JFXAlert<>(Main.generalStage);
						alert.setAnimation(JFXAlertAnimation.CENTER_ANIMATION);
						alert.setContentText("Unexpected problem occured during visualization of the current HTML document. Please notify the developers about the problem.");
						alert.setResizable(false);
						alert.initModality(Modality.APPLICATION_MODAL);
						alert.showAndWait();
					}
					*/
					/*
					Timer timer = new Timer("HTMLViewer");
					timer.schedule(new TimerTask() {
						
						@Override
						public void run() {
							Platform.runLater(new Runnable() {
								
								@Override
								public void run() {

								}
							});
						}
						
					}, Duration.ofSeconds(8).toMillis());
					*/
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

		// Prerequisites Modifications
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

		// TODO Create a better cell creation factory by callback function
		// Makes prerequisites list editable
		prerequisitesList.setCellFactory(TextFieldListCell.forListView());

		// Defining Combo boxes
		languageChoice.getItems().addAll(Language.values());
		semesterChoice.getItems().addAll(SemesterOptions.values());
		courseTypeChoice.getItems().addAll(CourseType.values());
		courseLevelChoice.getItems().addAll(CourseLevel.values());
		courseCategoryChoice.getItems().addAll(CourseCategory.values());
		coordinatorTitleChoice.getItems().addAll(AcademicTitle.getTitles());
		lecturerTitleChoice.getItems().addAll(AcademicTitle.getTitles());

		// Learning outcomes table data updating
		learningOutcomesTableLOColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<String, String> param) {

						return new SimpleStringProperty(param.getValue());
					}
				});

		learningOutcomesTableNumberColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<String, String> param) {
						int index = param.getTableView().getItems().indexOf(param.getValue());
						return new SimpleStringProperty(String.valueOf(index + 1));
					}
				});

		scheduleTableDescriptionColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<WeeklySubject, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<WeeklySubject, String> param) {
						return new SimpleStringProperty(param.getValue().getDescription());
					}
				});
		scheduleTableWeekColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<WeeklySubject, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<WeeklySubject, String> param) {
						return new SimpleStringProperty(String.valueOf(param.getValue().getWeek()));
					}
				});
		evaluationCriteriaTableNameColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<EvaluationCriteria, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
						return new SimpleStringProperty(param.getValue().getName());
					}
				});
		evaluationCriteriaTableCountColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<EvaluationCriteria, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
						return new SimpleStringProperty(String.valueOf(param.getValue().getCount()));
					}
				});
		evaluationCriteriaTableContributionColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<EvaluationCriteria, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
						return new SimpleStringProperty(String.valueOf(param.getValue().getContribution()));
					}
				});

		// Reactive course list implementation
		courseList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {

			@Override
			public void changed(ObservableValue<? extends Course> observable, Course oldValue, Course newValue) {
				Course currentCourse = courseList.getSelectionModel().getSelectedItem();
				if (currentCourse != null) {
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
					
					//Added coded for the handle problems related with "simplification"
					String[] coordinator = parseLecturer(currentCourse.getCourseCoordinator());
					if (coordinator != null) {
						if (coordinator[0] != null) {
							coordinatorTitleChoice.setValue(coordinator[0]);
						}
						coordinatorNameField.setText(coordinator[1]);
						coordinatorSurnameField.setText(coordinator[2]);
					}

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
			}
		});

		// LearninOutcomes Toolbar Activity
		addOutcomeButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				learningOutcomesTable.getItems().add("EMPTY");
			}
		});
		removeOutcomeButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int index = learningOutcomesTable.getSelectionModel().getSelectedIndex();
				if (index != -1) {
					learningOutcomesTable.getItems().remove(index);
				}
			}
		});
		
		
		//Defining callback functions for tables in Lecturers tab
		Callback<TableColumn.CellDataFeatures<String,String>, ObservableValue<String>> titleColumnCallback =
				new Callback<TableColumn.CellDataFeatures<String,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<String, String> param) {
				String[] lecturer = parseLecturer(param.getValue());
				if (lecturer != null && lecturer[0] != null) {
					return new SimpleStringProperty(lecturer[0]);
				}
				return new SimpleStringProperty("Not Given");
			}
		};
		
		
		Callback<TableColumn.CellDataFeatures<String,String>, ObservableValue<String>> surnameColumnCallback =
				new Callback<TableColumn.CellDataFeatures<String,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<String, String> param) {
				String[] lecturer = parseLecturer(param.getValue());
				if (lecturer != null) {
					return new SimpleStringProperty(lecturer[2]);
				}
				return new SimpleStringProperty("Not Given");
			}
		};
		
		Callback<TableColumn.CellDataFeatures<String,String>, ObservableValue<String>> nameColumnCallback = new Callback<TableColumn.CellDataFeatures<String,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<String, String> param) {
				String[] lecturer = parseLecturer(param.getValue());
				if (lecturer != null) {
					return new SimpleStringProperty(lecturer[1]);
				}
				return new SimpleStringProperty("Not Given");
			}
		};
		

		
		//Lecturers tab Table cell factory assignment
		lecturerTableTitleColumn.setCellValueFactory(titleColumnCallback);
		lecturerTableNameColumn.setCellValueFactory(nameColumnCallback);
		lecturerTableSurnameColumn.setCellValueFactory(surnameColumnCallback);
		assistantTableTitleColumn.setCellValueFactory(titleColumnCallback);
		assistantTableNameColumn.setCellValueFactory(nameColumnCallback);
		assistantTableSurnameColumn.setCellValueFactory(surnameColumnCallback);
		
		
		//Lecturers tab toolbar functionalities
		addLecturerButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//Required commits
				lecturerNameField.commitValue();
				lecturerSurnameField.commitValue();
				lecturerTitleChoice.commitValue();
				
				String title = lecturerTitleChoice.getValue();
				String name = lecturerNameField.getText();
				String surname = lecturerSurnameField.getText();
				if((title != null) && (name != null) && (surname !=null)) {
					if (title.isBlank() || (name.isBlank()) || (surname.isBlank())) {
						return;
					}
					String lecturer = title + "//" + name + "//" + surname;
					lecturerTable.getItems().add(lecturer);
				}
			}
		});
		addAssistantButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//Required commits
				lecturerNameField.commitValue();
				lecturerSurnameField.commitValue();
				lecturerTitleChoice.commitValue();
				
				String title = lecturerTitleChoice.getValue();
				String name = lecturerNameField.getText();
				String surname = lecturerSurnameField.getText();
				if((title != null) && (name != null) && (surname !=null)) {
					if (title.isBlank() || (name.isBlank()) || (surname.isBlank())) {
						return;
					}
					String lecturer = title + "//" + name + "//" + surname;
					assistantTable.getItems().add(lecturer);
				}
			}
		});
		
		/*
		 * Lecturer/Assistant table data removal problem solved by synchronizing focuses among tables
		 */
		lecturerTable.focusedProperty().addListener(new ChangeListener<Boolean>() {
			
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if ((oldValue == true) && (newValue == false)) {
					lecturerTable.getSelectionModel().clearSelection();
				}
			}
		});
		assistantTable.focusedProperty().addListener(new ChangeListener<Boolean>() {
			
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if ((oldValue == true) && (newValue == false)) {
					assistantTable.getSelectionModel().clearSelection();
				}
			}
		});
		
		removeLecturerButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				int index = lecturerTable.getSelectionModel().getFocusedIndex();
				if (index != -1) {
					lecturerTable.getItems().remove(index);
				} else {
					index = assistantTable.getSelectionModel().getSelectedIndex();
					if (index != -1) {
						assistantTable.getItems().remove(index);
					}
				}
			}
		});
		
		
		//Evaluation Criteria Table Columns Cell Value Factory
		evaluationCriteriaTableNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<EvaluationCriteria,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
				String value = param.getValue().getName();
				return new SimpleStringProperty(value);
			}
		});
		evaluationCriteriaTableCountColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<EvaluationCriteria,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
				int value = param.getValue().getCount();
				return new SimpleStringProperty(String.valueOf(value));
			}
		});
		evaluationCriteriaTableContributionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<EvaluationCriteria,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
				int value = param.getValue().getContribution();
				return new SimpleStringProperty(String.valueOf(value));
			}
		});
		
		
		//Evaluation Criteria Toolbar Functions
		addEvaluationCriteriaButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		removeEvaluationCriteriaButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				int index = evaluationCriteriaTable.getSelectionModel().getSelectedIndex();
				if (index != -1) {
					evaluationCriteriaTable.getItems().remove(index);
				}
			}
		});
		
		
		//WorkloadTable Column Cell Value Factory
		workloadTableNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SemesterActivity,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<SemesterActivity, String> param) {
				
				return new SimpleStringProperty(param.getValue().getActivityName());
			}
		});
		workloadTableNumberColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SemesterActivity,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<SemesterActivity, String> param) {
				int value = param.getValue().getNumber();
				return new SimpleStringProperty(String.valueOf(value));
			}
		});
		workloadTableHoursColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SemesterActivity,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<SemesterActivity, String> param) {
				int value = param.getValue().getDuration();
				return new SimpleStringProperty(String.valueOf(value));
			}
		});
		workloadTableWorkloadColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SemesterActivity,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<SemesterActivity, String> param) {
				int value = param.getValue().getWorkload();
				return new SimpleStringProperty(String.valueOf(value));
			}
		});
		
		//Workload Table toolbar functions
		addWorkloadButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				workloadTable.getItems().add(new SemesterActivity("-", 0, 0));
			}
		});
		removeWorkloadButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				int index = courseList.getSelectionModel().getSelectedIndex();
				if (index != -1) {
					workloadTable.getItems().remove(index);
				}
			}
		});
		
		
		//Course Competency Table Columns Cell Value Factory
		competencyTableDescriptionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CourseCompetency,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<CourseCompetency, String> param) {
				
				return new SimpleStringProperty(param.getValue().getDescription());
			}
		});
		competencyTableContributionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CourseCompetency,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<CourseCompetency, String> param) {
				int value = param.getValue().getContributionLevel();
				return new SimpleStringProperty(String.valueOf(value));
			}
		});
		
		
		
		
		
		
		//TEST ITEM - DO NOT REMOVE UNTIL THE END OF THE DEVELOPMENT PROCESS
		Course course = new Course();
		course.setCourseName("Principles of Software Engineering");
		course.setCode("SE 302");
		course.setCourseCoordinator("Assistant Professor//Kaya//Oðuz");
		course.addLearningOutcome("Define engineering, software, computer and system engineering");
		course.addLearningOutcome("Define software processes");
		course.addLearningOutcome("Gather the software requirements");
		course.addLearningOutcome("Define software design and architecture");
		ArrayList<Integer> testArray = new ArrayList<>();
		testArray.add(3);
		testArray.add(2);
		testArray.add(2);
		testArray.add(1);
		course.addCriteria("Midterms", 1, 30, testArray);
		course.addCriteria("Final", 1, 40, testArray);
		course.addCriteria("Project", 1, 30, testArray);
		course.setCourseObjective("In this course, students learn the theoretical and practical aspects of specification and design, development, verification and validation and testing stages of SE. More, this course enables students to realize software specification and design phases of sample projects with real clients.");
		course.addPrerequisite("SE 116 To succeed (To get a grade of at least DD)");
		course.setCourseDescription("In this course, students learn the theoretical and practical aspects of specification and design, development, verification and validation and testing stages of SE. More, this course enables students to realize software specification and design phases of sample projects with real clients.");
		course.changeSchedule(1, "Introduction to Software Engineering", "Sommerville, Chapter 01");
		course.changeSchedule(2, "Software Processes", "Sommerville, Chapter 02, Pressman Chapter 02");
		course.addCompetency("	\r\n"
				+ "To have adequate knowledge in Mathematics, Science and Computer Engineering; to be able to use theoretical and applied information in these areas on complex engineering problems.", 0, new LinkedHashSet<>());
		
		
	}

	
	
	//Method is used because of the "Simplification" Process
	private String[] parseLecturer(String lecturer) {
		String[] lecturerSections = lecturer.split("//");
		String[] result = new String[3];
		if (lecturerSections.length > 1) {
			String tempTitle = lecturerSections[0];
			String title = AcademicTitle.tryParse(tempTitle);
			if (title != null) {
				result[0] = title;
				lecturerSections[0] = null;
			} else {
				result[0] = null;
			}
			String surname = lecturerSections[lecturerSections.length - 1];
			result[2] = surname;
			lecturerSections[lecturerSections.length - 1] = null;
			StringBuilder nameBuilder = new StringBuilder();
			for (int i = 0; i < lecturerSections.length; i++) {
				String value = lecturerSections[i];
				if (value != null) {
					nameBuilder.append(value);
					nameBuilder.append(" ");
				}
			}
			result[1] = nameBuilder.toString();
			return result;
		}
		return null;
	}

}
