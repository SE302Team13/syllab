package GsonResolver;

import com.google.gson.Gson;
import model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GsonResolver {
    Gson gson = new Gson();

    BufferedReader br = new BufferedReader(
            new FileReader("E:file.json"));

    AcademicTitle academicTitleObj = gson.fromJson(br, AcademicTitle.class);
    Course courseObj = gson.fromJson(br, Course.class);
    CourseBook courseBookObj = gson.fromJson(br, CourseBook.class);
    CourseCategory courseCategoryObj = gson.fromJson(br, CourseCategory.class);
    CourseCompetency courseCompetencyObj = gson.fromJson(br, CourseCompetency.class);
    CourseType courseTypeObj = gson.fromJson(br, CourseType.class);
    EvaluationCriteria evaluationCriteriaObj = gson.fromJson(br, EvaluationCriteria.class);
    Language languageObj = gson.fromJson(br, Language.class);
    Lecturer lecturerObj = gson.fromJson(br, Lecturer.class);
    SemesterActivity semesterActivityObj = gson.fromJson(br, SemesterActivity.class);
    SemesterOptions semesterOptionsObj = gson.fromJson(br, SemesterOptions.class);
    WeeklySubject weeklySubjectObj = gson.fromJson(br, WeeklySubject.class);


    public GsonResolver() throws FileNotFoundException {
    }
}
