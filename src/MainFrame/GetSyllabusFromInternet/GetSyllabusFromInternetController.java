package MainFrame.GetSyllabusFromInternet;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public void sendRequest(ActionEvent actionEvent) throws IOException {
		if (validate()) {
			URL url = new URL("https://syllab.azurewebsites.net/api/syllab?lang=tr&code=CE+221");
			InputStreamReader reader = new InputStreamReader(url.openStream());

			/*Gson gson = new Gson();

			BufferedReader br = new BufferedReader(
					new FileReader("E:file.json"));*/

			AcademicTitle academicTitleObj = new Gson().fromJson(reader, AcademicTitle.class);
			System.out.println(academicTitleObj.name());
			Course courseObj = new Gson().fromJson(reader, Course.class);
			CourseBook courseBookObj = new Gson().fromJson(reader, CourseBook.class);
			CourseCategory courseCategoryObj = new Gson().fromJson(reader, CourseCategory.class);
			CourseCompetency courseCompetencyObj = new Gson().fromJson(reader, CourseCompetency.class);
			CourseType courseTypeObj = new Gson().fromJson(reader, CourseType.class);
			EvaluationCriteria evaluationCriteriaObj = new Gson().fromJson(reader, EvaluationCriteria.class);
			Language languageObj = new Gson().fromJson(reader, Language.class);
			Lecturer lecturerObj = new Gson().fromJson(reader, Lecturer.class);
			SemesterActivity semesterActivityObj = new Gson().fromJson(reader, SemesterActivity.class);
			SemesterOptions semesterOptionsObj = new Gson().fromJson(reader, SemesterOptions.class);
			WeeklySubject weeklySubjectObj = new Gson().fromJson(reader, WeeklySubject.class);

			//Web service handler must be written here.
		}
	}
	
	
}
