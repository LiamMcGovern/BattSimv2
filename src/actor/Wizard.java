package actor;

/**
 * Created by Lenny on 2/15/14.
 */
public class Wizard extends Actor{
    boolean hasHorse; /** hasHorse is a boolean variable enables tracking of the Wizard's staff possession. */
    boolean hasStaff; /** hasStaff is a boolean variable enables tracking of the Wizard's possesion of a horse. */

    public Wizard(){
        super(); //Upon a call of the Wizard constructor the Wizard inherits all of the fields of Actor + all Below.
        boolean hasHorse = (Math.Random() < 0.91); //There is a 91% probability that the Wizard will have a staff
        boolean hasStaff = (Math.Random() < 0.13);//There is a 13% probability that the Wizard will have a horse
    }

    @Override //This method overrides Java's inherited Object.toString method.
    //toString, used either directly or in the absence of a toString call for the object.
    public String toString(){
        return String.format(super.toString() + "Has Horse:%4b \t Has Staff:%4.1b \t", this.hasHorse, this.hasStaff);
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
