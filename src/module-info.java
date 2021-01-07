module TermProject {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens mainfunctions;
	opens MainFrame;
	opens MainFrame.file;
	opens MainFrame.about;
	opens MainFrame.GetSyllabusFromInternet;
}