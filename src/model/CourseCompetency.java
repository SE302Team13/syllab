package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class CourseCompetency implements Serializable {

	// Field(s)

	/**
	 * 
	 */
	private static final long serialVersionUID = -5542884675479939170L;
	
	
	/**
	 * Description for the competeceny.
	 */
	private String description;
	/**
	 * Contribution level of the competency. Value <b>must</b> be between 0 and 5.
	 */
	private int contributionLevel;
	/**
	 * This array contains index values of the learning outcomes related with this
	 * competency.
	 */
	private ArrayList<Integer> relatedLearningOutcomes;

	// Constructor(s)

	/**
	 * General constructor of the class. Constructor does not provide any argument
	 * validation. <b>Make sure</b> the values that passed to this constructor be
	 * validated before.
	 * 
	 * @param description             Description for the competeceny.
	 * @param contLevel               Contribution level of the competency. Value
	 *                                <b>must</b> be between 0 and 5.
	 * @param relatedLearningOutcomes This array contains index values of the
	 *                                learning outcomes related with this
	 *                                competency.
	 */
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

	// TODO Deliver a deep copy of the array to prevent unsupervised changes on the
	// data.
	public ArrayList<Integer> getRelatedLearningOutcomes() {
		return relatedLearningOutcomes;
	}

	
	/*
	 * NOTE
	 * Class will stay (almost) immutable for now to keep it simple and prevent confusion.
	 * Because these functionalities are not required by the program at the moment.
	 * This state may change in further releases.
	 * date : 02.01.2021 / 22:25
	 * author : Hakan Ayaz
	 */
	
	/*
	public boolean setDescription(String description) {
		if ((description != null) && !(description.isBlank())) {
			this.description = description;
			return true;
		}
		return false;
	}

	public boolean setContributionLevel(int contributionLevel) {
		if ((contributionLevel >= 0) && (contributionLevel <= 5)) {
			this.contributionLevel = contributionLevel;
			return true;
		}
		return false;
	}

	public boolean setRelatedLearningOutcomes(ArrayList<Integer> relatedLearningOutcomes) {
		if (relatedLearningOutcomes == null) {
			relatedLearningOutcomes = new ArrayList<>();
		}
	}
	*/
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CourseCompetency) {
			CourseCompetency competency = (CourseCompetency) obj;
			return this.description.equalsIgnoreCase(competency.description);
		}
		return false;
	}

}
