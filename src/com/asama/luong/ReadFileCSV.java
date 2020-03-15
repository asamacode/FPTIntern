package com.asama.luong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadFileCSV {
	
	public static void main(String[] args) throws IOException {
		readFileData("src/STD.csv", "src/error.txt");
	}

	private static void readFileData(String path, String output) throws IOException {
		BufferedReader br = null;
		PrintWriter pr = null;
		try {
			br = new BufferedReader(new FileReader(path)); 
			pr = new PrintWriter(new FileWriter(output));
			String line = null;
			int i = 0;
			while ((line = br.readLine()) != null) {
				i++;
				String[] listSTD = line.split(",");
				System.out.println(listSTD[0] + "-" + listSTD[1] + "-" + listSTD[2] + "-" + listSTD[3] + listSTD[4]);
				validateFileCSV(listSTD, pr, i);
			}
		} finally {
			if (br != null) {
				br.close();
			}
			
			if (pr != null) {
				pr.close();
			}
		}
	}
	
	private static void validateFileCSV(String[] list, PrintWriter pr, int i) {
		if (!isValidPhone(list[2]) && !isValid(list[3])) {
			pr.println("Line " + i + ": co loi sai dinh dang StdPhone, StdEmail");
		} else if (!isValidPhone(list[2])) {
			pr.println("Line " + i + ": co loi sai dinh dang StdPhone");
		} else if (!isValid(list[3])) {
			pr.println("Line " + i + ": co loi sai dinh dang StdEmail");
		}
	}
	
	static boolean isValid(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	   }
	
	static boolean isValidPhone(String phone) {
		if (phone.matches("[0-9]+") && phone.length() == 9) {
			return true;
		} else {
			return false;
		}
	}
}
