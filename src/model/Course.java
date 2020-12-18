package model;

import java.util.ArrayList;
import java.util.Date;



/**
 * 
 * @author Hakan Ayaz
 * @version 1.0
 * 
 */
public class Course {
	
	
	/**
	 * Complete name of the course
	 */
	String courseName;
	
	/**
	 * Unique identifier for a course. 
	 */
	String code;
	
	/**
	 * Creation date of the course syllabus to differentiate
	 * this syllabus from others for the same course
	 */
	Date creationDate;
	
	/**
	 * The courses that should be completed before taking this one
	 */
	ArrayList<String> prerequisites;
	
	/**
	 * Specifies the course language
	 */
	Language courseLang;
	
	/**
	 * 
	 */
	SemesterOptions semester;
}
