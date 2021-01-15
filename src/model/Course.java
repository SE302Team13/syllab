package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 
 * @author Hakan Ayaz
 * @version 1.0
 * 
 */
public class Course {

	// Field(s)

	/**
	 * Complete name of the course
	 */
	private String courseName;

	/**
	 * Unique identifier for a course
	 */
	private String code;

	/**
	 * Creation date of the course syllabus to differentiate this syllabus from
	 * others for the same course
	 */
	private LocalDateTime creationDate;

	/**
	 * The courses that should be completed before taking this course or
	 * requirements of this course which should be satisfied before taking the
	 * course.
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
	 * according to the pseudo code below ; localCredit = round(theoreticalHour +
	 * (0.5 * labHour))
	 * 
	 * @see #calculateLocalCredit()
	 */
	private int localCredit;

	/**
	 * Shows the ECTS equivalent value of the course This value is calculated by the
	 * program itself according the pseudo code below ; ECTS = round(sumAll(workload
	 * of each element in workloadTable) / 30)
	 * 
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
	 * Assigned Course Type.
	 */
	private CourseType type;

	/**
	 * Specify the course level according to the predefined values.
	 */
	private CourseLevel level;

	/**
	 * Coordinator of the course. There can only be 1 coordinator and must be a
	 * teacher.
	 */
	private String courseCoordinator;

	/**
	 * Lecturers who give this course. There can be more then one lecturer
	 * 
	 * @see #addLecturer(Lecturer)
	 * @see #removeLecturer(Lecturer)
	 */
	private ArrayList<String> courseLecturers;

	/**
	 * Assistants of this course. There can be more then one assistant.
	 * 
	 * @see #addAssistant(Lecturer)
	 * @see #removeAssistant(Lecturer)
	 */
	private ArrayList<String> assistants;

	/**
	 * Course objective summary.
	 */
	private String courseObjective;

	/**
	 * Learning outcomes as a String ArrayList. Order of the array is relevant
	 * because {@link EvaluationCriteria} field is using the order of the array the
	 * identify different learning outcomes.
	 * 
	 * @see #addCriteria(EvaluationCriteria)
	 */
	private ArrayList<String> learningOutcomes;

	/**
	 * Course Description summary.
	 */
	private String courseDescription;

	/**
	 * One of the categories from {@link CourseCategory} enumerator.
	 * 
	 * @see CourseCategory
	 */
	private CourseCategory courseCategory;

	/**
	 * Course Schedule with 16 weeks (16 object). Weeks are created at the
	 * construction state of the object. User will not be able to delete a week. But
	 * field(s) of a {@link WeeklySubject} may be changed to accommodate the
	 * requirements.
	 * 
	 * @see #changeSchedule(int, String, String)
	 */
	private ArrayList<WeeklySubject> courseSchedule;

	/**
	 * General course textbook.
	 */
	private String courseTextBook;

	/**
	 * Suggested readings for this course
	 */
	private ArrayList<String> suggestedReading;

	/**
	 * Evaluation criterias for the grading of the course. An
	 * {@link EvaluationCriteria} object contains information about criteria name,
	 * contribution to the grade percentage and indications to the related learning
	 * outcomes.
	 * 
	 * @see EvaluationCriteria
	 * @see #learningOutcomes
	 */
	private ArrayList<EvaluationCriteria> evaluationCriterias;

	/**
	 * Workload table contains activities and specifies the hours for every activity
	 * in one semester.
	 * 
	 * @see SemesterActivity
	 */
	private ArrayList<SemesterActivity> workloadTable;

	/**
	 * Course Competencies shows the outcome of the course with the associated
	 * learning outcomes.
	 */
	private ArrayList<CourseCompetency> courseCompetencies;

