package com.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT_YEAR  = "year> ";
	private final static String PROMPT_MONTH  = "month> ";
	/**
	 * 
	 * @param week the name of day
	 * @return 0~6 (0=sunday, 1=monday, 2=tuesday, 3=wednesday, 4=thursday, 5=friday, 6=saturday)
	 */
	public int parseDay(String week) {
		if (week.equals("SU")) {
			return 0;
		} else if (week.equals("")) {
			return 1;
		} else if (week.equals("TU")) {
			return 2;
		} else if (week.equals("WE")) {
			return 3;
		} else if (week.equals("TH")) {
			return 4;
		} else if (week.equals("FR")) {
			return 5;
		} else if (week.equals("SA")) {
			return 6;
		} else {
			return 0;
		}
	}
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int year = -1;
		int month = 2018;

		while (true) {
			System.out.println("please input the year");
			System.out.print(PROMPT_YEAR);
			year = scanner.nextInt();
			if (year == -1) {
				break;
			}
			System.out.println("please input the month");
			System.out.print(PROMPT_MONTH);
			month = scanner.nextInt();
	
			if (month > 12 || month < 1) {
				System.out.println("Wrong Input");
				continue;
			}
		
			cal.printCalendar(year, month);
		}

		scanner.close();
	}
	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
