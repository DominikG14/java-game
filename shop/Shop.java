package shop;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fishingrods.*;
import console.*;
import fish.*;

public class Shop {
    public static final int MAX_SHOP_ITEMS = 6;
    public static final int MAX_SHOP_ACTIONS = 3;
    private static final Map<ShopOption, String> OPTION_NAME = Map.of(
        ShopOption.BUY_ROD, "Buy Fishing Rod",
        ShopOption.SELL_FISH, "Sell Fish",
        ShopOption.BUY_FISH_BAIT, "Buy Fish Bait"
    );

    private static int FISHBAIT_NUM = 5;

    private Random random = new Random();
    private List<FishingRod> rods = new ArrayList<>();
    private List<Fish> fishToSell = new ArrayList<>();
    private List<ShopOption> options = new ArrayList<>();
    private Map<Integer, Integer> rodIndex = new HashMap<>();
    private Map<Integer, Integer> fishIndex = new HashMap<>();
    private List<Boolean> optionAvailable = new ArrayList<>();

    public void generateRandomRods(int numOfRods) {
        FishingRod rod;

        for(int i = 0; i < numOfRods; i++){
            FishingRodType pick = FishingRodType.getRandomFishingRodType();

            switch(pick){
                case LIGHTNING_ROD:
                    rod = new LightningRod();
                    break;
                case FLASH_CAST:
                    rod = new FlashCast();
                    break;
                case EAGLE_EYE:
                    rod = new EagleEye();
                    break;
                case SURE_HOOK:
                    rod = new SureHook();
                    break;
                case FAR_REACH:
                    rod = new FarReach();
                    break;
                case HORIZON:
                    rod = new Horizon();
                    break;
                case RAPID_AIM:
                    rod = new RapidAim();
                    break;
                case TURBO_SHOT:
                    rod = new TurboShot();
                    break;
                case STORM_CHASER:
                    rod = new StormChaser();
                    break;
                case FAR_FLYER:
                    rod = new FarFlyer();
                    break;
                case LONG_SIGHT:
                    rod = new LongSight();
                    break;
                case SNIPER:
                    rod = new Sniper();
                    break;
                default:
                    rod = null;
                    break;
            }

            rods.add(rod);
        }
    }

    public FishingRod getRod(int rodNum) {
        return rods.get(rodNum);
    }

    public void generateRandomFish(){
        Fish fish;

        FishType pick = FishType.getRandomFishType();

        switch (pick) {
            case CARP:
                fish = new Carp();
                break;
            case COD:
                fish = new Cod();
                break;
            case MACKEREL:
                fish = new Mackerel();
                break;
            case PIKE:
                fish = new Pike();
                break;
            case SALMON:
                fish = new Salmon();
                break;
            case TUNA:
                fish = new Tuna();
                break;
            default:
                fish = null;
        }

        fishToSell.add(fish);
    }

    public void dispFirstRodShop(){
        for(int i = 0; i < rods.size(); i++){
            System.out.print(Console.BOLD + Console.UNDERLINE);
            System.out.print(i+1 + ") " + Console.RESET);

            System.out.print(Console.UNDERLINE);
            rods.get(i).dispName();
            System.out.print(Console.RESET);

            rods.get(i).dispGold();
            rods.get(i).dispStats();

            System.out.println();
        }
    }

    public void generateShopOffer(){
        for(int i = 0; i < MAX_SHOP_ITEMS; i++){
            ShopOption option = ShopOption.getRandomShopOption();
            options.add( option );
            optionAvailable.add(true);

            switch(option){
                case BUY_ROD:
                    generateRandomRods(1);
                    rodIndex.put(i, rods.size() - 1);
                case SELL_FISH:
                    generateRandomFish();
                    fishIndex.put(i, fishToSell.size() - 1);
                default: 
            }
        }
    }

    public int getFishBaitPrice(){
        return 2 * FISHBAIT_NUM;
    }

    public int getFishBaitNum(){
        return FISHBAIT_NUM;
    }

    public void dispShopOffer(){
        for(int i = 0; i < options.size(); i++){
            ShopOption option = options.get(i);
            String optionName = OPTION_NAME.get( option );

            System.out.println( i+1 + ") " + optionName );
            if( !optionAvailable.get(i) ){
                System.out.println(Console.RED + "SOLD OUT!" + Console.RESET);
                System.out.println();
                continue;
            }

            switch (option) {
                case BUY_ROD:
                    FishingRod rod = rods.get( rodIndex.get(i) );
                    rod.dispShortShopInfo();
                    break;
                case SELL_FISH:
                    Fish fish = fishToSell.get( fishIndex.get(i) );
                    fish.dispSellInfo();
                    break;
                case BUY_FISH_BAIT:
                    System.out.print(Console.YELLOW + "G:" + getFishBaitPrice() + "$" + Console.RESET + ", ");
                    System.out.println(Console.PURPLE + FISHBAIT_NUM + Console.RESET);
                    break;
                default: 
            }

            System.out.println();
        }
    }

    public ShopOption getChoosenOption(int optionNum){
        return options.get(optionNum);
    }

    public FishingRod getRodFromShop(int optionNum){
        return rods.get( rodIndex.get(optionNum) );
    }

    public void sellOption(int optionNum){
        optionAvailable.set(optionNum, false);
    }

    public Fish getFishToSell(int optionNum){
        return fishToSell.get( fishIndex.get(optionNum) );
    }
}
