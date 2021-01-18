package newui;

import java.io.File;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HTMLViewerController {

	@FXML
	private WebView webViewer;
	@FXML
	private ImageView closeButton;
	@FXML
	private ImageView maximizeButton;
	@FXML
	private ImageView minimizeButton;
	@FXML
	private HBox topPane;

	// Position values for the dragging event
	private double mouseXPosition = 0;
	private double mouseYPosition = 0;

	@FXML
	public void initialize() {

		// Close Button functionalities
		closeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				topPane.getScene().getWindow().hide();
			}
		});

		// Minimize button functionalities
		minimizeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Main.generalStage.setIconified(true);
			}
		});
		
		// Maximize Button functionality
		maximizeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				Stage minorStage = (Stage) topPane.getScene().getWindow();
				if (minorStage.isFullScreen()) {
					minorStage.setFullScreen(false);
				} else {
					minorStage.setFullScreen(true);
				}
			}
		});

		// Adding draggability
		topPane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				mouseXPosition = event.getX();
				mouseYPosition = event.getY();
			}
		});

		topPane.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				topPane.getScene().getWindow().setX(event.getScreenX() - mouseXPosition);
				topPane.getScene().getWindow().setY(event.getScreenY() - mouseYPosition);
				;
			}
		});
	}
	
	
	public void setHTMLFile(File file) {
		if ((file != null) && (file.getName().endsWith(".html"))) {
			webViewer.getEngine().load("file://" +file.getAbsolutePath());
		}
	}
	

}
