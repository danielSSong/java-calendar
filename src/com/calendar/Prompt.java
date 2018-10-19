package com.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	private final static String PROMPT_YEAR  = "year> ";
	private final static String PROMPT_MONTH  = "month> ";

	public void printMenu() {
		System.out.println("+---------------------------");
		System.out.println("| 1.");
		System.out.println("| 2.");
		System.out.println("| 3.");
		System.out.println("| h.");
		System.out.println("+---------------------------");
		
	}
	
	public void runPrompt() throws ParseException {
		printMenu();
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		boolean isLoop = true;
		while (isLoop) {
			
			String cmd = scanner.next();
			switch(cmd) {
				case "1":
					cmdRegister(scanner, cal);
					break;
				case "2":
					cmdSearch(scanner, cal);
					break;
				case "3":
					cmdCal(scanner, cal);
					break;
				case "h":
					printMenu();
					break;
				case "q":
					isLoop = false;
					break;
			}
		}
		scanner.close();
	}
	
	public int parseDay(String week) {
		switch(week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;
		}
	}
	
	public void cmdCal(Scanner s, Calendar c) {
		
		int year = -1;
		int month = 2018;
		
		System.out.println("please input the year");
		System.out.print(PROMPT_YEAR);
		year = s.nextInt();
		if (year == -1) {
			System.out.println("Wrong Input");
		}
		System.out.println("please input the month");
		System.out.print(PROMPT_MONTH);
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("Wrong Input");
			return;
		}
	
		c.printCalendar(year, month);
	}
	
	public void cmdSearch(Scanner s, Calendar c) {
		System.out.println("[Search Schedule]");
		System.out.println("Please input the date(yyyy-MM-dd).");
		String date = s.next();
		String plan = "";

		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("Error Detected");
		}
		System.out.println(plan);
	}
	
	public void cmdRegister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[Register Schedule]");
		System.out.println("Please input the date(yyyy-MM-dd).");
		String date = s.next();
		System.out.println("Please input the schedule.");
		String text = "";
		while (true) {
			String word = s.next();
			text += word + " ";
			if (word.endsWith(";")) {
				break;
			}
		}
		c.registerPlan(date, text);
		
	}
	
	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
