package Modele;

import java.util.Random;

public class GenRandom {
    public static int get(int max) {
        Random r = new Random();
        return r.nextInt(max);
    }
}

