package com.asama.fptcandidate.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.asama.fptcandidate.model.Candidate;
import com.asama.fptcandidate.model.Certificated;
import com.asama.fptcandidate.model.Experience;
import com.asama.fptcandidate.model.Fresher;
import com.asama.fptcandidate.model.Intern;
import com.asama.fptcandidate.utils.LogFactory;

public class CandidateDao {
	private Connection conn;
	private Logger infoLogger, errorLogger;

	public CandidateDao() {
		this.conn = JDBCConnection.getJDBCConnection();
		this.infoLogger = LogFactory.getInfoLogger();
		this.errorLogger = LogFactory.getErrorLogger();
	}

	public void insert(Candidate candidate) {
		try {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO candidates(fullName, birthday, phone, email, candidateType, expInYear"
					+ ", proSkill, graduationDate, graduationRank, education, major, universityName, semester) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prepStmt = conn.prepareStatement(sql);

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
			// log info
			infoLogger.info(sql);
			prepStmt.close();

		} catch (SQLException e) {
			// log error
			e.printStackTrace();
			errorLogger.error(e.getMessage().toString());
		}
	}

	public String loadCandidateName() {

		boolean first = false;

		StringBuffer sb = new StringBuffer();

		PreparedStatement ps;
		try {
			String sql = "SELECT * FROM candidates";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
//		    rs.beforeFirst();

			while (rs.next()) {
				if (!first) {
					sb.append(rs.getString("fullName"));
					first = true;
				} else {
					sb.append(", " + rs.getString("fullName"));
				}
			}
			// log info
			infoLogger.info(sql);
			ps.close();

		} catch (SQLException e) {
			// log error
			e.printStackTrace();
			errorLogger.error(e.getMessage().toString());
		}

		return sb.toString();
	}

	public List<Candidate> loadListCandidate() {

		List<Candidate> candidateList = new ArrayList<Candidate>();
		Candidate c = null;

		PreparedStatement ps;
		try {
			String sql = "SELECT * FROM candidates";
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
//		    rs.beforeFirst();

			while (rs.next()) {
				int type = rs.getInt("candidateType");

				switch (type) {
				case Candidate.TYPE_EXPERIENCE:
					c = new Experience();
					c.setCandidateID(rs.getInt("idCandidates"));
					c.setFullName(rs.getString("fullName"));
					c.setCandidateType(type);
					c.setBirthday(rs.getString("birthday"));
					c.setPhone(rs.getString("phone"));
					c.setEmail(rs.getString("email"));

					if (c instanceof Experience) {
						((Experience) c).setExpInYear(rs.getInt("expInYear"));
						((Experience) c).setProSkill(rs.getString("proSkill"));
					}

					break;
				case Candidate.TYPE_FRESHER:
					c = new Fresher();
					c.setCandidateID(rs.getInt("idCandidates"));
					c.setFullName(rs.getString("fullName"));
					c.setCandidateType(type);
					c.setBirthday(rs.getString("birthday"));
					c.setPhone(rs.getString("phone"));
					c.setEmail(rs.getString("email"));

					if (c instanceof Fresher) {
						((Fresher) c).setGraduationDate(rs.getString("graduationDate"));
						((Fresher) c).setGraduationRank(rs.getString("graduationRank"));
						((Fresher) c).setEducation(rs.getString("education"));
					}

					break;
				case Candidate.TYPE_INTERN:
					c = new Intern();
					c.setCandidateID(rs.getInt("idCandidates"));
					c.setFullName(rs.getString("fullName"));
					c.setCandidateType(type);
					c.setBirthday(rs.getString("birthday"));
					c.setPhone(rs.getString("phone"));
					c.setEmail(rs.getString("email"));

					if (c instanceof Intern) {
						((Intern) c).setMajor(rs.getString("major"));
						((Intern) c).setUniversityName(rs.getString("universityName"));
						((Intern) c).setSemester(rs.getInt("semester"));
					}

					break;
				default:
					System.out.println("Candidate type Not found");
					break;
				}

				candidateList.add(c);
			}
			// log info
			infoLogger.info(sql);
			ps.close();

		} catch (SQLException e) {
			// log error
			e.printStackTrace();
			errorLogger.error(e.getMessage().toString());
		}

		return candidateList;
	}

	public void updateAndInsertNewCandidate(int id) {

		PreparedStatement stmt;
		try {
			String sql = "SELECT * FROM candidates WHERE idCandidates = " + id;
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				rs.updateString("fullName", "Name updated 1");
				rs.updateRow();
			}

			System.out.println("Inserting a new record...");

			rs.moveToInsertRow();
			rs.updateString("fullName", "New Insert Name");
			rs.updateString("birthday", "08/10/1997");
			rs.updateString("phone", "0378345678");
			rs.updateString("email", "newinsert@gmail.com");
			rs.updateString("proSkill", "New Skill");
			rs.updateInt("candidateType", Candidate.TYPE_EXPERIENCE);
			rs.updateInt("expInYear", 10);
			// Commit row
			rs.insertRow();
			// log info
			infoLogger.info(sql);
			stmt.close();
		} catch (SQLException e) {
			// log error
			e.printStackTrace();
			errorLogger.error(e.getMessage().toString());
		}

	}

	public boolean checkCandidateExist(int id) {
		PreparedStatement ps;
		try {
			String sql = "SELECT * FROM candidates WHERE idCandidates = " + id;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
			// log info
			infoLogger.info(sql);
			ps.close();
		} catch (SQLException e) {
			// log error
			e.printStackTrace();
			errorLogger.error(e.getMessage().toString());
		}

		return false;
	}

	public void insertCertificated(int id, Certificated certi) {

		PreparedStatement prepStmt;
		try {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO certificated(certificatedName, certificatedRank, certificatedDate, idCandidates) "
					+ "values (?,?,?,?)";
			prepStmt = conn.prepareStatement(sql);

			prepStmt.setString(1, certi.getCertificatedName());
			prepStmt.setString(2, certi.getCertificatedRank());
			prepStmt.setString(3, certi.getCertificatedDate());
			prepStmt.setInt(4, id);

			prepStmt.addBatch();

			prepStmt.executeBatch();

			System.out.println("Insert completed ");
			conn.commit();
			// log info
			infoLogger.info(sql);
			prepStmt.close();
		} catch (SQLException e) {
			// log error
			e.printStackTrace();
			errorLogger.error(e.getMessage().toString());
		}

	}

	@Override
	protected void finalize() throws Throwable {
		if (conn != null) {
			conn.close();
		}
		super.finalize();
	}

}
