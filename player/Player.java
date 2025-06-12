package player;

import fishingrods.*;
import java.util.List;
import java.util.ArrayList;
import console.*;
import fish.*;


public class Player {
    public static final int MAX_ROD_NUM = 3;

    private int rent = 50;
    private int gold = 100;
    private int day = 1;
    private int fishBait = 10;
    private List<FishingRod> rods = new ArrayList<FishingRod>();
    private List<Fish> fishCaught = new ArrayList<Fish>();

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getFishBait() {
        return fishBait;
    }

    public void setFishBait(int fishBait) {
        this.fishBait = fishBait;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<FishingRod> getRods(){
        return rods;
    }

    public FishingRod getRod(int rodNum) {
        return rods.get(rodNum);
    }

    public void setRods(List<FishingRod> rods) {
        this.rods = rods;
    }

    public void addRod(FishingRod rod) {
        rods.add(rod);
    }

    public void dispGold(){
        System.out.println(Console.YELLOW + "Gold: " + gold + "$" + Console.RESET);
    }

    public void dispRent(){
        System.out.println(Console.RED + "Next Rent: " + Console.YELLOW + rent + "$" + Console.RESET);
    }

    public void dispFishBait(){
        System.out.println(Console.PURPLE + "Fish Bait: " + fishBait + Console.RESET);
    }

    public void dispDayNum(){
        int dayCurr = day % 7;
        if(dayCurr == 0) dayCurr = 7;

        if(dayCurr < 6){
            System.out.println("Day: " + day + " (" + dayCurr + "/7)");
        } else {
            System.out.println("Day: " + day + " (" + Console.RED + dayCurr + "/7" + Console.RESET + ")");
        }
        
    }

    public void nextDay(){
        day++;
    }

    public void pay(int ammount){
        gold -= ammount;
    }

    public boolean isEndOfWeek(){
        return day % 7 == 1;
    }

    public void addFish(Fish fish){
        fishCaught.add(fish);
    }

    public void dispStats(){
        dispGold();
        dispRent();
        dispFishBait();
        dispDayNum();
    }

    public void removeRod(FishingRod rod){
        rods.remove(rod);
    }

    public void removeWornOutRods(){
        for (int i = rods.size() - 1; i >= 0; i--) {
            if (rods.get(i).getDurability() == 0) {
                rods.remove(i);
            }
        }
    }

    public boolean payRent(){
        gold -= rent;
        rent += rent / 2;
        if(gold < 0) return false;
        return true;
    }

    public void dispFishCaught(){
        for(Fish fish : fishCaught){
            fish.dispCaughtInfo();
        }
    }

    public List<Fish> getFishCaught(){
        return fishCaught;
    }
}
