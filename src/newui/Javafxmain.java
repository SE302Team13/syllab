package newui;

import java.io.IOException;
import initializer.Initializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Javafxmain extends Application {

	public static Stage generalStage = null;

	/*
	 * TODO Handle exception Here
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		generalStage = primaryStage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("fxml/main.fxml"));
		BorderPane generalLayout = loader.load();
		generalStage.setTitle("IEU Syllabus Control/Edit System");
		generalStage.initStyle(StageStyle.UNDECORATED);
		generalStage.setScene(new Scene(generalLayout));
		generalStage.show();
		
	}

	@Override
	public void init() throws Exception {
		Initializer.readLocations();
		Initializer.loadAll();
	}

	@Override
	public void stop() throws Exception {
		Initializer.totalSave();
		Initializer.commitLocations();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