	// Constructor(s)
	/**
	 * This constructor is design to be used in the event of importing and creation
	 * in availability of complete information set. Every field will be passed in
	 * construction phase and syllabus will be ready to use and export directly
	 * after instantiation.
	 * 
	 * @param courseName          Name of the course.
	 * @param code                Abbreviated name of the course.
	 * @param prerequisites       List of prerequisite courses for this course.
	 * @param courseLang          Language that the course is given.
	 * @param semester            Semesters which course is open (available).
	 * @param theoreticalHour     Theoretical hours in one week of the course.
	 * @param labHour             Lab/Application hours in one week of the course.
	 * @param type                Type of the course.
	 * @param cordinator          Coordinator of the course. Note: (It is a lecturer
	 *                            too.)
	 * @param lecturers           List of the lecturers which give this course.
	 * @param assistants          List of the lab/application assistant for this
	 *                            course.
	 * @param courseObjective     Summary of the course objective.
	 * @param learningOutcomes    Skills and abilities that you will gain after
	 *                            completing this course.
	 * @param courseDescription   Description of the course.
	 * @param category            One of the course categories among
	 *                            {@link CourseCategory} enum.
	 * @param schedule            Course schedule for a semester of the course.
	 * @param courseBook          General book of the course.
	 * @param suggestedReading    List of suggested readings for more detailed
	 *                            information.
	 * @param evaluationCriterias Evaluation criterias of the course to calculate
	 *                            the total grade. // * @param workloadTable All
	 *                            workload that a course require in one semester.
	 * @param courseCompetencies  Competencies of the course with related learning
	 *                            outcomes.
	 */
	/*
	 * Removed because of the complete validation concerns. Please use the other constructor with
	 * setter(s) and getter(s) 
	public Course(String courseName, String code, LinkedHashSet<String> prerequisites, Language courseLang,
			SemesterOptions semester, int theoreticalHour, int labHour, CourseType type, String coordinator,
			LinkedHashSet<String> lecturers, LinkedHashSet<String> assistants, String courseObjective,
			LinkedHashSet<String> learningOutcomes, String courseDescription, CourseCategory category,
			LinkedHashSet<WeeklySubject> schedule, CourseBook courseBook, LinkedHashSet<CourseBook> suggestedReading,
			LinkedHashSet<EvaluationCriteria> evaluationCriterias, LinkedHashSet<SemesterActivity> workloadTable,
			LinkedHashSet<CourseCompetency> courseCompetencies) {
		this.courseName = courseName;
		this.code = code;
		this.creationDate = LocalDateTime.now();
		this.prerequisites = new ArrayList<>(prerequisites);
		this.courseLang = courseLang;
		this.labHour = labHour;
		this.theoreticalHour = theoreticalHour;
		this.localCredit = calculateLocalCredit();
		this.ects = calculateECTS();
		this.type = type;
		this.courseCoordinator = coordinator;
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
	*/

	// FIXME add a default constructor for newly created courses without a
	// sufficient information supplied.
	public Course() {
		this.courseName = "Not specified";
		this.code = "Not Specified";
		this.creationDate = LocalDateTime.now();
		this.prerequisites = new ArrayList<>();
		this.courseLang = Language.ENGLISH;
		this.labHour = 0;
		this.theoreticalHour = 0;
		this.localCredit = calculateLocalCredit();
		this.ects = calculateECTS();
		this.type = CourseType.REQUIRED;
		this.courseCoordinator = "Not Added";
		this.courseLecturers = new ArrayList<>();
		this.assistants = new ArrayList<>();
		this.courseObjective = new String();
		this.courseCategory = CourseCategory.CORE_COURSE;
		this.courseSchedule = WeeklySubject.createDefaultSemester();
		this.courseTextBook = "Not given";
		this.suggestedReading = new ArrayList<>();
		this.evaluationCriterias = new ArrayList<>();
		
		
	}

	// Method(s)
	/**
	 * Add a prerequisite to the course.
	 * 
	 * @param prerequisite Code of course that will be added as a prerequisites.
	 * @return {@code true} if the new course added successfully to the
	 *         {@link #prerequisites} list, return {@code false} otherwise.
	 */
	public boolean addPrerequisite(String prerequisite) {
		if (doesContain(prerequisites, prerequisite)) {
			return false;
		} else {
			return prerequisites.add(prerequisite);
		}

	}

