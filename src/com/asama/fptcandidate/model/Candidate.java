package com.asama.fptcandidate.model;

public abstract class Candidate {
	
	public static final int TYPE_EXPERIENCE = 0;
	public static final int TYPE_FRESHER = 1;
	public static final int TYPE_INTERN = 2;
	
	protected int candidateID, candidateType, candidateCount;
	protected String fullName;
	protected String birthday;
	protected String phone;
	protected String email;
	
	public Candidate() {
	}

	public Candidate(int candidateID, int candidateType, 
			String fullName, String birthday, String phone, String email) {
		super();
		this.candidateID = candidateID;
		this.candidateType = candidateType;
		this.fullName = fullName;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
	}

	public int getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(int candidateID) {
		this.candidateID = candidateID;
	}



	public int getCandidateType() {
		return candidateType;
	}



	public void setCandidateType(int candidateType) {
		this.candidateType = candidateType;
	}



	public int getCandidateCount() {
		return candidateCount;
	}



	public void setCandidateCount(int candidateCount) {
		this.candidateCount = candidateCount;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + candidateID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		if (candidateID != other.candidateID)
			return false;
		return true;
	}

	public abstract void showInfo();
}
