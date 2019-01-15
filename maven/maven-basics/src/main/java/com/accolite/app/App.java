package com.accolite.app;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalDate.Property;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class App 
{
	public static String getAMorPM(LocalDateTime dt) {
		DateTimeFormatter builder = DateTimeFormat.forPattern("a");
		return  builder.print(dt);
	}
	
	public static int getdiff(LocalDate localDate, LocalDate localDate2) {
		return Days.daysBetween(localDate, localDate2).getDays();
	}
	
	public static String getday(LocalDate dt) {
		Property pDoW = dt.dayOfWeek();
    	return pDoW.getAsText();
	}
	
    public static void main(String[] args)
    {
    	LocalDate dt = new LocalDate();
    	System.out.println(dt);
    	System.out.println(getday(new LocalDate("2019-02-27")));
    	System.out.println(getAMorPM(new LocalDateTime()));
    	System.out.println(getdiff(dt,dt.plusDays(2)));
    }
}
