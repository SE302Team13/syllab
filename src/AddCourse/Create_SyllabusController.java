package AddCourse;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Create_SyllabusController implements Initializable {
	
	@FXML
	private TextField courseName;
	@FXML
	private TextField courseCode;
	@FXML
	private TextField semester;
	@FXML
	private TextField theory;
	@FXML
	private TextField lab;
	@FXML
	private TextField localCredits;
	@FXML
	private TextField ects;
	@FXML
	private TextField prerequisites;
	@FXML
	private TextField courseLanguage;
	@FXML
	private TextField courseType;
	@FXML
	private TextField courseLevel;
	@FXML
	private TextField addCourse;
	@FXML
	private TextField exit;
	
	Button exitButton;
	Button saveButton;
	
	@Override

	public void initialize( URL arg0, ResourceBundle arg1 ) {
		
	}
	
	@FXML
	 void addCourse(ActionEvent event) {
		
	}
	@FXML
	 void exitButton(ActionEvent event) {
		Platform.exit();
		System.exit(0);
		
	}
	
}
