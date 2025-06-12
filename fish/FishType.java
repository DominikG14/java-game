package fish;

import java.util.Random;

public enum FishType {
    CARP,
    COD,
    MACKEREL,
    PIKE,
    SALMON,
    TUNA;

    private static final Random RANDOM = new Random();

    public static FishType getRandomFishType(){
        FishType[] fishType = values();
        return fishType[RANDOM.nextInt(fishType.length)];
    }
}
