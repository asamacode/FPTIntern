package com.asama.fptcandidate.model;

public class Certificated {

	private int certificatedID;
	private String certificatedName, certificatedRank, certificatedDate;
	
	public Certificated() {
		super();
	}
	
	public Certificated(int certificatedID, String certificatedName,
			String certificatedRank, String certificatedDate) {
		super();
		this.certificatedID = certificatedID;
		this.certificatedName = certificatedName;
		this.certificatedRank = certificatedRank;
		this.certificatedDate = certificatedDate;
	}
	public int getCertificatedID() {
		return certificatedID;
	}
	public void setCertificatedID(int certificatedID) {
		this.certificatedID = certificatedID;
	}
	public String getCertificatedName() {
		return certificatedName;
	}
	public void setCertificatedName(String certificatedName) {
		this.certificatedName = certificatedName;
	}
	public String getCertificatedRank() {
		return certificatedRank;
	}
	public void setCertificatedRank(String certificatedRank) {
		this.certificatedRank = certificatedRank;
	}
	public String getCertificatedDate() {
		return certificatedDate;
	}
	public void setCertificatedDate(String certificatedDate) {
		this.certificatedDate = certificatedDate;
	}
	
	
}
