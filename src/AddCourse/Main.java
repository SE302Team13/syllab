package AddCourse;
	
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Stage stage;
	private Scene scene;


	@Override
	public void start(Stage primaryStage) throws Exception {
		
			Parent root = FXMLLoader.load(getClass().getResource("Create_Syllabus.fxml"));
		//	Scene scene = new Scene(root,650,500);
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
