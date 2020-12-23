package utils;

import java.util.Random;

public class RandomGen {
    public static int get(int min, int max) {
        Random r = new Random();
        return min + r.nextInt(max);
    }
}
