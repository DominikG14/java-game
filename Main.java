import fishingrods.*;
import shop.*;
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
        goFishing();

        // while( GAME_IS_RUNNING ){
        //     // goFishing();
        //     // goShopping();
            
        //     player.nextDay();

        //     // if( player.isEndOfWeek() ){
        //     //     payRent();
        //     // }

        //     // increaseRodsStats();
        //     // increaseFishStats();
        // }
    }

    private static void dispGold(){
        System.out.println(Console.YELLOW + "Gold: " + player.getGold() + "$" + Console.RESET);
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

            shop.dispShop();

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
        player.addRod(firstRod);
        player.pay(firstRod.getGold());
    }

    private static void goFishing(){
        Scanner userInput = new Scanner(System.in);
        int poolNum;

        boolean error = false;
        String err_msg = "";


        while ( true ){
            Console.clearScreen();

            Console.textSeparator("STATS");
            player.dispStats();

            Console.textSeparator("FISHING ROD");
            FishingRod rod = player.getRod(0);
            rod.dispName();
            rod.dispStats();

            Console.textSeparator("POOLS");
            Pool pool = new Pool();
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
        
    }
}