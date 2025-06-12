package fishingrods;

import java.util.Random;

public class FarFlyer extends FishingRod {
    static int MIN_DURABILITY = 8;
    static int MAX_DURABILITY = 9;

    static int MIN_REELSPEED = 14;
    static int MAX_REELSPEED = 15;

    static int MIN_ACCURACY = 9;
    static int MAX_ACCURACY = 10;

    static int MIN_RANGE = 16;
    static int MAX_RANGE = 17;

    static int MIN_GOLD = 14;
    static int MAX_GOLD = 16;

    public static void setDurabilityLimits(int min, int max){
        MIN_DURABILITY = min;
        MAX_DURABILITY = max;
    }

    public static void setReelSpeedLimits(int min, int max){
        MIN_REELSPEED = min;
        MAX_REELSPEED = max;
    }

    public static void setAccuracyLimits(int min, int max){
        MIN_ACCURACY = min;
        MAX_ACCURACY = max;
    }

    public static void setRangeLimits(int min, int max){
        MIN_RANGE = min;
        MAX_RANGE = max;
    }

    public static void setGoldLimits(int min, int max){
        MIN_GOLD = min;
        MAX_GOLD = max;
    }

    public FarFlyer() {
        FISHING_ROD_NAME = "Far Flyer";

        Random rand = new Random();
        durability = rand.nextInt((MAX_DURABILITY - MIN_DURABILITY) + 1) + MIN_DURABILITY;
        gold = rand.nextInt((MAX_GOLD - MIN_GOLD) + 1) + MIN_GOLD;
        reelSpeed = rand.nextInt((MAX_REELSPEED - MIN_REELSPEED) + 1) + MIN_REELSPEED;
        accuracy = rand.nextInt((MAX_ACCURACY - MIN_ACCURACY) + 1) + MIN_ACCURACY;
        range = rand.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;

        maxDurability = durability;
    }
}
