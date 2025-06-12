package fish;

import java.util.Random;

public class Pike extends Fish {
    static int MIN_REELSPEED = 6;
    static int MAX_REELSPEED = 8;

    static int MIN_ACCURACY = 14;
    static int MAX_ACCURACY = 16;

    static int MIN_RANGE = 11;
    static int MAX_RANGE = 14; 

    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 1;

    static int MIN_PROBABILITY = 25;
    static int MAX_PROBABILITY = 55;

    static int MIN_GOLD = 18;
    static int MAX_GOLD = 24;

    public Pike(){
        FISH_NAME = "Pike";

        Random rand = new Random();
        number = rand.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
        probability = rand.nextInt((MAX_PROBABILITY - MIN_PROBABILITY) + 1) + MIN_PROBABILITY;
        reelSpeed = rand.nextInt((MAX_REELSPEED - MIN_REELSPEED) + 1) + MIN_REELSPEED;
        accuracy = rand.nextInt((MAX_ACCURACY - MIN_ACCURACY) + 1) + MIN_ACCURACY;
        range = rand.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;
        gold = rand.nextInt((MAX_GOLD - MIN_GOLD) + 1) + MIN_GOLD;
    }
}
