module TermProject {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
    requires gson;

	opens MainFrame;
	opens MainFrame.view;
	opens MainFrame.file;
	opens MainFrame.about;
	opens MainFrame.GetSyllabusFromInternet;
	opens MainFrame.GitHubRepository;
	opens MainFrame.helpFile;
	opens MainFrame.open_;
	opens MainFrame.OpenRecent;
	
}