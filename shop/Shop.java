package shop;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import fishingrods.*;
import console.*;

public class Shop {
    private Random random = new Random();
    private List<FishingRod> rods = new ArrayList<>();

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

    public void dispShop(){
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
}
