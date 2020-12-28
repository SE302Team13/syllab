package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;



/**
 * 
 * @author Hakan Ayaz
 * @version 0.1
 * 
 */
public class Course {
	
	//Field(s)
	
	/**
	 * Complete name of the course
	 */
	private String courseName;
	
	/**
	 * Unique identifier for a course 
	 */
	private String code;
	
	/**
	 * Creation date of the course syllabus to differentiate
	 * this syllabus from others for the same course
	 */
	private LocalDateTime creationDate;
	
	/**
	 * The courses that should be completed before taking this one
	 */
	private ArrayList<String> prerequisites;
	
	/**
	 * Specifies the course language
	 */
	private Language courseLang;
	
	/**
	 * Specifies the semester(s) the course will be given
	 */
	private SemesterOptions semester;
	
	/**
	 * Shows the local credit for the course and calculated by the program itself
	 * according to the pseudo code below ;
	 * localCredit = round(theoreticalHour + (0.5  * labHour))
	 * @see #calculateLocalCredit()
	 */
	private int localCredit;
	
	/**
	 * Shows the ECTS equivalent value of the course
	 * This value is calculated by the program itself according the pseudo code below ;
	 * ECTS = round(sumAll(workload of each element in workloadTable) / 30)
	 * @see #calculateECTS() 
	 *
	 */
	private int ects;
	
	/**
	 * Theoretical hours per week for the course.
	 */
	private int theoreticalHour;
	
	/**
	 * Lab/Application hours per week for the course.
	 */
	private int labHour;
	
	/**
	 * Course type
	 */
	private CourseType type;
	
	/**
	 * Coordinator of the course. There can only be 1 coordinator and 
	 * he must be a teacher
	 */
	private Lecturer courseCordinator;
	
	/**
	 * Lecturers who give this course.
	 * There can be more then one lecturer
	 * @see #addLecturer(Lecturer)
	 * @see #removeLecturer(Lecturer)
	 */
	private ArrayList<Lecturer> courseLecturers;
	
	/**
	 * Assistants of this course.
	 * There can be more then one assistant.
	 * @see #addAssistant(Lecturer)
	 * @see #removeAssistant(Lecturer)
	 */
	private ArrayList<Lecturer> assistants;
	
	/**
	 * Course objective summary.
	 */
	private String courseObjective;
	
	/**
	 * Learning outcomes as a String ArrayList.
	 * Order of the array is relevant because {@link EvaluationCriteria} field
	 * is using the order of the array the identify different learning outcomes.
	 * @see #addCriteria(EvaluationCriteria)
	 */
	private ArrayList<String> learningOutcomes;
	
	/**
	 * Course Description summary.
	 */
	private String courseDescription;
	
	/**
	 * One of the categories from {@link CourseCategory} enumerator.
	 * @see CourseCategory
	 */
	private CourseCategory courseCategory;
	
	/**
	 * Course Schedule with 16 weeks (16 object).
	 * Weeks are created at the construction state of the object.
	 * User will not be able to delete a week. But field(s) of a {@link WeeklySubject}
	 * may be changed to accommodate the requirements. 
	 * @see #changeSchedule(int, String, String)
	 */
	private ArrayList<WeeklySubject> courseSchedule;
	
	/**
	 * General course textbook.
	 */
	private CourseBook courseTextBook;
	
	/**
	 * Suggested readings for this course
	 */
	private ArrayList<CourseBook> suggestedReading;
	
	/**
	 * Evaluation criterias for the grading of the course. An {@link EvaluationCriteria} object contains
	 * information about criteria name, contribution to the grade percentage and indications
	 * to the related learning outcomes.
	 * @see EvaluationCriteria
	 * @see #learningOutcomes
	 */
	private ArrayList<EvaluationCriteria> evaluationCriterias;
	
	/**
	 * Workload table contains activities and specifies the hours for every activity
	 * in one semester.
	 * @see SemesterActivity
	 */
	private ArrayList<SemesterActivity> workloadTable;
	
	/**
	 * Course Competencies shows the outcome of the course with the associated learning
	 * outcomes. 
	 */
	private ArrayList<CourseCompetency> courseCompetencies;
	
