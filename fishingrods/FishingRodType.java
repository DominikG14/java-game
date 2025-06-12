package fishingrods;

import java.util.Random;


public enum FishingRodType {
    LIGHTNING_ROD,
    FLASH_CAST,
    EAGLE_EYE,
    SURE_HOOK,
    FAR_REACH,
    HORIZON,
    RAPID_AIM,
    TURBO_SHOT,
    STORM_CHASER,
    FAR_FLYER,
    LONG_SIGHT,
    SNIPER;


    private static final Random RANDOM = new Random();

    public static FishingRodType getRandomFishingRodType(){
        FishingRodType[] rodType = values();
        return rodType[RANDOM.nextInt(rodType.length)];
    }
}
