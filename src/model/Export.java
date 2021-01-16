package model;

import java.io.*;

import com.x5.template.Chunk;
import com.x5.template.Theme;

public class Export {
	public void export(Course course, String path) {
		Theme theme = new Theme();
		Chunk c = theme.makeChunk("syllabus#general");

		c.set("courseName", course.getCourseName());
		c.set("code", course.getCode());
		
		String isFall = course.getSemester() == SemesterOptions.FALL || course.getSemester() == SemesterOptions.BOTH ? "X" : "";
		String isSpring = course.getSemester() == SemesterOptions.SPRING || course.getSemester() == SemesterOptions.BOTH ? "X" : "";
		c.set("fall",isFall);
		c.set("spring", isSpring);
		c.set("theory_hour", course.getTheoreticalHour());
		c.set("application_hour", course.getLabHour());
		c.set("local_credits", course.getLocalCredit());
		c.set("ects", course.getEcts());
		c.set("prerequistes", course.getPrerequisites());
		c.set("courseLang", course.getCourseLang());
		c.set("type", course.getType());
		c.set("level", course.getLevel());
		c.set("courseCoordinator", course.getCourseCoordinator());
		c.set("courseLecturers", course.getCourseLecturers());
		c.set("assistants", course.getAssistants());
		c.set("courseObjective",course.getCourseObjective());
		c.set("learningOutcomes", course.getLearningOutcomes());
		c.set("courseDescription", course.getCourseDescription());
		
		String isCore = course.getCourseCategory() == CourseCategory.CORE_COURSE ? "X" : "";
		String isMajor = course.getCourseCategory() == CourseCategory.MAJOR_AREA_COURSE ? "X" : "";
		String isSkill = course.getCourseCategory() == CourseCategory.TRANS_SKILL_COURSE ? "X" : "";
		String isManagement = course.getCourseCategory() == CourseCategory.COM_AND_MAN_COURSE ? "X" : "";
		String isSupportive = course.getCourseCategory() == CourseCategory.SUPPORTIVE_COURSE ? "X" : "";
		c.set("coreCourse", isCore);
		c.set("majorAreaCourse", isMajor);
		c.set("supportiveCourse", isSupportive);
		c.set("managementCourse", isManagement);
		c.set("skillCourse", isSkill);

		
		File file = new File(path);
		FileWriter out;
		try {
			out = new FileWriter(file);
			c.render(out);

			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
