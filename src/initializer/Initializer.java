package initializer;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;

import model.Course;

/**
 * First (alpha) version of the IO controller of the program.
 * @version 0.1
 * @author Hakan Ayaz
 *
 */
public class Initializer {
	
	
	/*
	 * Written for testing purposes. This class will not contain a main method
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		load();
		System.out.print("Previous Object Number: " + courseData.size() + "\n");
		for (int i = 0; i < courseData.size() ; i++) {
			System.out.printf("Name of the course: %s\n"
							+ "Code of the course: %s\n", courseData.get(i).getCourseName(), courseData.get(i).getCode());
		}
		Course temp = new Course();
		temp.setCourseName("TestingCourse123");
		temp.setCode("T111");
		courseData.add(temp);
		temp = new Course();
		temp.setCourseName("TestingCourse234");
		temp.setCode("T222");
		courseData.add(temp);
		temp = new Course();
		temp.setCourseName("TestingCourse345");
		temp.setCode("T333");
		courseData.add(temp);
		temp = new Course();
		temp.setCourseName("TestingCourse456");
		temp.setCode("T444");
		courseData.add(temp);
		save();
	}
	
	/**
	 * Holder Array for the course Objects.
	 */
	private static final ArrayList<Course> courseData = new ArrayList<>();
	
	/**
	 * Path for the course.syb file to read and write objects.
	 */
	private static final Path dataPath = Path.of("data", "courses.syb").toAbsolutePath();
	
	
	/**
	 * Loader method which loads courses from file to the program.
	 * @throws ClassNotFoundException This exception will be properly handled soon. Don't worry about it.
	 * @throws IOException This exception will be properly handled soon. Don't worry about it.
	 */
	public static void load() throws ClassNotFoundException, IOException{
		File recordFile = dataPath.toFile();
		if (!recordFile.exists()) {
			recordFile.getParentFile().mkdir();
			recordFile.createNewFile();
		}
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(recordFile);
			if (stream.available() > 0) {
				ObjectInputStream objStream = new ObjectInputStream(stream);
				while (true) {
					try {
						Course temp = (Course) objStream.readObject();
						courseData.add(temp);
					} catch (EOFException e) {
						break;
					}
				}
				objStream.close();
			}
		} finally {
			stream.close();
		}
		
	}
	
	/**
	 * Save method to convert and save in a file.
	 * @throws IOException This exception will be properly handled soon. Don't worry about it.
	 */
	public static void save() throws IOException {
		ObjectOutputStream stream = null;
		try {
			stream = new ObjectOutputStream(
					new FileOutputStream(dataPath.toFile()));
			for (Course course: courseData) {
				stream.writeObject(course);
				stream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			stream.close();
		}

	}
	
	
}
