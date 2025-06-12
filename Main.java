import fishingrods.*;
import shop.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import player.*;
import fish.*;
import pool.*;

import console.*;

public class Main {
    static boolean GAME_IS_RUNNING = true;
    static Player player = new Player();

    public static void main(String[] args) {
        buyFirstRod();

        while( GAME_IS_RUNNING ){
            goFishing();
            goShopping();
            
            player.nextDay();

            if( player.isEndOfWeek() ){
                if( !player.payRent() ){
                    GAME_IS_RUNNING = false;
                }
            }
        }

        // endGameStats();
    }

    private static void buyFirstRod(){
        Scanner userInput = new Scanner(System.in);
        int rodNum;

        boolean error = false;
        String err_msg = "";

        Shop shop = new Shop();
        shop.generateRandomRods(3);

        while( true ){
            Console.clearScreen();

            player.dispGold();
            System.out.println();

            System.out.println(Console.BOLD + Console.UNDERLINE + "Buy your first fishing rod!" + Console.RESET);
            System.out.println();

            shop.dispFirstRodShop();

            if(error) {
                System.out.println(Console.RED + err_msg + Console.RESET);
                error = false;
            }
            System.out.print("Choose number of rod to buy:\n> ");

            if (userInput.hasNextInt()) {
                rodNum = userInput.nextInt();
                if (rodNum >= 1 && rodNum <= 3) break;
                error = true;
                err_msg = "Number out of range! Try again";
            } else {
                error = true;
                err_msg = "Not a number! Try again";
                userInput.next();
            }
        }

        FishingRod firstRod = shop.getRod(rodNum - 1);
        player.addRod( firstRod );
        player.pay( firstRod.getGold() );
    }

    private static void goFishing(){
        Scanner userInput = new Scanner(System.in);
        int poolNum;

        boolean error = false;
        String err_msg = "";

        for( FishingRod rod : player.getRods() ){
            Pool pool = new Pool();

            while ( true ){
                Console.clearScreen();

                Console.textSeparator("STATS");
                player.dispStats();

                Console.textSeparator("FISHING ROD");
                rod.dispName();
                rod.dispStats(true);

                Console.textSeparator("POOLS");
                pool.dispPools();

                Console.textSeparator(Console.BRIGHT_RED + "CHOOSE YOUR ACTION" + Console.RESET, true, false);
                if(error) {
                    System.out.println(Console.RED + err_msg + Console.RESET);
                    error = false;
                }
                System.out.println(
                    "Choose" + Console.CYAN + " pool " + Console.RESET + 
                    "to fish in (" + Console.CYAN +  "1-3" + Console.RESET + ")."
                );
                System.out.print(
                    "Or type '" + Console.RED + "0" + Console.RESET + 
                    "' to" + Console.RED + " skip " + Console.RESET + 
                    "fishing with current rod\n> "
                );

                if (userInput.hasNextInt()) {
                    poolNum = userInput.nextInt();
                    if(poolNum == 0) break;
                    if (poolNum >= 1 && poolNum <= 3) break;
                    error = true;
                    err_msg = "Number out of range! Try again";
                } else {
                    error = true;
                    err_msg = "Not a number! Try again";
                    userInput.next();
                }
            }

            if( poolNum == 0 ) continue;

            Random rand = new Random();
            for( Fish fish : pool.getPool(poolNum) ){
                int fishBait = player.getFishBait();
                int rodDurability = rod.getDurability();

                if( rodDurability == 0 || fishBait == 0 ) break;

                int fishProbability = fish.getProbability();
                fishProbability += rod.getReelSpeed() - fish.getReelSpeed();
                fishProbability += rod.getAccuracy() - fish.getAccuracy();
                fishProbability += rod.getRange() - fish.getRange();

                int caughtProbability = 1 + rand.nextInt(100);

                rodDurability -= fish.getNumber();
                rod.setDurability(rodDurability);
                if(rodDurability < 0){
                    int excess = -rodDurability;
                    fish.setNumber( fish.getNumber() - excess );
                    rod.setDurability(0);
                }

                fishBait -= fish.getNumber();
                player.setFishBait(fishBait);
                if(fishBait < 0){
                    int excess = -rodDurability;
                    fish.setNumber( fish.getNumber() - excess );
                    player.setFishBait(0);
                }

                if(caughtProbability <= fishProbability){
                    if( player.getFishCaught().contains(fish) ){
                        int fishIndex = player.getFishCaught().indexOf(fish);
                        Fish caughtFish = player.getFishCaught().get(fishIndex);
                        caughtFish.setNumber( caughtFish.getNumber() + fish.getNumber() );
                    } else {
                        player.addFish(fish);
                    }
                }
            }
        }

        player.removeWornOutRods();
    }

