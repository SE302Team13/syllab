package model;

import java.io.Serializable;
import java.util.ArrayList;

public class EvaluationCriteria implements Serializable {

	// Field(s)

	/**
	 * 
	 */
	private static final long serialVersionUID = 825385954927560599L;

	/**
	 * Name of the criteria
	 */
	private String name;

	/**
	 * Count of examination for the criteria in one semester
	 */
	private int count;

	/**
	 * Contribution to the total grade. Value must be between 0 and 100.
	 */
	private int contribution;

	/**
	 * Contribution level of the criteria for every learning outcome.
	 */
	private ArrayList<Integer> contributionLevels;

	// Constructor(s)
	/**
	 * General constructor for the {@link EvaluationCriteria} class. It requires
	 * mandatory fields and <b>does not</b> have a validation mechanism for values.
	 * So <b>make sure</b> the values validated before pass it to this constructor.
	 * 
	 * @param name   Name of the criteria.
	 * @param count  Number of the examination by this criteria in one semester.
	 * @param contr  Contribution of the criteria to the total grade of the course.
	 * @param values Contribution levels to learning outcomes related with this
	 *               criteria.
	 */
	public EvaluationCriteria(String name, int count, int contr, ArrayList<Integer> values) {
		this.name = name;
		this.count = count;
		this.contribution = contr;
		if (values != null) {
			this.contributionLevels = values;
		} else {
			this.contributionLevels = new ArrayList<>();
		}

	}

	// Getter(s) and Setter(s)

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public int getContribution() {
		return contribution;
	}

	// TODO Deliver a deep copy of the array to prevent unsupervised changes on the
	// data.
	public ArrayList<Integer> getContributionLevels() {
		return contributionLevels;
	}

	public boolean setName(String name) {
		if ((name != null) && !(name.isBlank())) {
			this.name = name;
			return true;
		}
		return false;
	}

	public boolean setCount(int count) {
		if (count > 0) {
			this.count = count;
			return true;
		}
		return false;
	}

	public boolean setContribution(int contribution) {
		if ((contribution >= 0) && (contribution <= 100)) {
			this.contribution = contribution;
			return true;
		}
		return false;
	}

	/*
	 * NOTE This setter should not be accessed directly. Contribution levels are
	 * deeply connected with course class fields. Thus a change should not be done
	 * directly from EvaluationCriteria object. author: Hakan Ayaz date: 02.01.2021
	 * / 16.42
	 */

	/*
	 * public boolean setContributionLevels(ArrayList<Integer> contributionLevels) {
	 * if (contributionLevels != null) { this.contributionLevels =
	 * contributionLevels; return true; } return false; }
	 */

	/**
	 * Overridden method equals() to identify criterias with the same name
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EvaluationCriteria) {
			EvaluationCriteria criteria = (EvaluationCriteria) obj;
			if (this.name.equalsIgnoreCase(criteria.name)) {
				return true;
			}
		}
		return false;
	}

}
