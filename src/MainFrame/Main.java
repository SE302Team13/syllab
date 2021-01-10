package MainFrame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

	private static Stage primaryStage = null;
	private static BorderPane mainLayout = null;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		showMainFrame();
		// showfileScene(); Exception is thrown because the use of an unavailable element.
		// showOpen(); Exception is thrown because of the fxml file configuration. No Controller specified.
		// showOpenRecent(); Exception is thrown because of the fxml file configuration. No Controller specified.
		// showAbout() Exception is thrown because of the fxml file configuration. No Controller specified.
		// showhelpFile(); Exception is thrown because of the fxml file configuration. No Controller specified.
	}
	
	
	/**
	 * Private method to initialize core pane. Should not be used by any other method except start().
	 * @throws IOException 
	 */
	private static void showMainFrame() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Method to change the scene to MainItems.fxml
	 * @throws IOException
	 */
	public static void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}


	/**
	 * Method to change the scene to getSyllabusFromInternet.fxml
	 * @throws IOException
	 */
	public static void showGetSyllabusFromInternetScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("getsyllabusfrominternet/GetSyllabusFromInternet.fxml"));
		BorderPane GetSyllabusFromInternet = loader.load();
		mainLayout.setCenter(GetSyllabusFromInternet);

	}
	
	/**
	 * Method to change the scene to file.fxml
	 * @throws IOException
	 */
	public static void showfileScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("file/file.fxml"));
		BorderPane file = loader.load();
		mainLayout.setCenter(file);

	}

	/**
	 * Method to change the scene to OpenRecent.fxml
	 * @throws IOException
	 */
	public static void showOpenRecent() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("openrecent/OpenRecent.fxml"));
		BorderPane OpenRecent = loader.load();
		mainLayout.setCenter(OpenRecent);

	}

	/**
	 * Method to change the scene to open.fxml
	 * @throws IOException
	 */
	public static void showOpen() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("open_/open.fxml"));
		BorderPane open = loader.load();
		mainLayout.setCenter(open);
	}
	
	/**
	 * Method to change the scene to about.fxml
	 * @throws IOException
	 */
	public static void showAbout() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("about/about.fxml"));
		BorderPane about = loader.load();
		mainLayout.setCenter(about);
	}

	/**
	 * Method to change the scene to helpfile.fxml
	 * @throws IOException
	 */
	public static void showhelpFile() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("helpfile/helpfile.fxml"));
		BorderPane helpfile = loader.load();
		mainLayout.setCenter(helpfile);

	}

	/**
	 * Method to change the scene to githubrepository.fxml
	 * @throws IOException
	 */
	public static void showGitHubRepository() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("githubrepository/githubrepository.fxml"));
		BorderPane githubrepository = loader.load();
		mainLayout.setCenter(githubrepository);

	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
