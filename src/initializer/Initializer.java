package initializer;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Course;
import model.CourseBook;
import model.Lecturer;

public class Initializer {
	
	private final static ObservableList<Course> allCourseList = FXCollections.observableArrayList();
	private final static Path coursePath = Path.of("data", "courses");
	private final int positionKeeper = 0;
	
	//This class can not be constructed
	private Initializer() {
	}
	
	
	public static void save() {
		
	}
	
	public static void initialize() {
		
	}
	
	public static ObservableList<Course> getCourses() {
		return allCourseList;
	}
	
	public static void importCourse(File file) {
		
	}

}
