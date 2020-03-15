package com.asama.fptcandidate.model;

public class Fresher extends Candidate{

	private String graduationDate, graduationRank, education;
	
	public Fresher() {
		super();
	}

	public Fresher(int candidateID, int candidateType, String fullName, 
			String birthday, String phone, String email,
			String graduationDate, String graduationRank, String education) {
		super(candidateID, candidateType, fullName, birthday, phone, email);
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.education = education;
	}

	public String getGraduationDate() {
		return graduationDate;
	}



	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}



	public String getGraduationRank() {
		return graduationRank;
	}



	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	@Override
	public void showInfo() {
		System.out.println("Fresher : ");
	}

	
}
