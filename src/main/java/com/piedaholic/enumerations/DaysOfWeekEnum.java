package com.piedaholic.enumerations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum DaysOfWeekEnum {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public static Stream<?> getDaysOfWeekAsStream() {
        // return Stream.of(DaysOfWeek.values());
        return Arrays.stream(DaysOfWeekEnum.values());
    }

    public static List<?> getDaysOfWeekAsList() {
        //return Arrays.asList(DaysOfWeekEnum.values());
         return List.of(DaysOfWeekEnum.values());
        //return Arrays.stream(DaysOfWeekEnum.values()).collect(Collectors.toList());
    }

    public static void howItFeelsLike(DaysOfWeekEnum day) {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are the worst");
                break;
            case TUESDAY:
                System.out.println("Tuesdays are bad");
                break;
            case WEDNESDAY:
                System.out.println("Wednesdays are okay");
                break;
            case THURSDAY:
                System.out.println("Thursdays are good");
                break;
            case FRIDAY:
                System.out.println("Fridays are better");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best");
                break; 
        }

    }

}
