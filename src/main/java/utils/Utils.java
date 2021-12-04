package utils;

public class Utils {

    public static String getRandomString(String prefix) {
        return prefix + System.currentTimeMillis();
    }
}
