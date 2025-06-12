package fish;

import java.util.Random;

public class Carp extends Fish {
    static int MIN_REELSPEED = 2;
    static int MAX_REELSPEED = 4;

    static int MIN_ACCURACY = 3;
    static int MAX_ACCURACY = 5;

    static int MIN_RANGE = 12;
    static int MAX_RANGE = 15; 

    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 2;

    static int MIN_PROBABILITY = 40;
    static int MAX_PROBABILITY = 80;

    static int MIN_GOLD = 10;
    static int MAX_GOLD = 15;

    public Carp(){
        FISH_NAME = "Carp";

        Random rand = new Random();
        number = rand.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
        probability = rand.nextInt((MAX_PROBABILITY - MIN_PROBABILITY) + 1) + MIN_PROBABILITY;
        reelSpeed = rand.nextInt((MAX_REELSPEED - MIN_REELSPEED) + 1) + MIN_REELSPEED;
        accuracy = rand.nextInt((MAX_ACCURACY - MIN_ACCURACY) + 1) + MIN_ACCURACY;
        range = rand.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;
        gold = rand.nextInt((MAX_GOLD - MIN_GOLD) + 1) + MIN_GOLD;
    }
}
