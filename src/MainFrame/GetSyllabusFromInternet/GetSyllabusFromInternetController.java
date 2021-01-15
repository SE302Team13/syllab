package MainFrame.GetSyllabusFromInternet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	public void sendRequest(ActionEvent actionEvent, Language language, String code) throws IOException {
		String codeWithoutSpace = code.replace(" ", "");
		String inverseOfTheCode = new String();
		String newCode = new String();
		int index = 2;

		for(int i = codeWithoutSpace.length(); i > 0; i--){
			inverseOfTheCode += codeWithoutSpace.charAt(i);
			if(i == index){
				inverseOfTheCode += "+";
			}
		}
		for(int i = codeWithoutSpace.length(); i > 0; i--){
			newCode += codeWithoutSpace.charAt(i);
		}
		String syllabUrl = "https://syllab.azurewebsites.net/api/syllab?lang=" + language + "&code=" + newCode;
		if (validate()) {
			URL url = new URL(syllabUrl);
			InputStreamReader reader = new InputStreamReader(url.openStream());
			Object obj = JSONParser.parse(reader);
			JSONObject jo = (JSONObject) obj;

			/* getting all values */
			String name = (String) jo.get("name");
			String code_ = (String) jo.get("code");
			String weekly_hours = (String) jo.get("weekly_hours");
			int app_hours = (int) jo.get("app_hours");
			String ieu_credit = (String) jo.get("ieu_credit");
			String ects_credit = (String) jo.get("ects_credit");
			String pre_req = (String) jo.get("pre_req");
			String course_lang = (String) jo.get("course_lang");
			CourseType course_type = (String) jo.get("course_type");
			CourseLevel level = (String) jo.get("level");

			JSONArray ja_lecturers = (JSONArray) jo.get("lecturers"); /* array with objects*/
			JSONArray ja_assistans = (JSONArray) jo.get("assistants"); /* array with objects*/
			JSONArray ja_coordinators = (JSONArray) jo.get("coordinators"); /* array with objects*/

			List<String> listForLecturerDatas = new ArrayList<String>();
			for(int i = 0 ; i < ja_lecturers.length(); i++) {
				listForLecturerDatas.add(ja_lecturers.getJSONObject(i).getString("link"));
				listForLecturerDatas.add(ja_lecturers.getJSONObject(i).getString("name"));
			}
			List<String> listForAssistanDatas = new ArrayList<String>();
			for(int i = 0 ; i < ja_assistans.length(); i++) {
				listForAssistanDatas.add(ja_assistans.getJSONObject(i).getString("link"));
				listForAssistanDatas.add(ja_assistans.getJSONObject(i).getString("name"));
			}
			List<String> listForCoordinatorDatas = new ArrayList<String>();
			for(int i = 0 ; i < ja_coordinators.length(); i++) {
				listForCoordinatorDatas.add(ja_coordinators.getJSONObject(i).getString("link"));
				listForCoordinatorDatas.add(ja_coordinators.getJSONObject(i).getString("name"));
			}

			Map categories = ((Map)jo.get("categories"));
			List<String> categoriesList = new ArrayList<String>();
			Iterator<Map.Entry> itr1 = categories.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				categoriesList.add((String) pair.getValue());
			}

			Map weekly_subjects = ((Map)jo.get("weekly_subjects"));
			List<String> listForWeeklySubjectsDatas = new ArrayList<String>();
			Iterator<Map.Entry> itr2 = categories.entrySet().iterator();
			while (itr2.hasNext()) {
				Map.Entry pair = itr2.next();
				System.out.println(pair.getKey() + " : " + pair.getValue());
			}

			Map workload_table = ((Map)jo.get("workload_table"));
			Iterator<Map.Entry> itr3 = categories.entrySet().iterator();
			while (itr2.hasNext()) {
				Map.Entry pair = itr3.next();
				System.out.println(pair.getKey() + " : " + pair.getValue());
			}
		}
	}
}