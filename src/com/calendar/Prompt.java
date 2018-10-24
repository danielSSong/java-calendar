package com.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	private final static String PROMPT_YEAR = "year> ";
	private final static String PROMPT_MONTH = "month> ";

	public void printMenu() {
		System.out.println("+---------------------------");
		System.out.println("| 1. Register schedule.");
		System.out.println("| 2. Search scehdule.");
		System.out.println("| 3. Show calendar.");
		System.out.println("| h. About calendar menu.");
		System.out.println("| q. Close the program.");
		System.out.println("+---------------------------");

	}

	public void runPrompt() throws ParseException {
		

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		boolean isLoop = true;
		while (isLoop) {
			printMenu();
			String cmd = scanner.next();
			switch (cmd) {
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
				System.out.println("Goodbye.");
				break;
			}
		}
		scanner.close();
	}

	public int parseDay(String week) {
		switch (week) {
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
		PlanItem plan;

		plan = c.searchPlan(date);
		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.err.println("There is no schedule on this day.");
		}
	}

	public void cmdRegister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[Register Schedule]");
		System.out.println("Please input the date(yyyy-MM-dd).");
		String date = s.next();
		String text = "";
		System.out.println("Please input the schedule.");
		String word;
		while(!(word = s.next()).endsWith(";")) {
			text += word + " ";
		}
		word = word.replaceAll(";", "");
		text += word;
		c.registerPlan(date, text);			

	}

	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
