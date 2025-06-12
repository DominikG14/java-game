package pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fish.*;
import console.*;

public class Pool {
    private Random random = new Random();

    private List<Fish> pool_1 = new ArrayList<>();
    private List<Fish> pool_2 = new ArrayList<>();
    private List<Fish> pool_3 = new ArrayList<>();

    public Pool(){
        int numOfFish;
        int numOfAlreadyFish;
        Fish fish;
        
        numOfAlreadyFish = 0;
        numOfFish = 1 + random.nextInt(3);
        while(numOfAlreadyFish != numOfFish){
            fish = getRandomFish();

            if(pool_1.contains(fish)) continue;

            pool_1.add(fish);
            numOfAlreadyFish++;
        }

        numOfAlreadyFish = 0;
        numOfFish = 1 + random.nextInt(3);
        while(numOfAlreadyFish != numOfFish){
            fish = getRandomFish();

            if(pool_2.contains(fish)) continue;

            pool_2.add(fish);
            numOfAlreadyFish++;
        }

        numOfAlreadyFish = 0;
        numOfFish = 1 + random.nextInt(3);
        while(numOfAlreadyFish != numOfFish){
            fish = getRandomFish();

            if(pool_3.contains(fish)) continue;

            pool_3.add(fish);
            numOfAlreadyFish++;
        }
    }

    public Fish getRandomFish(){
        Fish fish;

        int pick = random.nextInt(6);

        switch (pick) {
            case 0:
                fish = new Carp();
                break;
            case 1:
                fish = new Cod();
                break;
            case 2:
                fish = new Mackerel();
                break;
            case 3:
                fish = new Pike();
                break;
            case 4:
                fish = new Salmon();
                break;
            case 5:
                fish = new Tuna();
                break;
            default:
                fish = null;
        }

        return fish;
    }

    public void dispPools(){
        System.out.println(Console.CYAN + Console.BOLD + "Pool 1:" + Console.RESET);
        for(Fish fish : pool_1){
            fish.dispFishInfo();
            System.out.println();
        }
        System.out.println();

        System.out.println(Console.CYAN + Console.BOLD + "Pool 2:" + Console.RESET);
        for(Fish fish : pool_2){
            fish.dispFishInfo();
            System.out.println();
        }
        System.out.println();

        System.out.println(Console.CYAN + Console.BOLD + "Pool 3:" + Console.RESET);
        for(Fish fish : pool_3){
            fish.dispFishInfo();
            System.out.println();
        }
        System.out.println();
    }

    public List<Fish> getPool(int poolNum){
        switch( poolNum ){
            case 1: return pool_1;
            case 2: return pool_2;
            case 3: return pool_3;
            default: return null;
        }
    }
}
