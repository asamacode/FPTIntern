package com.asama.fptcandidate.view;

import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws InvalidateBirthdayException, InvalidateEmailException {
		
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

		    public void uncaughtException(Thread t, Throwable e) {
		    	System.err.println("The system has encountered an unexpected problem, sincerely sorry");
		    	showMenu();
		    }
		 });
		
		String choose = null;
        boolean exit = false;
        CandidateManager manager = new CandidateManager();
        
        // show menu
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
            case "1":
            	manager.insertCandidate();
                break;
            case "2":
            	manager.loadCandidate();
                break;
            case "3" : 
            	manager.sortCandidate();
            	break;
            case "4" : 
            	manager.filterDuplicateCandidate();
            	break;
            case "5" :
            	manager.showCandidateName();
            	break;
            case "6" :
            	manager.updateCandidateName();
            	break;
            case "7" : 
            	manager.addCertificated();
            	break;
            case "0":
                System.out.println("Exited!");
                exit = true;
                break;
            default:
                System.out.println("Invalid! Please choose action in below menu:");
                break;
            }
            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }

	}

	
	 public static void showMenu() {
	        System.out.println("-----------FPT------------");
	        System.out.println("1. Add Candidate.");
	        System.out.println("2. Show candidate.");
	        System.out.println("3. Show sort candidate.");
	        System.out.println("4. Filter duplicate candidate id.");
	        System.out.println("5. Show all candidate name.");
	        System.out.println("6. Update and insert new candidate.");
	        System.out.println("7. Add certificated");
	        System.out.println("0. Exit.");
	        System.out.println("---------------------------");
	        System.out.print("Please choose: ");
	    }
}
