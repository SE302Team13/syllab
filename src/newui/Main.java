package newui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	public static Stage generalStage = null;
	
	/*
	 * TODO Handle exception Here
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		generalStage = primaryStage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("fxml/main.fxml"));
		BorderPane generalLayout = loader.load();
		generalStage.setTitle("IEU Syllabus Control/Edit System");
		// generalStage.initModality(Modality.NONE); This will be added after proper button actions
		generalStage.setScene(new Scene(generalLayout));
		generalStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
