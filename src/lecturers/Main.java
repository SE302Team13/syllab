package lecturers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static final Scene scene = null;
	private static final Stage stage = null;


	@Override
	public void start(Stage primaryStage) throws Exception {
		
			Parent root = FXMLLoader.load(getClass().getResource("lecturer.fxml"));
		
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} 
	
	
	public static void main(String[] args) {
		launch(args);
	}
}


