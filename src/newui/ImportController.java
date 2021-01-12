package newui;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;

import com.jfoenix.controls.JFXRadioButton;

import javafx.scene.image.ImageView;

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

}
