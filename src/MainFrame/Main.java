package MainFrame;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("IEU Syllabus Manager");
		showMainFrame();
		showMainItems();
		
	}

	public void showMainItems() throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	
		
	}

	private void showMainFrame() throws IOException {
	
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(Main.class.getResource("view/MainFrame.fxml"));
	mainLayout = loader.load();
	Scene scene = new Scene(mainLayout);
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	
	public void showGetSyllabusFromInternetScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Get Syllabus from Internet/GetSyllabusFromInternet.fxml"));
		BorderPane GetSyllabusFromInternet = loader.load();
		mainLayout.setCenter(GetSyllabusFromInternet);
		
	}
	
	public static void showfileScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Create a new Syllabus/file.fxml"));
		BorderPane file = loader.load();
		mainLayout.setCenter(file);
		
	}
	
	public static void showOpenRecent() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Open Recent/OpenRecent.fxml"));
		BorderPane OpenRecent = loader.load();
		mainLayout.setCenter(OpenRecent);
		
	}
	
	public static void showaddStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Add.fxml"));
		BorderPane Add = loader.load();
		
		
	
	
	Stage addDialogStage = new Stage();
	addDialogStage.setTitle("Add");
	addDialogStage.initModality(Modality.WINDOW_MODAL);
	addDialogStage.initOwner(primaryStage);
	Scene scene = new Scene(Add);
	addDialogStage.setScene(scene);
	addDialogStage.showAndWait();
	
}
	
	public static void main(String[] args) {
		launch(args);
	
	}

	

	
}


