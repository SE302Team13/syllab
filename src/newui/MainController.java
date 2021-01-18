package newui;

import java.awt.Desktop;
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
import org.controlsfx.control.textfield.CustomTextField;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;

import initializer.Initializer;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	private TableColumn<CourseCompetency, String> competencyTableRelatedLearningOutcomes;
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
				Javafxmain.generalStage.setIconified(true);
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
				Javafxmain.generalStage.setX(event.getScreenX() - mouseXPosition);
				Javafxmain.generalStage.setY(event.getScreenY() - mouseYPosition);

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
				File chosenFile = chooser.showOpenDialog(Javafxmain.generalStage);
				if ((chosenFile != null) && (chosenFile.exists())) {
					try {
						Initializer.load(chosenFile);
					} catch (ClassNotFoundException | IOException e) {
						Alert alertbox = new Alert(AlertType.ERROR);
						alertbox.setTitle("Local Import Error");
						alertbox.setHeaderText("Error");
						alertbox.setContentText("A crucial error has been occured on the local import function."
								+ "Please notify the developers.");
						alertbox.initModality(Modality.APPLICATION_MODAL);
						alertbox.initOwner(Javafxmain.generalStage);
						alertbox.showAndWait();
					}
				}
			}
		});

		// Import Syllabus from Internet Button
		importSyllabus.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
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
					alertbox.initOwner(Javafxmain.generalStage);
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
					alertbox.initOwner(Javafxmain.generalStage);
					return;
				}
				minorStage.initModality(Modality.APPLICATION_MODAL);
				minorStage.initOwner(Javafxmain.generalStage);
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
				File chosenFile = chooser.showSaveDialog(Javafxmain.generalStage);
				if ((chosenFile != null)) {
					if (chosenFile.getAbsolutePath().endsWith(".html")) {
						export.export(selected, chosenFile.toString());
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {

							@Override
							public void run() {
								Platform.runLater(new Runnable() {

									@Override
									public void run() {
										try {
											HTMLViewer.viewHTML(chosenFile);
										} catch (IOException e) {
											Alert alertbox = new Alert(AlertType.ERROR);
											alertbox.setHeaderText("Error");
											alertbox.setContentText("HTML Viewer is not working properly."
													+ "Please notify the developers about the problem.");
											alertbox.initModality(Modality.APPLICATION_MODAL);
											alertbox.initOwner(Javafxmain.generalStage);
											alertbox.getButtonTypes().clear();
											alertbox.getButtonTypes().add(ButtonType.CLOSE);
											alertbox.showAndWait();
											return;
										}
									}
								});
							}

						}, Duration.ofSeconds(8).toMillis());
					} else if (chosenFile.getAbsolutePath().endsWith(".syb")) {
						int index = courseList.getSelectionModel().getSelectedIndex();
						try {
							Initializer.save(index, chosenFile);
						} catch (IOException e) {
							Alert alertbox = new Alert(AlertType.ERROR);
							alertbox.setHeaderText("Error");
							alertbox.setContentText("File could not be saved to the location you directed."
									+ "Please notify the developers about the problem.");
							alertbox.initModality(Modality.APPLICATION_MODAL);
							alertbox.initOwner(Javafxmain.generalStage);
							alertbox.getButtonTypes().clear();
							alertbox.getButtonTypes().add(ButtonType.CLOSE);
							alertbox.showAndWait();
							return;
						}
					}
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
					alertbox.initOwner(Javafxmain.generalStage);
					alertbox.showAndWait();
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

		// ScheduleTable Columns Cell Factory
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
		scheduleTableRMColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<WeeklySubject, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<WeeklySubject, String> param) {
						return new SimpleStringProperty(param.getValue().getRelatedMaterial());
					}
				});

		// Evaluation Criteria Table Column Cell Factories
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

					// Added coded for the handle problems related with "simplification"
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
				TableColumn<EvaluationCriteria, String> lo1 = new TableColumn<>();
				lo1.setText("LO" + learningOutcomesTable.getItems().size());
				lo1.setEditable(true);
				lo1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EvaluationCriteria, String>>() {

					@Override
					public void handle(CellEditEvent<EvaluationCriteria, String> event) {
						if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
							int index = event.getTablePosition().getRow();
							int value = 0;
							try {
								value = Integer.parseInt(event.getNewValue());
								int outcomeIndex = event.getTableView().getVisibleLeafIndex(event.getTableColumn()) - 3;
								event.getTableView().getItems().get(index).getContributionLevels().set(outcomeIndex,
										value);
								event.getTableView().refresh();
							} catch (NumberFormatException e) {
								// do nothing xd
								return;
							}
						}
					}
				});
				lo1.setCellValueFactory(
						new Callback<TableColumn.CellDataFeatures<EvaluationCriteria, String>, ObservableValue<String>>() {

							@Override
							public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
								int columnNumber = param.getTableView().getVisibleLeafIndex(lo1);
								int index = columnNumber - 3;
								param.getValue().getContributionLevels().add(index, 0);
								int value = param.getValue().getContributionLevels().get(index);
								return new SimpleStringProperty(String.valueOf(value));
							}
						});
				evaluationCriteriaTable.getColumns().add(lo1);
				evaluationCriteriaTable.refresh();
			}
		});
		removeOutcomeButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int index = learningOutcomesTable.getSelectionModel().getSelectedIndex();
				if (index != -1) {
					learningOutcomesTable.getItems().remove(index);
					ObservableList<TableColumn<EvaluationCriteria, ?>> list = evaluationCriteriaTable.getColumns();
					int removeLocation = index + 3;
					list.remove(removeLocation);
					for (int i = removeLocation; i < list.size(); i++) {
						list.get(i).setText("LO" + (index + 1));
					}
					evaluationCriteriaTable.refresh();
				}
			}
		});

		// Defining callback functions for tables in Lecturers tab
		Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>> titleColumnCallback = new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<String, String> param) {
				String[] lecturer = parseLecturer(param.getValue());
				if (lecturer != null && lecturer[0] != null) {
					return new SimpleStringProperty(lecturer[0]);
				}
				return new SimpleStringProperty("Not Given");
			}
		};

		Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>> surnameColumnCallback = new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<String, String> param) {
				String[] lecturer = parseLecturer(param.getValue());
				if (lecturer != null) {
					return new SimpleStringProperty(lecturer[2]);
				}
				return new SimpleStringProperty("Not Given");
			}
		};

		Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>> nameColumnCallback = new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<String, String> param) {
				String[] lecturer = parseLecturer(param.getValue());
				if (lecturer != null) {
					return new SimpleStringProperty(lecturer[1]);
				}
				return new SimpleStringProperty("Not Given");
			}
		};

		// Lecturers tab Table cell factory assignment
		lecturerTableTitleColumn.setCellValueFactory(titleColumnCallback);
		lecturerTableNameColumn.setCellValueFactory(nameColumnCallback);
		lecturerTableSurnameColumn.setCellValueFactory(surnameColumnCallback);
		assistantTableTitleColumn.setCellValueFactory(titleColumnCallback);
		assistantTableNameColumn.setCellValueFactory(nameColumnCallback);
		assistantTableSurnameColumn.setCellValueFactory(surnameColumnCallback);

		// Lecturers tab toolbar functionalities
		addLecturerButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Required commits
				lecturerNameField.commitValue();
				lecturerSurnameField.commitValue();
				lecturerTitleChoice.commitValue();

				String title = lecturerTitleChoice.getValue();
				String name = lecturerNameField.getText();
				String surname = lecturerSurnameField.getText();
				if ((title != null) && (name != null) && (surname != null)) {
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
				// Required commits
				lecturerNameField.commitValue();
				lecturerSurnameField.commitValue();
				lecturerTitleChoice.commitValue();

				String title = lecturerTitleChoice.getValue();
				String name = lecturerNameField.getText();
				String surname = lecturerSurnameField.getText();
				if ((title != null) && (name != null) && (surname != null)) {
					if (title.isBlank() || (name.isBlank()) || (surname.isBlank())) {
						return;
					}
					String lecturer = title + "//" + name + "//" + surname;
					assistantTable.getItems().add(lecturer);
				}
			}
		});

		/*
		 * Lecturer/Assistant table data removal problem solved by synchronizing focuses
		 * among tables
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
				int index = lecturerTable.getSelectionModel().getSelectedIndex();
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

		// Evaluation Criteria Table Columns Cell Value Factory
		evaluationCriteriaTableNameColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<EvaluationCriteria, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
						String value = param.getValue().getName();
						return new SimpleStringProperty(value);
					}
				});
		evaluationCriteriaTableCountColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<EvaluationCriteria, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
						int value = param.getValue().getCount();
						return new SimpleStringProperty(String.valueOf(value));
					}
				});
		evaluationCriteriaTableContributionColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<EvaluationCriteria, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<EvaluationCriteria, String> param) {
						int value = param.getValue().getContribution();
						return new SimpleStringProperty(String.valueOf(value));
					}
				});

		// Evaluation Criteria Toolbar Functions
		addEvaluationCriteriaButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				evaluationCriteriaTable.getItems().add(new EvaluationCriteria("-", 0, 0, new ArrayList<>()));
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

		// WorkloadTable Column Cell Value Factory
		workloadTableNameColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<SemesterActivity, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<SemesterActivity, String> param) {
						return new SimpleStringProperty(param.getValue().getActivityName());
					}
				});
		workloadTableNumberColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<SemesterActivity, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<SemesterActivity, String> param) {
						int value = param.getValue().getNumber();
						return new SimpleStringProperty(String.valueOf(value));
					}
				});
		workloadTableHoursColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<SemesterActivity, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<SemesterActivity, String> param) {
						int value = param.getValue().getDuration();
						return new SimpleStringProperty(String.valueOf(value));
					}
				});
		workloadTableWorkloadColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<SemesterActivity, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<SemesterActivity, String> param) {
						int value = param.getValue().getWorkload();
						return new SimpleStringProperty(String.valueOf(value));
					}
				});

		// Workload Table toolbar functions
		addWorkloadButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				workloadTable.getItems().add(new SemesterActivity("-", 0, 0));
			}
		});
		removeWorkloadButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int index = workloadTable.getSelectionModel().getSelectedIndex();
				if (index != -1) {
					workloadTable.getItems().remove(index);
				}
			}
		});

		// Course Competency Table Columns Cell Value Factory
		competencyTableDescriptionColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<CourseCompetency, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<CourseCompetency, String> param) {

						return new SimpleStringProperty(param.getValue().getDescription());
					}
				});
		competencyTableContributionColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<CourseCompetency, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<CourseCompetency, String> param) {
						int value = param.getValue().getContributionLevel();
						return new SimpleStringProperty(String.valueOf(value));
					}
				});
		competencyTableRelatedLearningOutcomes.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<CourseCompetency, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<CourseCompetency, String> param) {
						return new SimpleStringProperty(param.getValue().getRelatedLearningOutcomesString());
					}
				});

		// CompetencyTable Toolbar functionalities
		addCompetencyButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				competencyTable.getItems().add(new CourseCompetency("", 0, new LinkedHashSet<>()));
			}
		});
		removeCompetencyButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int index = competencyTable.getSelectionModel().getSelectedIndex();
				if (index != -1) {
					competencyTable.getItems().remove(index);
				}
			}
		});

		// courseList NullPointer Exception Solution
		generalTabPane.setVisible(false);
		saveButton.setDisable(true);
		courseList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() != -1) {
					generalTabPane.setVisible(true);
					saveButton.setDisable(false);
				} else {
					generalTabPane.setVisible(false);
					saveButton.setDisable(true);
				}
			}
		});

		// Learning Outcomes Table Edit
		learningOutcomesTable.setEditable(true);
		learningOutcomesTableLOColumn.setEditable(true);
		learningOutcomesTableLOColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		learningOutcomesTableLOColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<String, String>>() {

			@Override
			public void handle(CellEditEvent<String, String> event) {
				if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
					int index = event.getTablePosition().getRow();
					event.getTableView().getItems().remove(index);
					event.getTableView().getItems().add(index, event.getNewValue());
					event.getTableView().getSelectionModel().select(index);
				}
			}
		});

		// Lecturer Table Edit
		lecturerTable.setEditable(false);
		lecturerTableNameColumn.setEditable(false);
		lecturerTableTitleColumn.setEditable(false);
		lecturerTableSurnameColumn.setEditable(false);

		// Assistant Table Edit
		assistantTable.setEditable(false);
		assistantTableNameColumn.setEditable(false);
		assistantTableSurnameColumn.setEditable(false);
		assistantTableTitleColumn.setEditable(false);

		// Schedule Table Edit
		scheduleTable.setEditable(true);
		scheduleTableDescriptionColumn.setEditable(true);
		scheduleTableDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		scheduleTableRMColumn.setEditable(true);
		scheduleTableRMColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		scheduleTableDescriptionColumn
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<WeeklySubject, String>>() {

					@Override
					public void handle(CellEditEvent<WeeklySubject, String> event) {

						if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
							int index = event.getTablePosition().getRow();
							event.getTableView().getItems().get(index).setDescription(event.getNewValue());
						}
					}
				});
		scheduleTableRMColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<WeeklySubject, String>>() {

			@Override
			public void handle(CellEditEvent<WeeklySubject, String> event) {

				if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
					int index = event.getTablePosition().getRow();
					event.getTableView().getItems().get(index).setRelatedMaterial(event.getNewValue());
				}
			}
		});

		// Evaluation Criteria Edit
		evaluationCriteriaTable.setEditable(true);
		evaluationCriteriaTableNameColumn.setEditable(true);
		evaluationCriteriaTableNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		evaluationCriteriaTableCountColumn.setEditable(true);
		evaluationCriteriaTableCountColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		evaluationCriteriaTableContributionColumn.setEditable(true);
		evaluationCriteriaTableContributionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		evaluationCriteriaTableNameColumn
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EvaluationCriteria, String>>() {

					@Override
					public void handle(CellEditEvent<EvaluationCriteria, String> event) {

						if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
							int index = event.getTablePosition().getRow();
							event.getTableView().getItems().get(index).setName(event.getNewValue());
						}
					}
				});
		evaluationCriteriaTableCountColumn
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EvaluationCriteria, String>>() {

					@Override
					public void handle(CellEditEvent<EvaluationCriteria, String> event) {

						if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
							int index = event.getTablePosition().getRow();
							int value = 0;
							try {
								value = Integer.parseInt(event.getNewValue());
								event.getTableView().getItems().get(index).setCount(value);
							} catch (NumberFormatException e) {
								// do nothing xd
								return;
							}
						}
					}
				});
		evaluationCriteriaTableContributionColumn
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EvaluationCriteria, String>>() {

					@Override
					public void handle(CellEditEvent<EvaluationCriteria, String> event) {

						if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
							int index = event.getTablePosition().getRow();
							int value = 0;
							try {
								value = Integer.parseInt(event.getNewValue());
								event.getTableView().getItems().get(index).setContribution(value);
							} catch (NumberFormatException e) {
								// do nothing xd
								return;
							}
						}
					}
				});

		// Workload Table Edit
		workloadTable.setEditable(true);
		workloadTableNameColumn.setEditable(true);
		workloadTableNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		workloadTableNumberColumn.setEditable(true);
		workloadTableNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		workloadTableHoursColumn.setEditable(true);
		workloadTableHoursColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		workloadTableWorkloadColumn.setEditable(true);
		workloadTableWorkloadColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		workloadTableNameColumn
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<SemesterActivity, String>>() {

					@Override
					public void handle(CellEditEvent<SemesterActivity, String> event) {

						if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
							int index = event.getTablePosition().getRow();
							event.getTableView().getItems().get(index).setActivityName(event.getNewValue());
						}
					}
				});
		workloadTableNumberColumn
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<SemesterActivity, String>>() {

					@Override
					public void handle(CellEditEvent<SemesterActivity, String> event) {
						if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
							int index = event.getTablePosition().getRow();
							int value = 0;
							try {
								value = Integer.parseInt(event.getNewValue());
								event.getTableView().getItems().get(index).setNumber(value);
							} catch (NumberFormatException e) {
								// do nothing xd
								return;
							}
						}
					}
				});
		workloadTableHoursColumn
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<SemesterActivity, String>>() {

					@Override
					public void handle(CellEditEvent<SemesterActivity, String> event) {
						if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
							int index = event.getTablePosition().getRow();
							int value = 0;
							try {
								value = Integer.parseInt(event.getNewValue());
								event.getTableView().getItems().get(index).setDuration(value);
							} catch (NumberFormatException e) {
								// do nothing xd
								return;
							}
						}
					}
				});

		// Course Competency Edit
		competencyTable.setEditable(true);
		competencyTableDescriptionColumn.setEditable(true);
		competencyTableDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		competencyTableContributionColumn.setEditable(true);
		competencyTableContributionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		competencyTableRelatedLearningOutcomes.setEditable(true);
		competencyTableRelatedLearningOutcomes.setCellFactory(TextFieldTableCell.forTableColumn());
		competencyTableDescriptionColumn
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CourseCompetency, String>>() {

					@Override
					public void handle(CellEditEvent<CourseCompetency, String> event) {

						if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
							int index = event.getTablePosition().getRow();
							event.getTableView().getItems().get(index).setDescription(event.getNewValue());
						}
					}
				});
		competencyTableContributionColumn
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CourseCompetency, String>>() {

					@Override
					public void handle(CellEditEvent<CourseCompetency, String> event) {
						if ((event.getNewValue() != null) && !(event.getNewValue().isBlank())) {
							int index = event.getTablePosition().getRow();
							int value = 0;
							try {
								value = Integer.parseInt(event.getNewValue());
								event.getTableView().getItems().get(index).setContributionLevel(value);
							} catch (NumberFormatException e) {
								// do nothing xd
								return;
							}
						}
					}
				});
		competencyTableRelatedLearningOutcomes
				.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CourseCompetency, String>>() {

					@Override
					public void handle(CellEditEvent<CourseCompetency, String> event) {

						String newValue = event.getNewValue();
						if ((newValue != null) && !(newValue.isBlank())) {
							int index = event.getTablePosition().getRow();
							int limitValue = learningOutcomesTable.getItems().size();
							String[] sections = newValue.split(",", limitValue);
							LinkedHashSet<Integer> tempSet = new LinkedHashSet<Integer>();
							for (String lo : sections) {
								try {
									int intValue = Integer.parseInt(lo);
									tempSet.add(intValue);
								} catch (NumberFormatException e) {
									// do nothing xd
									return;
								}
							}
							competencyTable.getItems().get(index).setRelatedLearningOutcomes(tempSet);
							competencyTable.refresh();
						}
					}
				});

		// TEST ITEM - DO NOT REMOVE UNTIL THE END OF THE DEVELOPMENT PROCESS
		Course course = new Course();
		course.setCourseName("Principles of Software Engineering");
		course.setCode("SE 302");
		course.setCourseCoordinator("Assistant Professor//Kaya//O�uz");
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
		course.setCourseObjective(
				"In this course, students learn the theoretical and practical aspects of specification and design, development, verification and validation and testing stages of SE. More, this course enables students to realize software specification and design phases of sample projects with real clients.");
		course.addPrerequisite("SE 116 To succeed (To get a grade of at least DD)");
		course.setCourseDescription(
				"In this course, students learn the theoretical and practical aspects of specification and design, development, verification and validation and testing stages of SE. More, this course enables students to realize software specification and design phases of sample projects with real clients.");
		course.changeSchedule(1, "Introduction to Software Engineering", "Sommerville, Chapter 01");
		course.changeSchedule(2, "Software Processes", "Sommerville, Chapter 02, Pressman Chapter 02");
		course.addCompetency("	\r\n"
				+ "To have adequate knowledge in Mathematics, Science and Computer Engineering; to be able to use theoretical and applied information in these areas on complex engineering problems.",
				0, new LinkedHashSet<>());

	}

	// Method is used because of the "Simplification" Process
	public static String[] parseLecturer(String lecturer) {
		String[] lecturerSections = lecturer.split("//");
		String[] result = new String[3];
		if (lecturerSections.length > 1) {
			String tempTitle = lecturerSections[0];
			String title = AcademicTitle.tryParse(tempTitle);
			if (title != null) {
				result[0] = title;
				lecturerSections[0] = null;
			} else {
				result[0] = "";
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