	//Constructor(s)
	/**
	 * 
	 * @param courseName Name of the course
	 * @param code Abbreviated name of the course
	 * @param prerequisites Prerequisite courses for this course in ArrayList form
	 * @param courseLang 
	 * @param semester
	 * @param theoreticalHour
	 * @param labHour
	 * @param type
	 * @param cordinator
	 * @param lecturers
	 * @param assistants
	 * @param courseObjective
	 * @param learningOutcomes
	 * @param courseDescription
	 * @param category
	 * @param schedule
	 * @param courseBook
	 * @param suggestedReading
	 * @param evaluationCriterias
	 * @param workloadTable
	 * @param courseCompetencies
	 */
	public Course(String courseName, String code, ArrayList<String> prerequisites, Language courseLang,
			SemesterOptions semester, int theoreticalHour, int labHour, CourseType type, Lecturer coordinator,
			LinkedHashSet<Lecturer> lecturers, LinkedHashSet<Lecturer> assistants, String courseObjective,
			LinkedHashSet<String> learningOutcomes, String courseDescription, CourseCategory category,
			LinkedHashSet<WeeklySubject> schedule, CourseBook courseBook, LinkedHashSet<CourseBook> suggestedReading,
			LinkedHashSet<EvaluationCriteria> evaluationCriterias, LinkedHashSet<SemesterActivity> workloadTable,
			LinkedHashSet<CourseCompetency> courseCompetencies) {
		this.courseName = courseName;
		this.code = code;
		this.creationDate = LocalDateTime.now();
		this.prerequisites = prerequisites;
		this.courseLang = courseLang;
		this.labHour = labHour;
		this.theoreticalHour = theoreticalHour;
		this.localCredit = calculateLocalCredit();
		this.ects = calculateECTS();
		this.type = type;
		this.courseCordinator = coordinator;
		this.courseLecturers = new ArrayList<>(lecturers);
		this.assistants = new ArrayList<>(assistants);
		this.courseObjective = courseObjective;
		this.courseDescription = courseDescription;
		this.learningOutcomes = new ArrayList<>(learningOutcomes);
		this.courseCategory = category;
		this.courseSchedule = new ArrayList<>(schedule);
		this.courseTextBook = courseBook;
		this.suggestedReading = new ArrayList<>(suggestedReading);
		this.evaluationCriterias = new ArrayList<>(evaluationCriterias);
		this.workloadTable = new ArrayList<>(workloadTable);
		this.courseCompetencies = new ArrayList<>(courseCompetencies);
	}
	
	
	
	//Method(s)
	
	public boolean addPrerequisite(String courseCode) {
		for (String required : prerequisites) {
			if (required.equalsIgnoreCase(courseCode)) {
				return false;
			}
		}
		return prerequisites.add(courseCode);
	}
	
	public boolean removePrerequisite(String course) {
		return prerequisites.remove(course);
	}
	
	public int calculateECTS() {
		int totalWorkload = 0;
		for (SemesterActivity activity : workloadTable) {
			totalWorkload += activity.getWorkload();
		}
		return ects = (int) Math.round(totalWorkload / 30.0);
		
		
	}
	
	public int calculateLocalCredit() {
		return localCredit = (int) (theoreticalHour + Math.round((0.5*labHour)));
	}
	
	public boolean addLecturer(Lecturer lecturer) {
		if (!courseLecturers.contains(lecturer)) {
			return courseLecturers.add(lecturer);
		}
		return false;
	}
	
	//Add restrictions and confirmation for the validity of inputs on this method
	public boolean addLecturer(String lecName, String lecSurname, AcademicTitle title) {
		return addLecturer(new Lecturer(lecName, lecSurname, title));
	}
	
	public boolean removeLecturer(Lecturer lec) {
		return courseLecturers.remove(lec);
	}
	
	public boolean addAssistant(Lecturer assistant) {
		if (!assistants.contains(assistant)) {
			return courseLecturers.add(assistant);
		}
		return false;
	}
	
	//Add restrictions and confirmation for the validity of inputs on this method
	public boolean addAssistant(String lecName, String lecSurname, AcademicTitle title) {
		return addAssistant(new Lecturer(lecName, lecSurname, title));
	}
	
	public boolean removeAssistant(Lecturer lecturer) {
		return assistants.remove(lecturer);
	}
	
	public boolean changeSchedule(int week, String desc, String rm) {
		if ((week > 0) && (week < 17) && !desc.isBlank()) {
			WeeklySubject subj =  courseSchedule.get(week-1);
			return subj.setDescription(desc) && subj.setRelatedMaterial(rm);
		}
		return false;
	}
	
	public boolean addReading(CourseBook book) {
		if (!suggestedReading.contains(book)) {
			return suggestedReading.add(book);
		}
		return false;
	}
	
	//Add restrictions and confirmation for the validity of inputs on this method
	public boolean addReading(String name, int edition, String author) {
		return addReading(new CourseBook(name, edition, author));
	}
	
	public boolean removeReading(CourseBook book) {
		return suggestedReading.remove(book);
	}
	
	public boolean addCriteria(EvaluationCriteria criteria) {
		if (!evaluationCriterias.contains(criteria)) {
			return evaluationCriterias.add(criteria);
		}
		return false;
	}
	
	//Add restrictions and confirmation for the validity of inputs on this method
	public boolean addCriteria(String name, int count, int contr, ArrayList<Integer> values) {
		return addCriteria(new EvaluationCriteria(name, count, contr, values));
	}
	
	public boolean removeCriteria(EvaluationCriteria criteria) {
		return evaluationCriterias.remove(criteria);
	}
	
	//Add restrictions and confirmation for the validity of inputs on this method
	public boolean changeCriteria(EvaluationCriteria criteria, String name,
			int count, int contribution, ArrayList<Integer> contributionLevels) {
		
		criteria.setContributionLevels(contributionLevels);
		return criteria.setName(name) && criteria.setCount(count) &&
				criteria.setContribution(contribution);
	}

