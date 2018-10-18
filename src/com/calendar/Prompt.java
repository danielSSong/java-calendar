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
		int weekday = 0;

		while (true) {
			System.out.println("please input the year");
			System.out.print(PROMPT_YEAR);
			year = scanner.nextInt();
			System.out.println("please input the month");
			System.out.print(PROMPT_MONTH);
			month = scanner.nextInt();
			
			System.out.println("Please input the first day of the month. (SU, MO, TU, WE, TH, FR, SA).");
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);
			
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			if (month == 0) {
				break;
			}
			cal.printCalendar(year, month, weekday);
		}

		scanner.close();
	}
	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
