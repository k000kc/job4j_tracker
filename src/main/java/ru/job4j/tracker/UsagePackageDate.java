package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Текущая дата: " + currentDate);
        System.out.println("Текущее время: " + currentTime);
        System.out.println("Текущие дата и время: " + currentDateTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        String dateTimeFormat = localDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + dateTimeFormat);
    }
}
