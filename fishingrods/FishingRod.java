package fishingrods;

import console.Console;


public abstract class FishingRod {
    protected String FISHING_ROD_NAME = "FishingRod";

    protected int durability;
    protected int maxDurability;
    protected int gold;
    protected int reelSpeed;
    protected int accuracy;
    protected int range;
    
    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getReelSpeed() {
        return reelSpeed;
    }

    public void setReelSpeed(int reelSpeed) {
        this.reelSpeed = reelSpeed;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void dispName(){
        System.out.println(FISHING_ROD_NAME);
    }

    public void dispGold() {
        System.out.println(Console.YELLOW + "Cost: " + gold + "$" + Console.RESET);
    }

    public void dispStats(){
        System.out.println(Console.BRIGHT_RED + "Durability: " + durability + Console.RESET);
        System.out.println(Console.BRIGHT_BLUE + "Reel Speed: " + reelSpeed + Console.RESET);
        System.out.println(Console.BRIGHT_GREEN + "Accuracy:   " + accuracy + Console.RESET);
        System.out.println(Console.BRIGHT_YELLOW + "Range:      " + range + Console.RESET);
    }

    public void dispStats(boolean showMaxDurability){
        System.out.println(Console.BRIGHT_RED + "Durability: " + durability + "/" + maxDurability + Console.RESET);
        System.out.println(Console.BRIGHT_BLUE + "Reel Speed: " + reelSpeed + Console.RESET);
        System.out.println(Console.BRIGHT_GREEN + "Accuracy:   " + accuracy + Console.RESET);
        System.out.println(Console.BRIGHT_YELLOW + "Range:      " + range + Console.RESET);
    }

    public void dispShortenStats(){
        System.out.print(Console.BOLD + Console.UNDERLINE);
        dispName();
        System.out.print(Console.RESET);

        System.out.print(Console.RED + ": D" + durability + "/" + maxDurability + Console.RESET);
        System.out.print(Console.BRIGHT_BLUE + "S: " + reelSpeed + Console.RESET + ", ");
        System.out.print(Console.BRIGHT_GREEN + "A: " + accuracy + Console.RESET + ", ");
        System.out.print(Console.BRIGHT_YELLOW + "R: " + range + Console.RESET);
    }

    public void dispShopInfo(){
        dispName();
        dispGold();
        dispStats();
    }
} 