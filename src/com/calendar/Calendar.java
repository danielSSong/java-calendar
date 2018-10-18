package com.calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public static void main(String[] args) {
		System.out.println("Sun Mon TUE WED THU FRI SAT");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");

		String PROMPT = "cal> ";		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		System.out.println(PROMPT);

		int month = 1;
		
		while (true) {
			System.out.println("please input the month");
			month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 13) {
				continue;
			}
			if (month == 0) {
				
			}
			System.out.printf("%d has %d days. \n", month, cal.getMaxDaysOfMonth(month));
		}

		scanner.close();
	}
}

//ctrl + shift + f
