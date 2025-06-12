package shop;

import java.util.Random;


public enum ShopOption {
    SELL_FISH,
    BUY_ROD,
    BUY_FISH_BAIT;

    private static final Random RANDOM = new Random();

    public static ShopOption getRandomShopOption(){
        ShopOption[] option = values();
        return option[RANDOM.nextInt(option.length)];
    }
}
