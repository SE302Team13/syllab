package MainFrame;

import javafx.fxml.FXML;

import java.io.IOException;

import MainFrame.Main;

public class MainViewController {
	
	private Main main;
	
	@FXML
	private void gohomepage() throws IOException {
	main.showMainItems();

}
}
