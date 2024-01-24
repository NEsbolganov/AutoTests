package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public String getRandomString(int length){
//        String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789";
        String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ";

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(AB.charAt(secureRandom.nextInt(AB.length())));
        }

        return sb.toString();
    }

    public int getRandomInt(int from, int to){
        return ThreadLocalRandom.current().nextInt(from, to+1);
    }

    public String getRandomEmail(int length){
        return getRandomString(length)  + "@qu.guru";
    }

    public String getRandomElementFromStringArray(String[] array){
        int index = getRandomInt(0, array.length -1);
        return array[index];
    }
}