	/**
	 * This method removes a prerequisite from the {@link #prerequisites} list.
	 * 
	 * @param course
	 * @return {@code true} if the deletion operation is successful, if the
	 *         {@link #prerequisites} does not contain the specified course code it
	 *         will return false.
	 */
	public boolean removePrerequisite(String course) {
		return prerequisites.remove(course);
	}

	/**
	 * It calculates ECTS after change in {@link #workloadTable}.
	 * 
	 * @return new ECTS value of the course after the change applied in the workload
	 *         table.
	 */
	public int calculateECTS() {
		int totalWorkload = 0;
		for (SemesterActivity activity : workloadTable) {
			totalWorkload += activity.getWorkload();
		}
		return ects = (int) Math.round(totalWorkload / 30.0);
	}

	/**
	 * This method calculates Local Credit after a change in {@code labHour} or/and
	 * {@code theoreticalHour}.
	 * 
	 * @return The updated local credit of the course after the changes in
	 *         {@code labHour} and {@code theoreticalHour} applied.
	 */
	private int calculateLocalCredit() {
		return localCredit = (int) (theoreticalHour + Math.round((0.5 * labHour)));
	}

	/**
	 * Method is used to add a lecturer to the course.
	 * 
	 * @param lecturer is the {@code Lecturer} object that you want to add to this
	 *                 course.
	 * @return {@code true} if the lecturer can be added to the course, otherwise
	 *         returns {@code false}.
	 */
	private boolean addLecturer(String lecturer) {
		/* 
		 * Old version simplified for the sake of implementation
		if (doesContain(courseLecturers, lecturer)) {
			return false;
		} else {
			return courseLecturers.add(lecturer);
		}
		*/
		
		if ((lecturer != null) && !(lecturer.isBlank()) && !(courseLecturers.contains(lecturer))) {
			courseLecturers.add(lecturer);
			return true;
		}
		return false;
	}

	
	
	/**
	 * This overwritten method is the used to add a lecturer to the course without
	 * creating {@link Lecturer} object.
	 * 
	 * @param lecName    Name of the Lecturer
	 * @param lecSurname Surname of the Lecturer
	 * @param title      Title of the Lecturer
	 * @return {@code true} if the lecturer can be added to the course, otherwise
	 *         returns {@code false}.
	 * @throws NullPointerException     is thrown if at least one of the arguments
	 *                                  given is null.
	 * @throws IllegalArgumentException is thrown if {@code lecName},
	 *                                  {@code lecSurname} is blank (or empty).
	 */
	/*
	 * Removed method to create simplicity for other classes.
	public boolean addLecturer(String lecName, String lecSurname, AcademicTitle title)
			throws NullPointerException, IllegalArgumentException {
		if ((lecName == null) || (lecSurname == null) || (title == null)) {
			throw new NullPointerException("Lecturer name, surname or title is null.");
		}
		if ((lecName.isBlank()) || (lecSurname.isBlank())) {
			throw new IllegalArgumentException("Lecturer name or surname is blank. Please fill it.");
		}
		return addLecturer(new Lecturer(lecName, lecSurname, title));
	}
	*/

	/**
	 * Removes the specified lecturer from the {@link #courseLecturers} list.
	 * 
	 * @param lec lecturer that you want to remove from the course.
	 * @return returns {@code true} if it is removed successfully, return
	 *         {@code false} otherwise.
	 */
	public boolean removeLecturer(String lec) {
		return courseLecturers.remove(lec);
	}

