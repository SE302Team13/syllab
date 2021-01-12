module TermProject {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires com.google.gson;
	requires java.desktop;
	requires com.jfoenix;
	requires org.controlsfx.controls;
    //requires gson;
	
	/*
	opens MainFrame;
	opens MainFrame.view;
	opens MainFrame.about;
	opens MainFrame.GetSyllabusFromInternet;
	opens MainFrame.GitHubRepository;
	opens MainFrame.helpFile;
	opens MainFrame.open_;
	opens MainFrame.OpenRecent;
	*/
	opens newui;
	
}