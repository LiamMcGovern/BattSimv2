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

    public Hobbit() {
        super();
        stealth = SingletonRandom.instance.getNormalDistribution(MIN_STEALTH, MAX_STEALTH, 3.0);
    }

    @Override //Override the Superclass's  (Actor) toString Method.
    public String toString() {
        return String.format(super.toString() + "\t Stealth:%4.1f \t", this.stealth);
    }

    public void inputAllFields() {
        super.inputAllFields();
        setStealth(InputGUI.getDouble((String.format("Input %s's Stealth [This must be between %4.1f and %4.1f]", super.getName(), MAX_STEALTH, MIN_STEALTH)), MIN_STEALTH, MAX_STEALTH));
    }

    /**
     * Returns the value of the matching Object's stealth field.
     *
     * @return Returns the Hobbit's stealth value (double).
     * @see actor.Hobbit
     */
    public void subClassMethod() {
        System.out.println("Done");
    }

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
