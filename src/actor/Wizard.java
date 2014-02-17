package actor;

import util.InputGUI;
import util.SingletonRandom;



/**<p>
 * A reference to object of type <i>Wizard</i>, inherits all values from the super class Actor, and along with these
 * it contains values representing the Wizard's possession of both a Horse and Staff, each being boolean values.
 * Upon calling the constructor, presence of either asset is determined by a probability statement.
 * This statement is the result of a comparisson between a random number (0-1) and a predefined constant representing
 * the probability.
 * <p/>
 * @author Liam McGovern [InputGUI and SingletonRandom are Rex Woolard's work]
 * Project:  BattleField Simulator
 * Version: Assignment 2, Object Oriented Programming.
 * Lab Proffessor: David Houtman
 */

public class Wizard extends Actor{
    private boolean hasHorse; /** hasHorse is a boolean variable for tracking of the Wizard's staff possession. */
    private boolean hasStaff; /** hasStaff is a boolean variable for tracking of the Wizard's possesion of a horse. */

    public Wizard(){
        super(); //Upon a call of the Wizard constructor the Wizard inherits all of the fields of Actor + all Below.

        //Given that these following variables are not needed beyond the scope of the constructor, it would be poor
        //programming practise to declare them as instance fields.
        final double CHANCEOFHORSE = 0.91;/**Probability of starting with a horse */
        final double CHANCEOFSTAFF = 0.13;/**Probability of starting with a horse */

        //The below operations generate a random number in order between 0.0 and 1.0, then compare that number to the
        //predefined chance value, to result in a boolean value that represent the Wizard's possession of the
        //corresponding asset.

                            //[-----------------RANDOM NUMBER[0-1]------ | Less than  \/ chance? | chance value |
        boolean hasHorse = (SingletonRandom.instance.getNormalDistribution(0.0,1.0,1) < CHANCEOFHORSE); //91% Chance.
        boolean hasStaff = (SingletonRandom.instance.getNormalDistribution(0.0, 1.0, 1) < CHANCEOFSTAFF);  //13% Chance.
    }

    @Override //Override the Superclass's  (Actor) toString Method.
    //toString, used either directly or in the absence of a toString call for the object.
    public String toString(){
        return String.format(super.toString() + "\t Has Horse:%5b \t Has Staff:%5b \t", this.hasHorse, this.hasStaff);
    }

    @Override //Override the Superclass's  (Actor) inputAllFields Method.
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