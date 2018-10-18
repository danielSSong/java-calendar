package com.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT  = "cal> ";
	public void runPrompt() {
		String PROMPT = "cal> ";
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;

		while (true) {
			System.out.println("please input the month");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			if (month == 0) {
				break;
			}
			cal.printCalendar(2018, month);
		}

		scanner.close();
	}
	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
