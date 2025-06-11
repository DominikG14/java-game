package fish;

import console.*;

public abstract class Fish {
    protected String FISH_NAME = "Fish";

    protected int reelSpeed;
    protected int accuracy;
    protected int range;
    protected int number;
    protected int probability;

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
        System.out.print(FISH_NAME);
    }

    public void dispFishInfo(){
        System.out.print(Console.BOLD + Console.UNDERLINE);
        dispName();
        System.out.print(Console.RESET);

        System.out.print(" x" + number + ":   \t\t");
        System.out.print(Console.BRIGHT_BLUE + "S: " + reelSpeed + Console.RESET + ", ");
        System.out.print(Console.BRIGHT_GREEN + "A: " + accuracy + Console.RESET + ", ");
        System.out.print(Console.BRIGHT_YELLOW + "R: " + range + Console.RESET);
    }
}
