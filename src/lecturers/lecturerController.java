package lecturers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class lecturerController implements Initializable {
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private TextField courseCoordinator;
	@FXML
	private TextField courseLecturer;
	@FXML
	private TextField assistant;
	@FXML
	private TextField exit;
	@FXML
	private TextField saveButton;
	
	
	@FXML
	public void exit(ActionEvent event) {
		Platform.exit();
		System.exit(0);
		
	}
	
	@FXML
	public void courseCoordinator(ActionEvent event) {
		
	}
	
	@FXML
	public void assistant(ActionEvent event) {
		
	}
	

    @FXML
     void saveButton(ActionEvent event) {
	
}
}