	/**
	 * Adds an assistant to the course if it is not already added.
	 * 
	 * @param assistant
	 * @return returns {@code true} if it is added to the {@code #assistants}
	 *         without a problem, return {@code false} otherwise.
	 */
	private boolean addAssistant(String assistant) {
		/*
		if (doesContain(assistants, assistant)) {
			return false;
		} else {
			return courseLecturers.add(assistant);
		}
		*/
		if((assistant != null) && !(assistant.isBlank()) && !(assistants.contains(assistant))) {
			assistants.add(assistant);
			return true;
		}
		return false;
	}

	/**
	 * This method is the used to add a lecturer to the course without creating
	 * {@link Lecturer} object.
	 * 
	 * @param lecName    Name of the assistant
	 * @param lecSurname Surname of the assistant
	 * @param title      Title of the assistant
	 * @return {@code true} if the assistant can be added to the course, otherwise
	 *         returns {@code false}.
	 * @throws NullPointerException     is thrown if at least one of the arguments
	 *                                  given is null.
	 * @throws IllegalArgumentException is thrown if {@code lecName},
	 *                                  {@code lecSurname} is blank (or empty).
	 */
	/*
	 * Removed for the simplicity.
	public boolean addAssistant(String lecName, String lecSurname, AcademicTitle title)
			throws NullPointerException, IllegalArgumentException {
		if ((lecName == null) || (lecSurname == null) || (title == null)) {
			throw new NullPointerException("Assistant name, surname or title is null.");
		}
		if ((lecName.isBlank()) || (lecSurname.isBlank())) {
			throw new IllegalArgumentException("Assistant name or surname is blank. Please fill it.");
		}
		return addAssistant(new Lecturer(lecName, lecSurname, title));
	}
	*/
	
	
	/**
	 * Removes the specified assistant from the {@link #assistants} list.
	 * 
	 * @param lecturer lecturer that you want to remove from the course.
	 * @return returns {@code true} if it is removed successfully, return
	 *         {@code false} otherwise.
	 */
	public boolean removeAssistant(String lecturer) {
		return assistants.remove(lecturer);
	}

	/**
	 * Change the description or/and related material for the given week.
	 * 
	 * @param week The week that you want to update
	 * @param desc New description value for the given week.
	 * @param rm   New related material value for the given week.
	 * @return {@code true} if update is done successfully, return {@code false} in
	 *         case of the update is not applied.
	 */
	public boolean changeSchedule(int week, String desc, String rm) {
		if ((week > 0) && (week < courseSchedule.size())) {
			WeeklySubject subj = courseSchedule.get(week - 1);
			return subj.updateSubject(desc, rm);
		}
		return false;
	}

	/**
	 * Method to add new readings for the course.
	 * 
	 * @param book The book that you want to add as suggested reading.
	 * @return {@code true} if the book is added successfully, return {@code false}
	 *         otherwise.
	 */
	private boolean addReading(String book) {
		/*
		 * Removed version for the simplicity
		if (doesContain(suggestedReading, book)) {
			return false;
		} else {
			return suggestedReading.add(book);
		}
		*/
		
		if ((book != null) && !(book.isBlank()) && !(suggestedReading.contains(book))) {
			suggestedReading.add(book);
			return true;
		}
		return false;
	}

	/**
	 * Method to add new further readings for the course without creating an
	 * {@link CourseBook} object.
	 * 
	 * @param name    Name of the book.
	 * @param edition Edition of the book. If edition is not available type 0 as
	 *                edition.
	 * @param author  Author of the book. If there is no author or it is anonymous,
	 *                pass null or empty string.
	 * @return {@code true} if the book is added successfully, return {@code false}
	 *         otherwise.
	 * @throws NullPointerException     Name of the book is mandatory. If null
	 *                                  passed as name parameter method will throw a
	 *                                  {@code NullPointerException}.
	 * @throws IllegalArgumentException If the name of the is empty or the edition
	 *                                  value is less than 0, it will throw an
	 *                                  {@code IllegalArgumentException}.
	 */
	/*
	 * Removed method for the simplicity.
	public boolean addReading(String name, int edition, String author)
			throws NullPointerException, IllegalArgumentException {
		if (name == null) {
			throw new NullPointerException("Book name is null.");
		}
		if ((name.isBlank()) || (edition < 0)) {
			throw new IllegalArgumentException(
					"Book name is mandatory and edition value must " + "be greater than 0 Please fill it.");
		}
		if ((author == null) || (author.isBlank())) {
			author = "Anonymous";
		}
		return addReading(new CourseBook(name, edition, author));
	}
	*/

