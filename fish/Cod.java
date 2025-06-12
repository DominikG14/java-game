package fish;

import java.util.Random;

public class Cod extends Fish {
    static int MIN_REELSPEED = 12;
    static int MAX_REELSPEED = 14;

    static int MIN_ACCURACY = 10;
    static int MAX_ACCURACY = 13;

    static int MIN_RANGE = 3;
    static int MAX_RANGE = 5; 

    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 2;

    static int MIN_PROBABILITY = 50;
    static int MAX_PROBABILITY = 75;

    static int MIN_GOLD = 8;
    static int MAX_GOLD = 12;

    public Cod(){
        FISH_NAME = "Cod";

        Random rand = new Random();
        number = rand.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
        probability = rand.nextInt((MAX_PROBABILITY - MIN_PROBABILITY) + 1) + MIN_PROBABILITY;
        reelSpeed = rand.nextInt((MAX_REELSPEED - MIN_REELSPEED) + 1) + MIN_REELSPEED;
        accuracy = rand.nextInt((MAX_ACCURACY - MIN_ACCURACY) + 1) + MIN_ACCURACY;
        range = rand.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;
        gold = rand.nextInt((MAX_GOLD - MIN_GOLD) + 1) + MIN_GOLD;
    }
}
