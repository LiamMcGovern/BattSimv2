package actor;

import util.InputGUI;
import util.SingletonRandom;


/**
 * Created by Lenny on 2/16/14.
 */
public class Hobbit extends Actor {
    private double stealth;
    private final double MAX_STEALTH = 50.0;
    private final double MIN_STEALTH = 0.0;

    /**
     * <b>Hobbit</b> constructor calls the <i>Actor</i> constructor, then establishes a random value for the stealth
     * parameter.
     */
    public Hobbit() {
        super();
        stealth = SingletonRandom.instance.getNormalDistribution(MIN_STEALTH, MAX_STEALTH, 3.0);
    }

    /**
     * Returns a formatted string contatining all Attributes of <i>Actor</i> and <b>Hobbit</b>
     * @return Returns a <i>String</i> String representation of the <b>Hobbit</b>.
     */
    @Override //Override the Superclass's  (Actor) toString Method.
    public String toString() {
        return String.format(super.toString() + "\t Stealth:%4.1f \t", this.stealth);
    }

    /**
     * Allows user to input all values of the <b>Hobbit</b> object and its parent <i>Actor</i>
     */
    @Override //Override the Superclass's  (Actor) inputAllFields Method.
    public void inputAllFields() {
        super.inputAllFields();
        setStealth(InputGUI.getDouble((String.format("Input %s's Stealth [This must be between %4.1f and %4.1f]",
                super.getName(), MAX_STEALTH, MIN_STEALTH)), MIN_STEALTH, MAX_STEALTH));
    }

    /**
     * Returns the value of the matching Object's stealth field.
     *
     * @return Returns the Hobbit's stealth value (double).
     * @see actor.Hobbit
     */

    public double getStealth() {
        return this.stealth;
    }

    /**
     * Checks the parameter value against predifined limits, and if within sets the Hobbit's stealth field to the
     * proper value.
     *
     * @param stealth Value to be assigned to the Hobbit's stealth field.
     * @see actor.Hobbit
     */
    public void setStealth(double stealth) {
        if (stealth > MAX_STEALTH) {
            System.out.printf("The entered Stealth is greater than specified limits," +
                    " setting the value to defined max %.1f instead %n", MAX_STEALTH);
            this.stealth = MAX_STEALTH;
        } else if (stealth < MIN_STEALTH) {
            System.out.printf("The entered Stealth is lower than specified limits," +
                    " setting the value to defined min %.1f instead %n", MIN_STEALTH);
            this.stealth = MIN_STEALTH;
        } else {
            this.stealth = stealth;//If user input is valid set Attribute to that value.
        }
    }
}
