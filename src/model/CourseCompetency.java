package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class CourseCompetency {

	private String description;
	private int contributionLevel;
	private ArrayList<Integer> relatedLearningOutcomes;
	
	
	public CourseCompetency(String description, int contLevel, LinkedHashSet<Integer> relatedLearningOutcomes) {
		this.description = description;
		this.contributionLevel = contLevel;
		this.relatedLearningOutcomes = new ArrayList<>(relatedLearningOutcomes);
	}

	
	public String getDescription() {
		return description;
	}


	public int getContributionLevel() {
		return contributionLevel;
	}


	public ArrayList<Integer> getRelatedLearningOutcomes() {
		return relatedLearningOutcomes;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setContributionLevel(int contributionLevel) {
		this.contributionLevel = contributionLevel;
	}


	public void setRelatedLearningOutcomes(ArrayList<Integer> relatedLearningOutcomes) {
		this.relatedLearningOutcomes = relatedLearningOutcomes;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CourseCompetency) {
			CourseCompetency competency = (CourseCompetency) obj;
			return this.description.equalsIgnoreCase(competency.description);
		}
		return false;
	}
	
	
}
