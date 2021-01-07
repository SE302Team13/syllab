module TermProject {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	
	opens MainFrame;
	opens MainFrame.view;
	opens MainFrame.file;
	opens MainFrame.about;
	opens MainFrame.getsyllabusfrominternet;
	opens MainFrame.githubrepository;
	opens MainFrame.helpfile;
	opens MainFrame.open_;
	opens MainFrame.openrecent;
	
}