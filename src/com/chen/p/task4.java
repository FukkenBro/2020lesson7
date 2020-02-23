package com.chen.p;

//4*. Задана строка с датой вида "22.01.2019 19:15:00". Написать метод который преобразовывает ее в формат "22 Jan, 7:15 PM".
// Предусмотреть обработку ситуации если входящая дата в недопустимом формате.

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class task4 {
    private static final String INPUT_DATE = "22.01.2019 19:15:00";
    private static final String INPUT_DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";
    private static final String OUTPUT_DATE_FORMAT = "d MMM, h:mm a";

    public static void main(String[] args) {
        System.out.println(INPUT_DATE);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_DATE_FORMAT);
        LocalDateTime date = null;
        try {
            date = LocalDateTime.parse(INPUT_DATE, format);
        } catch (Exception e) {
            System.out.println("Недопустимый формат");
        }
        System.out.println(reformat(date));
    }

    private static String reformat(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(OUTPUT_DATE_FORMAT, Locale.US);
        String result = date.format(formatter);
        return result;
    }
}
