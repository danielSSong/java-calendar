package com.calendar;

import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private HashMap<Date, PlanItem> planMap;

	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
	}
	/**
	 * 
	 * @param date ex: "2018-06-20"
	 * @param plan
	 * @throws ParseException 
	 */
	public void registerPlan(String strDate, String plan) {
		PlanItem p = new PlanItem(strDate, plan);
		//System.out.println(date);
		planMap.put(p.getDate(), p);
	}
	
	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
	}
	
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}
		else {
			return false;	
		}
	}
	
	public int getMaxDaysOfYearAndMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month -1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf("    <<%4d %d>>\n" , year ,month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		//get weekday automatically
		int weekday = getWeekday(year, month, 1);
		
		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		int maxDay = getMaxDaysOfYearAndMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println();
	}

	private int getWeekday(int year, int month, int day) {
		int syear = 1900;

		final int STANDARD_WEEKDAY = 1; // 1900.1.1 Monday
		
		int count = 0;
		
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfYearAndMonth(year, i);
			count += delta;
		}
		
		count += day - 1;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}
	
	public static void main(String[] args) throws ParseException {
		Calendar cal = new Calendar();
		
		cal.registerPlan("2018-06-23", "Let's eat beef");
		System.out.println(cal.searchPlan("2018-06-23").equals("Let's eat beef"));
	}
}

//ctrl + shift + f
