package com.asama.fptcandidate.view;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.asama.fptcandidate.controller.CandidateDao;
import com.asama.fptcandidate.controller.JDBCConnection;
import com.asama.fptcandidate.model.Candidate;
import com.asama.fptcandidate.model.Experience;
import com.asama.fptcandidate.model.Fresher;
import com.asama.fptcandidate.model.Intern;

public class CandidateManager {
	public static Scanner sc = new Scanner(System.in);
    private CandidateDao candidateDao;
    private int count = 0;
		
	public CandidateManager() {
		candidateDao = new CandidateDao();
	}

	public void insertCandidate() {
		count++;
		Candidate candidate;
		String name = inputName();
		String birthday = inputBirthday();
		String phone = inputPhone();
		String email = inputEmail();
		int type = inputType();
		
		if (type == Candidate.TYPE_EXPERIENCE) {
			candidate = new Experience();
			int expIntYear = inputExpInYear();
			sc.nextLine();
			String proSkill = inputProSkill();
			
			candidate.setFullName(name);
			candidate.setCandidateType(type);
			candidate.setBirthday(birthday);
			candidate.setPhone(phone);
			candidate.setEmail(email);
			
			((Experience) candidate).setExpInYear(expIntYear);
			((Experience) candidate).setProSkill(proSkill);
			
			candidateDao.insert(candidate);
			System.out.println("Candidate count: " + count);
		} else if (type == Candidate.TYPE_FRESHER) {
			candidate = new Fresher();
			sc.nextLine();
			String date = inputGraduateDate();
			String rank = inputGraduationRank();
			String edu = inputEducation();
			
			candidate.setFullName(name);
			candidate.setCandidateType(type);
			candidate.setBirthday(birthday);
			candidate.setPhone(phone);
			candidate.setEmail(email);
			
			((Fresher) candidate).setGraduationDate(date);
			((Fresher) candidate).setGraduationRank(rank);
			((Fresher) candidate).setEducation(edu);
			
			candidateDao.insert(candidate);
			System.out.println("Candidate count: " + count);
		} else if (type == Candidate.TYPE_INTERN){
			candidate = new Intern();
			sc.nextLine();
			String major = inputMajor();
			String university = inputUniversityName();
			
			candidate.setFullName(name);
			candidate.setCandidateType(type);
			candidate.setBirthday(birthday);
			candidate.setPhone(phone);
			candidate.setEmail(email);
			
			((Intern) candidate).setMajor(major);
			((Intern) candidate).setUniversityName(university);
			
			candidateDao.insert(candidate);
			System.out.println("Candidate count: " + count);
		} else {
			 System.out.println("invalid! please type again");
			 count--;
		}
	}
	
	private String inputName() {
		 System.out.print("Enter candidate name: ");
	     return sc.nextLine();
	}
	 
	private int inputType() {
		 System.out.print("Enter candidate type: ");
	     return sc.nextInt();
	}
	
	private String inputBirthday() {
		 System.out.print("Enter candidate birthday: ");
	     return sc.nextLine();
	}
	
	private String inputPhone() {
		 System.out.print("Enter candidate phone: ");
	     return sc.nextLine();
	}
	
	private String inputEmail() {
		 System.out.print("Enter candidate email: ");
	     return sc.nextLine();
	}
	
	private int inputExpInYear() {
		 System.out.print("Enter candidate exp in year: ");
	     return sc.nextInt();
	}
	
	private String inputProSkill() {
		 System.out.print("Enter candidate pro skill: ");
	     return sc.nextLine();
	}
	
	private String inputGraduateDate() {
		System.out.println("Enter candidate graduate date: ");
		return sc.nextLine();
	}
	
	private String inputEducation() {
		System.out.println("Enter candiate education: ");
		return sc.nextLine();
	}
	
	private String inputGraduationRank() {
		System.out.println("Enter candidate graduation rank: ");
		return sc.nextLine();
	}
	
	private String inputMajor() {
		System.out.println("Enter candidate major: ");
		return sc.nextLine();
	}
	
	private int inputSemester() {
		System.out.println("Enter candidate semester: ");
		return sc.nextInt();
	}
	
	private String inputUniversityName() {
		System.out.println("Enter candidate University name: ");
		return sc.nextLine();
	}

}
