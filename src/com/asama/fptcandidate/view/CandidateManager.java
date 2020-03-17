package com.asama.fptcandidate.view;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.asama.fptcandidate.controller.CandidateDao;
import com.asama.fptcandidate.model.BirthdaySorter;
import com.asama.fptcandidate.model.Candidate;
import com.asama.fptcandidate.model.Certificated;
import com.asama.fptcandidate.model.Experience;
import com.asama.fptcandidate.model.Fresher;
import com.asama.fptcandidate.model.Intern;
import com.asama.fptcandidate.model.TypeSorter;
import com.asama.fptcandidate.utils.CandidateUtils;

public class CandidateManager {
	public static Scanner sc = new Scanner(System.in);
    private CandidateDao candidateDao;
    private int count = 0;
		
	public CandidateManager() {
		candidateDao = new CandidateDao();
	}
	
	

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		if (sc != null) {
			sc.close();
		}
	}
	
	public void updateCandidateName() {
		try {
			candidateDao.updateAndInsertNewCandidate(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showCandidateName() {
		try {
			System.out.println(candidateDao.loadCandidateName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sortCandidate() {
		List<Candidate> listCan;
		try {
			listCan = candidateDao.loadListCandidate();
			
			Collections.sort(listCan, new TypeSorter().thenComparing(new BirthdaySorter()));
			
			for (Candidate cd : listCan) {
				cd.showInfo();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadCandidate() {
		List<Candidate> listCan;
		try {
			listCan = candidateDao.loadListCandidate();
			for (Candidate cd : listCan) {
				cd.showInfo();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void filterDuplicateCandidate() {
		List<Candidate> listCan;
		try {
			listCan = candidateDao.loadListCandidate();
			Set<Candidate> listCanSet = new HashSet<Candidate>();
			for (Candidate cd : listCan) {
				listCanSet.add(cd);
			}
			
			for (Candidate cd : listCanSet) {
				cd.showInfo();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void addCertificated() {
		int id = inputCandidateId();
		
		try {
			if (candidateDao.checkCandidateExist(id)) {
				sc.nextLine();
				String certificatedName = inputCertificatedName();
				String certificatedRank = inputCertificatedRank();
				String certificatedDate = inputCertificatedDate();
				
				Certificated ct = new Certificated();
				ct.setCertificatedName(certificatedName);
				ct.setCertificatedRank(certificatedRank);
				ct.setCertificatedDate(certificatedDate);
				
				candidateDao.insertCertificated(id, ct);
				
			} else {
				System.out.println("Candidate does not exist !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertCandidate() throws InvalidateBirthdayException, InvalidateEmailException {
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
			
			if (!CandidateUtils.isValidEmail(email)) {
				throw new InvalidateEmailException();
			} else if (!CandidateUtils.isValidBirthday(birthday)) {
				throw new InvalidateBirthdayException();
			} else
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
			
			if (!CandidateUtils.isValidEmail(email)) {
				throw new InvalidateEmailException();
			} else if (!CandidateUtils.isValidBirthday(birthday)) {
				throw new InvalidateBirthdayException();
			} else
			candidateDao.insert(candidate);
			System.out.println("Candidate count: " + count);
		} else if (type == Candidate.TYPE_INTERN){
			candidate = new Intern();
			sc.nextLine();
			String major = inputMajor();
			String university = inputUniversityName();
			int semes = inputSemester();
			
			candidate.setFullName(name);
			candidate.setCandidateType(type);
			candidate.setBirthday(birthday);
			candidate.setPhone(phone);
			candidate.setEmail(email);
			
			((Intern) candidate).setMajor(major);
			((Intern) candidate).setUniversityName(university);
			((Intern) candidate).setSemester(semes);
			
			if (!CandidateUtils.isValidEmail(email)) {
				throw new InvalidateEmailException();
			} else if (!CandidateUtils.isValidBirthday(birthday)) {
				throw new InvalidateBirthdayException();
			} else
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
	
	private int inputCandidateId() {
		 System.out.print("Enter candidate id: ");
	     return sc.nextInt();
	}
	 
	private int inputType() {
		 System.out.print("Enter candidate type: ");
	     return sc.nextInt();
	}
	
	private String inputBirthday() {
		 System.out.print("Enter candidate birthday, ex: 03/03/2020: ");
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
		System.out.println("Enter candidate graduate date, ex: 03/03/2020: ");
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
	
	private String inputCertificatedName() {
		System.out.println("Enter certificated name: ");
		return sc.nextLine();
	}
	
	private String inputCertificatedRank() {
		System.out.println("Enter certificated rank: ");
		return sc.nextLine();
	}
	
	private String inputCertificatedDate() {
		System.out.println("Enter certificated date, ex: 03/03/2020 : ");
		return sc.nextLine();
	}

}
