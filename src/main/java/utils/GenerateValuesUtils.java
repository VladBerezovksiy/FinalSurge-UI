package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class GenerateValuesUtils {

    public static String makeTitle(String base) {
        return base + LocalDateTime.now();
    }

    public static String generateDateName() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String generateShortDateName() {
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String generateTimeName() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.getHour() + ":" + dateTime.getMinute();
    }

    public static int generateRandomNumberFrom1To99() {
        return 1 + (int) (Math.random() * 99);
    }

    public static int generateRandomNumberFrom1To9() {
        return 1 + (int) (Math.random() * 9);
    }

    public static int generateRandomNumberFrom100To150() {
        return 100 + (int) (Math.random() * 150);
    }

    public static int generateRandomNumberFrom1To20() {
        return 1 + (int) (Math.random() * 20);
    }

    public static int generateRandomNumber21To50() {
        return 21 + (int) (Math.random() * 50);
    }

}
