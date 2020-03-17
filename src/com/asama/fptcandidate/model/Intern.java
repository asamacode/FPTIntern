package com.asama.fptcandidate.model;

public class Intern extends Candidate{
	
	private String major, universityName;
	private int semester;

	public Intern() {
		super();
	}

	public Intern(int candidateID, int candidateType, String fullName, 
			String birthday, String phone, String email,
			String major, String universityName, int semester) {
		super(candidateID, candidateType, fullName, birthday, phone, email);
		this.major = major;
		this.universityName = universityName;
		this.semester = semester;
	}



	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}



	public String getUniversityName() {
		return universityName;
	}



	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}



	public int getSemester() {
		return semester;
	}



	public void setSemester(int semester) {
		this.semester = semester;
	}



	@Override
	public void showInfo() {
		System.out.println(candidateID + " - " +fullName + " - " + "Intern - " + birthday+ " - " + phone + " - " + universityName + " - " + major + " - " + semester );
		
	}

	
}
