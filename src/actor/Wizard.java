package actor;

import util.InputGUI;

/**
 * Created by Lenny on 2/15/14.
 */
public class Wizard extends Actor{
    private boolean hasHorse; /** hasHorse is a boolean variable enables tracking of the Wizard's staff possession. */
    private boolean hasStaff; /** hasStaff is a boolean variable enables tracking of the Wizard's possesion of a horse. */
    private final double horseChance = 0.91;
    private final double staffChance = 0.13;

    public Wizard(){
        super(); //Upon a call of the Wizard constructor the Wizard inherits all of the fields of Actor + all Below.

        //The below operations use Math.Random to generate a boolean value representing the, this value is determined by the result
        // of a random number(0-1)'s probability being greater than the value of the
        boolean hasHorse = (Math.Random() < horseChance); //There is a 91% probability that the Wizard will have a staff
        boolean hasStaff = (Math.Random() < staffChance);//There is a 13% probability that the Wizard will have a horse
    }

    @Override //This method overrides Java's inherited Object.toString method.
    //toString, used either directly or in the absence of a toString call for the object.
    public String toString(){
        return String.format(super.toString() + "Has Horse:%4b \t Has Staff:%4.1b \t", this.hasHorse, this.hasStaff);
    }
    
    public void inputAllFields(){
        super.inputAllFields();
        setHasHorse(InputGUI.getBooleanGUI(String.format("Is %s riding a horse?", super.getName())));
        setHasStaff(InputGUI.getBooleanGUI(String.format("Does %s possess a staff?")));
    }

    public boolean getHasHorse() {
        return hasHorse;
    }

    public boolean getHasStaff() {
        return hasStaff;
    }

    public void setHasHorse(boolean hasHorse) {
        this.hasHorse = hasHorse;
    }

    public void setHasStaff(boolean hasStaff) {
        this.hasStaff = hasStaff;
    }

}