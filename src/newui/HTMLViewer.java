package newui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HTMLViewer {
	
	
	
	public HTMLViewer(File HTMLFile) throws IOException {

		Stage minorStage = new Stage(StageStyle.UNDECORATED);
		FXMLLoader loader = new FXMLLoader(Path.of("src", "newui", "fxml", "htmlviewer.fxml").toUri().toURL());
		AnchorPane generalPane = loader.load();
		HTMLViewerController controller = loader.getController();
		controller.setHTMLFile(HTMLFile);
		minorStage.setScene(new Scene(generalPane));
		minorStage.showAndWait();
	}

}
