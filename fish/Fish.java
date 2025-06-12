package fish;

import console.*;

public abstract class Fish {
    protected String FISH_NAME = "Fish";

    protected int reelSpeed;
    protected int accuracy;
    protected int range;
    protected int number;
    protected int probability;
    protected int gold;

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

    public int getProbability(){
        return probability;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getGold(){
        return gold;
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

    public void dispSellInfo(){
        System.out.print(Console.BOLD + Console.UNDERLINE);
        dispName();
        System.out.print(Console.RESET);

        System.out.println(": " + Console.YELLOW + "G: " + gold + "$" + Console.RESET);
    }

    public void dispCaughtInfo(){
        System.out.print(Console.BOLD + Console.UNDERLINE);
        dispName();
        System.out.print(Console.RESET);

        System.out.println(" x " + number);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Fish)) return false;

        Fish otherFish = (Fish) object;
        return FISH_NAME == otherFish.FISH_NAME;
    }
}
