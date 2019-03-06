package by.it.skosirskiy.testim;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class testim {
    public static void main(String[] args) {
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(date);;
        Timestamp date2 = new Timestamp(0L);
        date2.setTime(date.getTime()+259200000L);
        System.out.println(date2);


    }
}