    public static void goShopping(){
        Scanner userInput = new Scanner(System.in);
        int optionNum;
        int shopActions = 0;

        boolean error = false;
        String err_msg = "";

        Shop shop = new Shop();
        shop.generateShopOffer();

        while(shopActions < Shop.MAX_SHOP_ACTIONS){
            while( true ){
                Console.clearScreen();

                Console.textSeparator("STATS");
                player.dispStats();

                if( !player.getFishCaught().isEmpty() ){
                    Console.textSeparator("FISH");
                    player.dispFishCaught();
                }

                Console.textSeparator("FISHING RODS");
                for(FishingRod rod : player.getRods() ){
                    rod.dispShortenStats();
                }

                Console.textSeparator(Console.YELLOW + "SHOP" + Console.RESET);
                shop.dispShopOffer();

                Console.textSeparator(Console.BRIGHT_RED + "CHOOSE YOUR ACTION" + Console.RESET, true, false);
                if(error) {
                    System.out.println(Console.RED + err_msg + Console.RESET);
                    error = false;
                }
                System.out.println(
                    "Choose" + Console.YELLOW + " option " + Console.RESET + 
                    "(" + Console.YELLOW +  "1-" + Shop.MAX_SHOP_ITEMS + Console.RESET + ")."
                );
                System.out.print(
                    "Or type '" + Console.RED + "0" + Console.RESET + 
                    "' to" + Console.RED + " skip " + Console.RESET + 
                    "visiting shop\n> "
                );

                if (userInput.hasNextInt()) {
                    optionNum = userInput.nextInt();
                    if(optionNum == 0) break;
                    if (optionNum >= 1 && optionNum <= Shop.MAX_SHOP_ITEMS) break;
                    error = true;
                    err_msg = "Number out of range! Try again";
                } else {
                    error = true;
                    err_msg = "Not a number! Try again";
                    userInput.next();
                }
            }

            if(optionNum == 0) break;
            optionNum--; // Indexes are one less than choosen option

            ShopOption option = shop.getChoosenOption(optionNum);

            switch(option){
                case BUY_ROD:
                    FishingRod rod = shop.getRodFromShop( optionNum );
                    if( player.getRods().size() == Player.MAX_ROD_NUM ){
                        error = true;
                        err_msg = "Not enough space to buy this Fishing Rod!";
                        break;
                    }

                    if( player.getGold() >= rod.getGold() ){
                        player.pay( rod.getGold() );
                        player.addRod(rod);
                        shop.sellOption( optionNum );
                        shopActions++;
                    } else {
                        error = true;
                        err_msg = "Not enough gold to buy this Fishing Rod!";
                    }
                    break;

                case BUY_FISH_BAIT:
                    if( player.getGold() >= shop.getFishBaitPrice() ){
                        player.pay( shop.getFishBaitPrice() );
                        int newFishBaitAmmount = player.getFishBait() + shop.getFishBaitNum();
                        player.setFishBait( newFishBaitAmmount );
                        shop.sellOption( optionNum );
                        shopActions++;
                    } else {
                        error = true;
                        err_msg = "Not enough gold to buy Fishing Bait!";
                    }
                    break;
                    
                case SELL_FISH:
                    Fish sellFish = shop.getFishToSell( optionNum );
                    
                    if( player.getFishCaught().contains(sellFish) ){
                        int fishIndex = player.getFishCaught().indexOf(sellFish);
                        Fish caughtFish = player.getFishCaught().get(fishIndex);

                        int newGold = player.getGold();
                        newGold += caughtFish.getNumber() * sellFish.getGold();
                        
                        player.setGold(newGold);
                        player.getFishCaught().remove(fishIndex);

                        shop.sellOption( optionNum );
                        shopActions++;
                    } else {
                        error = true;
                        err_msg = "You don't have this fish!";
                    }
                    break;
            }
        }

        List<Fish> fishCaught = player.getFishCaught();
        fishCaught.clear();
    }
}