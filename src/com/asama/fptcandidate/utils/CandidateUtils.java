package com.asama.fptcandidate.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class CandidateUtils {

	public static boolean isValidEmail(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	}
	
	public static boolean isValidBirthday(String dateStr) {
		String dateCheck = "01/01/1900";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateStr, dtf);
		LocalDate dateC = LocalDate.parse(dateCheck, dtf);
		return date.isAfter(dateC) && date.isBefore(LocalDate.now());
  }
	
	public static long dateToMilis(String dateStr) {
		StringBuilder sb = new StringBuilder(dateStr);
		sb.append(" 10:00:00");
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(sb.toString(), dtf);
		
		return date.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
	}
	
}
