/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarTest {

    public static void makeCalendarList() {
        int year = 2016;
        int month = 11;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        List<Calendar> weekRectangleList = new ArrayList<>();
        Calendar dayTraveler = Calendar.getInstance();
        dayTraveler.set(year, month, 1);
        Calendar nextMonth = (Calendar) dayTraveler.clone();
        nextMonth.add(Calendar.MONTH, 1);

        while (dayTraveler.before(nextMonth)) {
            Calendar day = (Calendar) dayTraveler.clone();
            weekRectangleList.add(day);
            dayTraveler.add(Calendar.DATE, 1);
        }

        // add last week of the previous month
        dayTraveler = (Calendar)weekRectangleList.get(0).clone();
        while (dayTraveler.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            dayTraveler.add(Calendar.DATE, -1);
            Calendar day = (Calendar) dayTraveler.clone();
            weekRectangleList.add(0, day);
        }

        // add first week of the next month
        dayTraveler = (Calendar)weekRectangleList.get(weekRectangleList.size() - 1).clone();
        while (dayTraveler.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            dayTraveler.add(Calendar.DATE, 1);
            Calendar day = (Calendar) dayTraveler.clone();
            weekRectangleList.add(day);
        }

        for (Calendar day : weekRectangleList) {
            System.out.println(formatter.format(day.getTime()) + " / " + day.get(Calendar.DAY_OF_WEEK));
        }
    }
}
