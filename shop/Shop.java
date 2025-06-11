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
            int pick = random.nextInt(2);

            switch (pick) {
                case 0:
                    rod = new LightningRod();
                    break;
                case 1:
                    rod = new FlashCast();
                    break;
                default:
                    rod = null;
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
