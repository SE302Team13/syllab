package MainFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainViewController {
	@FXML
	public void createSyllabus(ActionEvent actionEvent) throws IOException {
        Main.showMainItems();
	}

	@FXML
	public void getSyllabus(ActionEvent actionEvent) throws IOException {
		Main.showGetSyllabusFromInternetScene();
	}

	@FXML
	public void open(ActionEvent actionEvent) throws IOException {
		Main.showOpen();
	}

	@FXML
	public void openRecent(ActionEvent actionEvent) throws IOException {
		Main.showOpenRecent();
	}

	@FXML
	public void about(ActionEvent actionEvent) throws IOException {
		Main.showAbout();
	}

	@FXML
	public void helpFile(ActionEvent actionEvent) throws IOException {
       Main.showhelpFile();
	}

	@FXML
	public void githubRepo(ActionEvent actionEvent) throws IOException {
       Main.showGitHubRepository();
	}

	@FXML
	public void exit(ActionEvent actionEvent) {
		System.exit(0);
	}
	/*
	 * private Main main;
	 * 
	 * @FXML private void gohomepage() throws IOException { main.showMainItems();
	 * 
	 */
}
