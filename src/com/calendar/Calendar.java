package com.calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		System.out.println("Hello, Calendar");
		System.out.println("Sun Mon TUE WED THU FRI SAT");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("input the month");
		int month = scanner.nextInt();
		
		int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		System.out.printf("%d has %d days. \n", month, maxDays[month -1 ]);
		scanner.close();
	}
}
