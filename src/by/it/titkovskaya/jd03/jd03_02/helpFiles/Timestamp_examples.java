package by.it.titkovskaya.jd03.jd03_02.helpFiles;

import com.sun.jmx.snmp.Timestamp;

import java.time.LocalDateTime;
import java.util.Date;

public class Timestamp_examples {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp();

        long dateTime = timestamp.getDateTime();
        System.out.println("\nCurrent time LONG (nanoseconds):\n" + dateTime);

        Date standardDate = new Date(dateTime);
        System.out.println("\nTimestamp in standard format:\n" + timestamp.getDate() +"\n" + standardDate);

        Date dateFromLong = new Date(1550564702447L);
        System.out.println("\nConversion from LONG:\n" + dateFromLong);

        java.sql.Timestamp date = java.sql.Timestamp.valueOf("2019-01-04 15:25:00");
        System.out.println("\nSQL Timestamp from String: " + date);

        java.sql.Timestamp payDate = new java.sql.Timestamp(timestamp.getDateTime());
        System.out.println("Getting current Timestamp for SQL: " +payDate);

        System.out.println("\n******************** more suitable for SQL variant **********************");
        java.sql.Timestamp currentDate = java.sql.Timestamp.valueOf(LocalDateTime.now());
        System.out.println(currentDate);
    }
}

