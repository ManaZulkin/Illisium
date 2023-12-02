package com.illisium.resources.mechaniks;

import java.util.Random;

public class Roll {

    private static final Random random = new Random();

    public static int d4(){
        return random.nextInt(4) + 1;
    }
    public static int d6(){
        return random.nextInt(6) + 1;
    }
    public static int d10(){
        return random.nextInt(10) + 1;
    }
    public static int d20(){
        return random.nextInt(20) + 1;
    }
    public static int d8(){
        return random.nextInt(8) + 1;
    }
}
