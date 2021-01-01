package MainFrame.view;

import java.io.IOException;

import MainFrame.Main;
import javafx.fxml.FXML;

public class MainItemsController {
	
	
	private Main main;
	
	@FXML
	
	private void goCreateanewSyllabus() throws IOException {
		main.showfileScene();
		
	}
	
	@FXML
	
	private void goGetSyllabusFromInternet() throws IOException {
		main.showGetSyllabusFromInternetScene();
	}

}
