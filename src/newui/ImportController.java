package newui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXRadioButton;

import javafx.scene.image.ImageView;
import jsonModel.JSONParser;
import model.Language;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
	public void sendRequest(ActionEvent actionEvent) throws IOException {
		String codeWithoutSpace = courseCode.getText().replace(" ", "");
		String[] codes = codeWithoutSpace.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		String newCode = "";
		if(codes.length != 1)
			newCode = codes[0] + "+" + codes[1];
		else
			newCode = codes[0];
		
		String langCode = langTurkish.isSelected() ? "tr" : "en";

		String syllabUrl = "https://syllab.azurewebsites.net/api/syllab?lang=" + langCode + "&code=" + newCode;
		if (validate()) {
			URL url = new URL(syllabUrl);
			InputStreamReader reader = new InputStreamReader(url.openStream());

			JSONParser parsedObj = new Gson().fromJson(reader, JSONParser.class);
			
			System.out.println(parsedObj.getName());
		}
	}
}