	//Add restrictions and confirmation for the validity of inputs on this method
	public boolean addWorkload(SemesterActivity activity) {
		if (!workloadTable.contains(activity)) {
			return workloadTable.add(activity);
		}
		return false;
	}
	
	public boolean addWorkload(String actName, int number, int duration) {
		return addWorkload(new SemesterActivity(actName, number, duration));
	}
	
	public boolean removeWorkload(SemesterActivity act) {
		return workloadTable.remove(act);
	}
	
	//Add restrictions and confirmation for the validity of inputs on this method
	public boolean adjustWorkload(SemesterActivity activity, int number, int duration) {
		return activity.setNumber(number) && activity.setDuration(duration);
	}
	
	public boolean addCompetency(CourseCompetency competency) {
		if (!courseCompetencies.contains(competency)) {
			return courseCompetencies.add(competency);
		}
		return false;
	}
	
	//Add restrictions and confirmation for the validity of inputs on this method
	public boolean addCompetency(String description, int contLevel,
			LinkedHashSet<Integer> relatedLearningOutcomes) {
		return addCompetency(new CourseCompetency(description, contLevel, relatedLearningOutcomes));
	}
	
	public boolean removeCompetency(CourseCompetency competency) {
		return courseCompetencies.remove(competency);
	}
	
	//Add restrictions and confirmation for the validity of inputs on this method
	public boolean adjustCompetency(CourseCompetency competency, String description,
			int contLevel, ArrayList<Integer> relatedLearningOutcomes) {
		competency.setDescription(description);
		competency.setContributionLevel(contLevel);
		competency.setRelatedLearningOutcomes(relatedLearningOutcomes);
		return true;
	}
	
	//Getter(s) and Setter(s)
	
	public String getCourseName() {
		return courseName;
	}
	
	
	public String getCode() {
		return code;
	}


	public LocalDateTime getCreationDate() {
		return creationDate;
	}


	public ArrayList<String> getPrerequisites() {
		return prerequisites;
	}


	public Language getCourseLang() {
		return courseLang;
	}


	public SemesterOptions getSemester() {
		return semester;
	}


	public int getLocalCredit() {
		return localCredit;
	}


	public int getEcts() {
		return ects;
	}


	public int getTheoreticalHour() {
		return theoreticalHour;
	}


	public int getLabHour() {
		return labHour;
	}


	public CourseType getType() {
		return type;
	}


	public Lecturer getCourseCordinator() {
		return courseCordinator;
	}
	

	public ArrayList<Lecturer> getCourseLecturers() {
		return courseLecturers;
	}


	public ArrayList<Lecturer> getAssistants() {
		return assistants;
	}


	public String getCourseObjective() {
		return courseObjective;
	}


	public ArrayList<String> getLearningOutcomes() {
		return learningOutcomes;
	}


	public String getCourseDescription() {
		return courseDescription;
	}


	public CourseCategory getCourseCategory() {
		return courseCategory;
	}


	public ArrayList<WeeklySubject> getCourseSchedule() {
		return courseSchedule;
	}


	public CourseBook getCourseTextBook() {
		return courseTextBook;
	}


	public ArrayList<CourseBook> getSuggestedReading() {
		return suggestedReading;
	}


	public ArrayList<EvaluationCriteria> getEvaluationCriterias() {
		return evaluationCriterias;
	}


	public ArrayList<SemesterActivity> getWorkloadTable() {
		return workloadTable;
	}


	public ArrayList<CourseCompetency> getCourseCompetency() {
		return courseCompetencies;
	}
	
	
	public boolean setCourseName(String courseName) {
		if (!(courseName.isBlank()) || (courseName.length() > 4)) {
			this.courseName = courseName;
			return true;
		}
		return false;
	}

	
	public boolean setCode(String code) {
		if (code.length() > 4) {
			this.code = code;
			return true;
		}
		return false;
	}


	public void setCourseLang(Language courseLang) {
		this.courseLang = courseLang;
	}


	public void setSemester(SemesterOptions semester) {
		this.semester = semester;
	}


	public void setLabHour(int labHour) {
		if (labHour >= 0) {
			this.labHour = labHour;
			calculateLocalCredit();
		}
	}
	
	
	public void setTheoreticalHour(int theoreticalHour) {
		if (theoreticalHour >= 0) {
			this.theoreticalHour = theoreticalHour;
			calculateLocalCredit();
		}
	}


	public void setType(CourseType type) {
		this.type = type;
	}

	
	public void setCourseCordinator(Lecturer courseCordinator) {
		this.courseCordinator = courseCordinator;
	}

	
	public void setCourseObjective(String courseObjective) {
		if (!courseObjective.isBlank()) {
			this.courseObjective = courseObjective;
		}
	}

	
	public void setCourseDescription(String courseDescription) {
		if (!courseDescription.isBlank()) {
			this.courseDescription = courseDescription;
		}
	}

	
	public void setCourseCategory(CourseCategory courseCategory) {
		this.courseCategory = courseCategory;
	}


	public void setCourseTextBook(CourseBook courseTextBook) {
		this.courseTextBook = courseTextBook;
	}
	
	
}
