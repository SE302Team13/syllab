package MainFrame.GetSyllabusFromInternet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class GetSyllabusFromInternetController {
	
	@FXML
	private RadioButton turkishButton;
	@FXML
	private RadioButton englishButton;
	@FXML
	private  TextField courseCode;
	@FXML
	private Button submit;
	
	
	public void initialize() {
		englishButton.setSelected(true);
	}
	
	
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
	public void sendRequest(ActionEvent actionEvent) {
		if (validate()) {
			
			//Web service handler must be written here.
		}
	}
	
	
}