	/**
	 * Method to add a book to suggested readings without specifying the edition.
	 * 
	 * @param name   Name of the book.
	 * @param author Full name of the author who written the book.
	 * @return {@code true} if the book is added successfully, return {@code false}
	 *         otherwise.
	 */
	/*
	 * Removed method for simplicity
	public boolean addReading(String name, String author) {
		return addReading(name, 0, author);
	}
	*/

	/**
	 * Method to remove a book from the {@link #suggestedReading} Array.
	 * 
	 * @param book The book you want to remove from the list.
	 * @return {@code true} if the book is removed successfully, return
	 *         {@code false} otherwise.
	 */
	public boolean removeReading(String book) {
		return suggestedReading.remove(book);
	}

	/**
	 * Method to add a new grading criteria for the course
	 * 
	 * @param criteria Criteria that you want to add.
	 * @return {@code true} if the criteria is added successfully, return
	 *         {@code false} otherwise.
	 */
	private boolean addCriteria(EvaluationCriteria criteria) {
		if (doesContain(evaluationCriterias, criteria)) {
			return false;
		}
		return evaluationCriterias.add(criteria);
	}

	/**
	 * Adding a new criteria for the course without creating a
	 * {@link EvaluationCriteria} object.
	 * 
	 * @param name   Name of the criteria
	 * @param count  Number of the criteria examination in one semester.
	 * @param contr  Contribution level to the total grade.
	 * @param values Values is an indicator of which criteria how much contribute
	 *               which learning outcomes.
	 * @return {@code true} if the criteria is added successfully, return
	 *         {@code false} otherwise.
	 * @throws NullPointerException     if the name of the criteria is passed null.
	 * @throws IllegalArgumentException will be thrown if you give a blank (or
	 *                                  empty) string as name, a count value less
	 *                                  than 0, contribution value not between 0 and
	 *                                  100 (inclusive). Also if you give an
	 *                                  incompatible array as {@code values} it will
	 *                                  throw an {@link IllegalArgumentException}
	 *                                  too.
	 */
	public boolean addCriteria(String name, int count, int contr, ArrayList<Integer> values)
			throws NullPointerException, IllegalArgumentException {
		if ((name == null) || (values == null)) {
			throw new NullPointerException("Name of the criteria or values for learning outcomes cannot be null.");
		}
		if ((name.isBlank()) || (count < 0) || (contr > 100) || (contr < 0)) {
			throw new IllegalArgumentException("Name of the criteria can not be empty.\n"
					+ "Count for criteria cannot be less than 0 and contribution must between 0 and 100 included.");
		}
		if (values.size() != learningOutcomes.size()) {
			throw new IllegalArgumentException(
					"Number of values must be equal to the " + "number of learning outcomes.");
		}
		for (int value : values) {
			if (value < 0) {
				throw new IllegalArgumentException("Value for a learning outcome must be 0 or greater.");
			}
		}
		return addCriteria(new EvaluationCriteria(name, count, contr, values));
	}

	/**
	 * Method to remove a criteria from the course syllabus.
	 * 
	 * @param criteria Criteria you want to remove from the list.
	 * @return {@code true} if the criteria is removed successfully, return
	 *         {@code false} otherwise.
	 */
	public boolean removeCriteria(EvaluationCriteria criteria) {
		return evaluationCriterias.remove(criteria);
	}

