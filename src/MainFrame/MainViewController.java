package MainFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


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
        try {
            Desktop.getDesktop().browse(new URI("http://setps.ieu.edu.tr/static/tasks/task_point_system.pdf"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }	}

	@FXML
	public void githubRepo(ActionEvent actionEvent) throws IOException {
        try {
            Desktop.getDesktop().browse(new URI("http://www.github.com/SE302Team13/syllab"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
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
