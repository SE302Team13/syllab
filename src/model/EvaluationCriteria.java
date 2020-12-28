package model;

import java.util.ArrayList;

public class EvaluationCriteria {
	
	
	//Field(s)
	
	private String name;
	private int count;
	private int contribution;
	private ArrayList<Integer> contributionLevels;
	
	

	
	public EvaluationCriteria(String name, int count, int contr, ArrayList<Integer> values) {
		this.name = name;
		this.count = count;
		this.contribution = contr;
		this.contributionLevels = values;
	}
	
	
	//Getter(s) and Setter(s)
	
	public String getName() {
		return name;
	}


	public int getCount() {
		return count;
	}


	public int getContribution() {
		return contribution;
	}


	public ArrayList<Integer> getContributionLevels() {
		return contributionLevels;
	}


	public boolean setName(String name) {
		if (!(name.isBlank())) {
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
		if ((contribution > 0) && (contribution <= 100)) {
			this.contribution = contribution;
			return true;
		}
		return false;
	}


	public void setContributionLevels(ArrayList<Integer> contributionLevels) {
		this.contributionLevels = contributionLevels;
	}
	
	
	
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
