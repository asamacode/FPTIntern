package com.asama.fptcandidate.model;

public class Experience extends Candidate{
	
	private int expInYear;
	private String proSkill;	
	

	public Experience() {
		super();
	}

	public Experience(int candidateID, int candidateType, String fullName, 
			String birthday, String phone, String email,
			int expInYear, String proSkill) {
		super(candidateID, candidateType, fullName, birthday, phone, email);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}



	public int getExpInYear() {
		return expInYear;
	}



	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}



	public String getProSkill() {
		return proSkill;
	}



	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}



	@Override
	public void showInfo() {
		System.out.println(candidateID + " - " +fullName + " - Experience - " + birthday+ " - " + phone + " - " +expInYear + " - " + proSkill);
		
	}

}
