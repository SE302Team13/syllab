package mainfunctions;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent parent = new BorderPane();
		primaryStage.setScene(new Scene(parent));
		primaryStage.show();
		primaryStage.setTitle("Testing");
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