	// TRYIT add a proper adjustment method without using lazy approach.
	/**
	 * This is a lazy method to make changes in a criteria.
	 * 
	 * @param criteria           Criteria that you want to change
	 * @param name               New name for the criteria
	 * @param count              New count of the criteria
	 * @param contribution       New contribution level of the criteria to the total
	 *                           grade
	 * @param contributionLevels Updated contribution levels
	 * @return {@code true} if the criteria is changed successfully, return
	 *         {@code false} otherwise.
	 */
	public boolean changeCriteria(EvaluationCriteria criteria, String name, int count, int contribution,
			ArrayList<Integer> contributionLevels) {
		if (evaluationCriterias.contains(criteria)) {
			if (addCriteria(name, count, contribution, contributionLevels)) {
				return removeCriteria(criteria);
			}
		}
		return false;
	}

	/**
	 * General method to add a new workload for the course. Not accessible from
	 * outside of the class.
	 * 
	 * @param activity Activity that you want to add to the course.
	 * @return {@code true} if the activity is added successfully, return
	 *         {@code false} if the course already contains the same activity.
	 */
	private boolean addWorkload(SemesterActivity activity) {
		if (doesContain(workloadTable, activity)) {
			return false;
		}
		return workloadTable.add(activity);
	}

	public boolean addWorkload(String actName, int number, int duration)
			throws NullPointerException, IllegalArgumentException {
		if (actName == null) {
			throw new NullPointerException("Activity name cannot be null.");
		}
		if ((actName.isBlank()) || (number < 0) || (duration < 0)) {
			throw new IllegalArgumentException("Number or duration can not be negative.");
		}
		return addWorkload(new SemesterActivity(actName, number, duration));
	}

	/**
	 * Method to remove an activity from the workload table.
	 * 
	 * @param act Activity you want to remove from the table.
	 * @return {@code true} if the activity is removed successfully, return
	 *         {@code false} if the course does not contain the specified activity.
	 */
	public boolean removeWorkload(SemesterActivity act) {
		return workloadTable.remove(act);
	}

	// TRYIT add a proper adjustment method without using lazy approach.
	/**
	 * It is a lazy method to adjust a {@link SemesterActivity} in the workload
	 * table.
	 * 
	 * @param activity Activity that you want to apply changes.
	 * @param number   New number of the activity in one semester.
	 * @param duration New duration for every occurrence of the activity.
	 * @return {@code true} if the activity is adjusted successfully, return
	 *         {@code false} otherwise.
	 */
	public boolean adjustWorkload(SemesterActivity activity, int number, int duration) {
		if (workloadTable.contains(activity)) {
			if (addWorkload(activity.getActivityName(), number, duration)) {
				return removeWorkload(activity);
			}
		}
		return false;
	}

	/**
	 * General method to add a new competency to the course.
	 * 
	 * @param competency Competency that you want to add.
	 * @return {@code true} if the competency is added successfully, return
	 *         {@code false} if the course contain the specified competency.
	 */
	private boolean addCompetency(CourseCompetency competency) {
		if (doesContain(courseCompetencies, competency)) {
			return false;
		}
		return courseCompetencies.add(competency);
	}

