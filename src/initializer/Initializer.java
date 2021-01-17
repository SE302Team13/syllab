package initializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.ZoneOffset;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Course;

public class Initializer {

	private final static ObservableList<Course> allCourseList = FXCollections.observableArrayList();
	private final static Path coursePath = Path.of("data", "courses");
	private final static Path locationsFile = Path.of("data", ".locate");
	private final static ArrayList<String> locations = new ArrayList<>();

	// This class can not be constructed
	private Initializer() {
	}

	public static void totalSave() throws IOException {
		clearDocument();
		for (int index = 0; index < allCourseList.size(); index++) {
			save(index);
		}
	}
	
	
	public static void clearDocument() {
		File[] lastSaves = coursePath.toFile().listFiles();
		for (File deleted : lastSaves) {
			if (deleted.exists() && deleted.isFile() && deleted.getName().endsWith(".syb")) {
				deleted.delete();
			}
		}
	}

	public static void save(int index) throws IOException {
		if (index < allCourseList.size()) {
			Course course = allCourseList.get(index);
			String fileName = course.getCode() + "-" 
					+ course.getCreationDate()
					.toEpochSecond(ZoneOffset.UTC)
					+ ".syb";
			Path savePath = coursePath.resolve(fileName);
			File saveFile = savePath.toFile();
			if (!saveFile.getParentFile().exists()) {
				saveFile.getParentFile().mkdirs();
			}
			if (!saveFile.exists()) {
				saveFile.createNewFile();
			}
			ObjectOutputStream stream = null;
			stream = new ObjectOutputStream(new FileOutputStream(saveFile.getAbsoluteFile(), false));
			stream.writeObject(course);
			stream.flush();
			locations.add(saveFile.getAbsolutePath());
			stream.close();
		}
	}

	public static void commitLocations() throws IOException {
		BufferedWriter writer = Files.newBufferedWriter(locationsFile, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
		writer.write("" + locations.size());
		writer.newLine();
		for (String location : locations) {
			writer.write(location);
			writer.newLine();
		}
		writer.flush();
		writer.close();
	}

	public static void readLocations() throws IOException {
		File realFile = locationsFile.toFile();
		if(!realFile.getParentFile().exists()) {
			realFile.getParentFile().mkdirs();
		}
		if(!realFile.exists()) {
			realFile.createNewFile();
		}
		BufferedReader reader = Files.newBufferedReader(locationsFile);
		Object[] arr = reader.lines().toArray();
		reader.close();
		ArrayList<String> locString = new ArrayList<>();
		for (Object obj : arr) {
			if (obj instanceof String) {
				locString.add((String) obj);
			}
		}
		if (locString.size() > 0) {
			String data = locString.get(0);
			int locationCount = Integer.parseInt(data);
			for (int counter = 1; counter <= locationCount; counter++) {
				locations.add(locString.get(counter));
			}
		}
	}
	
	public static boolean load(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		if (file != null && file.exists()) {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
			Object obj = stream.readObject();
			if (obj instanceof Course) {
				Course course = (Course) obj;
				allCourseList.add(course);
				stream.close();
				return true;
			}
			stream.close();
		}
		return false;
	}

	public static void loadAll() throws FileNotFoundException, ClassNotFoundException, IOException {
		for (String location : locations) {
			File file = new File(location);
			load(file);
		}
		locations.clear();
	}

	public static ObservableList<Course> getCourses() {
		return allCourseList;
	}

}
