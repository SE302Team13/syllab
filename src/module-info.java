module TermProject {
	
	
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires com.google.gson;
	requires com.jfoenix;
	requires org.controlsfx.controls;
	requires javafx.web;
	requires java.desktop;
	requires chunk.templates;
	
	exports model
	      to chunk.templates;
	
	exports jsonModel 
		  to com.google.gson;
	
	opens jsonModel 
	  to com.google.gson;
	
	opens newui;

	
}