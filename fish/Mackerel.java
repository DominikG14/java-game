package fish;

import java.util.Random;

public class Mackerel extends Fish {
    static int MIN_REELSPEED = 14;
    static int MAX_REELSPEED = 17;

    static int MIN_ACCURACY = 5;
    static int MAX_ACCURACY = 7;

    static int MIN_RANGE = 4;
    static int MAX_RANGE = 6; 

    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 3;

    static int MIN_PROBABILITY = 35;
    static int MAX_PROBABILITY = 70;

    static int MIN_GOLD = 7;
    static int MAX_GOLD = 11;

    public Mackerel(){
        FISH_NAME = "Mackerel";

        Random rand = new Random();
        number = rand.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
        probability = rand.nextInt((MAX_PROBABILITY - MIN_PROBABILITY) + 1) + MIN_PROBABILITY;
        reelSpeed = rand.nextInt((MAX_REELSPEED - MIN_REELSPEED) + 1) + MIN_REELSPEED;
        accuracy = rand.nextInt((MAX_ACCURACY - MIN_ACCURACY) + 1) + MIN_ACCURACY;
        range = rand.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;
        gold = rand.nextInt((MAX_GOLD - MIN_GOLD) + 1) + MIN_GOLD;
    }
}
