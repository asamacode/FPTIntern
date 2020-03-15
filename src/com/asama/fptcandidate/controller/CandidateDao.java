package com.asama.fptcandidate.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.asama.fptcandidate.model.Candidate;
import com.asama.fptcandidate.model.Experience;
import com.asama.fptcandidate.model.Fresher;
import com.asama.fptcandidate.model.Intern;

public class CandidateDao {
	private Connection conn;
	
	public CandidateDao() {
		this.conn = JDBCConnection.getJDBCConnection();;
	}

	public void insert(Candidate candidate) {
		try {
			conn.setAutoCommit(false);
			PreparedStatement prepStmt = conn.prepareStatement(
					"INSERT INTO candidates(fullName, birthday, phone, email, candidateType, expInYear"
					+ ", proSkill, graduationDate, graduationRank, education, major, universityName, semester) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			prepStmt.setString(1, candidate.getFullName());
			prepStmt.setString(2, candidate.getBirthday());
			prepStmt.setString(3, candidate.getPhone());
			prepStmt.setString(4, candidate.getEmail());
			prepStmt.setInt(5, candidate.getCandidateType());
			
			if (candidate.getCandidateType() == Candidate.TYPE_EXPERIENCE) {
				
				if (candidate instanceof Experience) {
					Experience exper = (Experience) candidate;
					prepStmt.setInt(6, exper.getExpInYear());
					prepStmt.setString(7, exper.getProSkill());
					prepStmt.setString(8, "");
					prepStmt.setString(9, "");
					prepStmt.setString(10, "");
					prepStmt.setString(11, "");
					prepStmt.setString(12, "");
					prepStmt.setInt(13, 0);
				}
				
			} else if (candidate.getCandidateType() == Candidate.TYPE_FRESHER) {
				
				if (candidate instanceof Fresher) {
					Fresher fres = (Fresher) candidate;
					prepStmt.setInt(6, 0);
					prepStmt.setString(7, "");
					prepStmt.setString(8, fres.getGraduationDate());
					prepStmt.setString(9, fres.getGraduationRank());
					prepStmt.setString(10, fres.getEducation());
					prepStmt.setString(11, "");
					prepStmt.setString(12, "");
					prepStmt.setInt(13, 0);
				}
				
			} else if (candidate.getCandidateType() == Candidate.TYPE_INTERN) {
				if (candidate instanceof Intern) {
					Intern intern = (Intern) candidate;
					prepStmt.setInt(6, 0);
					prepStmt.setString(7, "");
					prepStmt.setString(8, "");
					prepStmt.setString(9, "");
					prepStmt.setString(10, "");
					prepStmt.setString(11, intern.getMajor());
					prepStmt.setString(12, intern.getUniversityName());
					prepStmt.setInt(13, intern.getSemester());
				}
			}
			
			prepStmt.addBatch();  
			
			prepStmt.executeBatch();
			  
			System.out.println("Insert completed ");
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