	/**
	 * Method to add a new competency to the course.
	 * 
	 * @param description             Description of the competency.
	 * @param contLevel               Contribution level of the competency to the
	 *                                related learning outcomes.
	 * @param relatedLearningOutcomes Learning outcomes indexes related with this
	 *                                competency.
	 * @return return {@code true} if new {@link CourseCompetency} object can be
	 *         added to the competency list, returns {@code false} if it cannot be
	 *         added.
	 * @throws NullPointerException      Description for the competency is
	 *                                   mandatory. If you pass a null parameter, to
	 *                                   the description a
	 *                                   {@link NullPointerException} will be
	 *                                   thrown.
	 * @throws IllegalArgumentException  If description is blank or contribution
	 *                                   value is not between [1-5] method will
	 *                                   throw an {@code IllegalArgumentException}.
	 *                                   Also if total contribution sum for the
	 *                                   competencies of the course exceeds the 2.5
	 *                                   times of the ects value, method will throw
	 *                                   a {@code IllegalArgumentException} too.
	 * @throws IndexOutOfBoundsException If an index added for a learning outcome is
	 *                                   greater than the indexes of the available
	 *                                   learning outcomes method will throw an
	 *                                   {@code IndexOutOfBoundsException}.
	 */
	public boolean addCompetency(String description, int contLevel, LinkedHashSet<Integer> relatedLearningOutcomes)
			throws NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		if (description == null) {
			throw new NullPointerException("Description can not be null.");
		}
		if ((description.isBlank()) || (contLevel < 0) || (contLevel > 5)) {
			throw new IllegalArgumentException(
					"Description can not be blank (or empty).\n" + "Also contribution level must be between 0 and 5");
		}
		if (relatedLearningOutcomes == null) {
			relatedLearningOutcomes = new LinkedHashSet<>();
		}
		if ((calculateContLevel() + contLevel) > 2.5 * ects) {
			throw new IllegalArgumentException("Contribution level exceeds the 2.5 times of the ects value.\n"
					+ "This is prohibited by the system rules. Please specify a smaller value for contribution level or decrease the value of the other competencies.");
		}
		for (int outcomeIndex : relatedLearningOutcomes) {
			if (outcomeIndex >= learningOutcomes.size()) {
				throw new IndexOutOfBoundsException(String.format(
						"%d index does not have a corresponding index in learning outcomes ArrayList.", outcomeIndex));
			}
		}
		return addCompetency(new CourseCompetency(description, contLevel, relatedLearningOutcomes));
	}

	/**
	 * Method to remove a competency of the course.
	 * 
	 * @param competency Competency you want to remove.
	 * @return {@code true} if the competency is removed successfully, return
	 *         {@code false} if the course does not contain the specified
	 *         competency.
	 */
	public boolean removeCompetency(CourseCompetency competency) {
		return courseCompetencies.remove(competency);
	}

	// TRYIT add a proper adjustment method without using lazy approach.
	/**
	 * Lazy method to adjust a competency. You can change description, contribution
	 * level and related learning outcomes.
	 * 
	 * @param competency              Competency you want to change.
	 * @param description             New description of the competency.
	 * @param contLevel               New contribution level.
	 * @param relatedLearningOutcomes Updated related learning outcomes.
	 * @return {@code true} if the competency is adjusted successfully, return
	 *         {@code false} otherwise.
	 */
	public boolean adjustCompetency(CourseCompetency competency, String description, int contLevel,
			LinkedHashSet<Integer> relatedLearningOutcomes) {
		if (courseCompetencies.contains(competency)) {
			if (addCompetency(description, contLevel, relatedLearningOutcomes)) {
				return removeCompetency(competency);
			}
		}
		return false;
	}

	// Internal Method(s)
	/**
	 * Class private method to test if the given {@link List} object contains the
	 * specified item.
	 * 
	 * @param <T>  Class or superclass of the item and List objects content.
	 * @param list List which will be tested if it contains the item.
	 * @param item Item to be searched inside the list.
	 * @return If list does not contain the item, method will return {@code false}
	 *         otherwise {@code true}.
	 */
	private <T> boolean doesContain(List<T> list, T item) {
		if (item instanceof String) {
			String stringItem = (String) item;
			for (T test : list) {
				String stringTest = (String) test;
				if (stringTest.equalsIgnoreCase(stringItem)) {
					return true;
				}
			}
		} else {
			return list.contains(item);
		}
		return false;
	}

	private int calculateContLevel() {
		int sum = 0;
		for (CourseCompetency competency : courseCompetencies) {
			sum += competency.getContributionLevel();
		}
		return sum;
	}

	// Getter(s) and Setter(s)

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

	public CourseLevel getLevel() {
		return level;
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

	public String getCourseCordinator() {
		return courseCoordinator;
	}

	// TODO Deliver a deep copy of the array to prevent unsupervised changes on the
	// data.
	public ArrayList<String> getCourseLecturers() {
		return courseLecturers;
	}

	// TODO Deliver a deep copy of the array to prevent unsupervised changes on the
	// data.
	public ArrayList<String> getAssistants() {
		return assistants;
	}

	public String getCourseObjective() {
		return courseObjective;
	}

	// TODO Deliver a deep copy of the array to prevent unsupervised changes on the
	// data.
	public ArrayList<String> getLearningOutcomes() {
		return learningOutcomes;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public CourseCategory getCourseCategory() {
		return courseCategory;
	}

	// TODO Deliver a deep copy of the array to prevent unsupervised changes on the
	// data.
	public ArrayList<WeeklySubject> getCourseSchedule() {
		return courseSchedule;
	}

	public String getCourseTextBook() {
		return courseTextBook;
	}

	// TODO Deliver a deep copy of the array to prevent unsupervised changes on the
	// data.
	public ArrayList<String> getSuggestedReading() {
		return suggestedReading;
	}

	// TODO Deliver a deep copy of the array to prevent unsupervised changes on the
	// data.
	public ArrayList<EvaluationCriteria> getEvaluationCriterias() {
		return evaluationCriterias;
	}

	// TODO Deliver a deep copy of the array to prevent unsupervised changes on the
	// data.
	public ArrayList<SemesterActivity> getWorkloadTable() {
		return workloadTable;
	}

	// TODO Deliver a deep copy of the array to prevent unsupervised changes on the
	// data.
	public ArrayList<CourseCompetency> getCourseCompetency() {
		return courseCompetencies;
	}

	public boolean setCourseName(String courseName) {
		if ((courseName != null) && !(courseName.isBlank()) && (courseName.length() > 4)) {
			this.courseName = courseName;
			return true;
		}
		return false;
	}

	// TRYIT Regex testing may be added for further validation.
	public boolean setCode(String code) {
		if ((code != null) && (code.length() > 4)) {
			this.code = code;
			return true;
		}
		return false;
	}

	public boolean setCourseLang(Language courseLang) {
		if (courseLang != null) {
			this.courseLang = courseLang;
			return true;
		}
		return false;
	}

	public boolean setSemester(SemesterOptions semester) {
		if (semester != null) {
			this.semester = semester;
			return true;
		}
		return false;
	}

	public boolean setLevel(CourseLevel level) {
		if (level != null) {
			this.level = level;
			return true;
		}
		return false;
	}

	public boolean setLabHour(int labHour) {
		if (labHour >= 0) {
			this.labHour = labHour;
			calculateLocalCredit();
			return true;
		}
		return false;
	}

	public boolean setTheoreticalHour(int theoreticalHour) {
		if (theoreticalHour >= 0) {
			this.theoreticalHour = theoreticalHour;
			calculateLocalCredit();
			return true;
		}
		return false;
	}

	public void setType(CourseType type) {
		if (type != null) {
			this.type = type;
		}

	}

	public boolean setCourseCordinator(String courseCordinator) {
		if ((courseCordinator != null) && !(courseCordinator.isBlank())) {
			this.courseCoordinator = courseCordinator;
			return true;
		}
		return false;
	}

	public boolean setCourseObjective(String courseObjective) {
		if ((courseObjective != null) && !(courseObjective.isBlank())) {
			this.courseObjective = courseObjective;
			return true;
		}
		return false;
	}

	public boolean setCourseDescription(String courseDescription) {
		if ((courseDescription != null) && !(courseDescription.isBlank())) {
			this.courseDescription = courseDescription;
			return true;
		}
		return false;
	}

	public boolean setCourseCategory(CourseCategory courseCategory) {
		if (courseCategory != null) {
			this.courseCategory = courseCategory;
			return true;
		}
		return false;
	}

	public boolean setCourseTextBook(String courseTextBook) {
		if ((courseTextBook != null) && !(courseTextBook.isBlank())) {
			this.courseTextBook = courseTextBook;
			return true;
		}
		return false;
	}
}
