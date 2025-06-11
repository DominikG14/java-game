package fish;

import java.util.Random;

public class Tuna extends Fish {
    static int MIN_REELSPEED = 1;
    static int MAX_REELSPEED = 2;

    static int MIN_ACCURACY = 3;
    static int MAX_ACCURACY = 4;

    static int MIN_RANGE = 5;
    static int MAX_RANGE = 6; 

    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 1;

    static int MIN_PROBABILITY = 30;
    static int MAX_PROBABILITY = 80;

    public Tuna(){
        FISH_NAME = "Tuna";

        Random rand = new Random();
        number = rand.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
        probability = rand.nextInt((MAX_PROBABILITY - MIN_PROBABILITY) + 1) + MIN_PROBABILITY;
        reelSpeed = rand.nextInt((MAX_REELSPEED - MIN_REELSPEED) + 1) + MIN_REELSPEED;
        accuracy = rand.nextInt((MAX_ACCURACY - MIN_ACCURACY) + 1) + MIN_ACCURACY;
        range = rand.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;
    }
}
