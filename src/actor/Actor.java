package actor;// N.B.  Use of default package at this point in
                    // the program would indicate a lack of knowledge on the part of the student!
import util.Input;
import util.SingletonRandom;

import java.lang.String;


public abstract class Actor {
    /**
     * A reference to object Actor, has the following attributes
     * A name with it's coinciding serial number, incremented at each call to the constructor.
     * Health, Speed, and Strength.
     * Health and Speed are represented by a double value between 0 and 100, this is based on the fact that a percentage
     * is a logical way of measuring Health, Speed, and Strength.
     * <p/>
     * @author Liam McGovern [Input and SingletonRandom aside]
     * Project:  BattleField Simulator
     * Version: Assignment 1, Object Oriented Programming.
     * Lab Proffessor: David Houtman
     */

    //Defining the Maximum and Minimum values for each attribute
    //It was decided that 1-100 is valid since a percentage style representation is very versatile.
    public final static double MAX_HEALTH = 100.0;
    public final static double MIN_HEALTH = 1.0;

    public final static double MAX_SPEED = 100.0;
    public final static double MIN_SPEED = 1.0;

    public final static double MAX_STRENGTH = 100.0;
    public final static double MIN_STRENGTH = 1.0;

    //actorSerialNumber a class variable
    //used to assign each actor a unique number, static since it should not be unique to each actor.
    public static int actorSerialNumber = 0; //Starts with 0, increased every time it's used.

    //Actor instance variables
    private String name = "Actor"; //A string object initialized with the value of 'Actor'
    private int actorId; //A int value that represents the value of actorSerialNumber upon instantiation.
    private double strength; //Actor Speed....
    private double speed; //Actor Strength....
    private double health; //Actor Health...

    // Actor Constructor
    Actor() {
        actorSerialNumber++;//Increased upon each instantiation to correlate with the quantity of Actors created.
        actorId = actorSerialNumber; //Make id = value of actorSerialNumber
        name = String.format("%s%d", name, actorId); //Combining name with id
        //Actor instance variables are automagically instantiated with random values between the defined limits.

        //-----------Attributes-------------
        //Generate random numbers for each attribute field.
        //SingletonRandom is Prof. Woolard's random number generator.
        strength = SingletonRandom.instance.getNormalDistribution(MIN_STRENGTH, MAX_STRENGTH, 3);
        speed = SingletonRandom.instance.getNormalDistribution(MIN_SPEED, MAX_SPEED, 3);
        health = SingletonRandom.instance.getNormalDistribution(MIN_HEALTH, MAX_HEALTH, 3);
        //-----------Attributes-------------
    }

    public void inputAllFields(){
        //Utilizes the set methods to pass input to the coinciding variables.
        //Each value is checked by the corresponding set methods.
        System.out.println("You will now be asked to input the various fields of the chosen Actor");
        setName(Input.instance.getString((String.format("Input %s's Name", this.name)))); //change the name
        //Change the attributes
        setHealth(Input.instance.getDouble((String.format("Input %s's Health [This must be between %4.1f and %4.1f]", this.name, MAX_HEALTH, MIN_HEALTH))));
        setSpeed(Input.instance.getDouble((String.format("Input %s's Speed [This must be between %4.1f and %4.1f]", this.name, MAX_SPEED, MIN_SPEED))));
        setStrength(Input.instance.getDouble((String.format("Input %s's Strength [This must be between %4.1f and %4.1f]", this.name, MAX_STRENGTH, MIN_STRENGTH))));
        //This uses Prof. Woolard's Input parsing class to capture input.
    }

    @Override //This method overrides Java's inherited Object.toString method.
    //toString, used either directly or in the absence of a toString call for the object.
    public String toString(){
        return String.format("Name: %-12s Health:%4.1f \t Speed:%4.1f \t Strength:%4.1f",
                this.name, this.health, this.speed, this.strength ); //formatting for presentation.
    }

    //----------get methods
    //Standard getMethods, return the value of the calling objects fields.
    public String getName() {
        return this.name;
    }

    public double getHealth() { //getHealth returns the respective value of health to the object it's called by.
        return this.health;
    }

    public double getStrength(){//getStrength returns the respective value of health to the object it's called by.
        return this.strength;
    }

    public double getSpeed() {//getSpeed returns the respective value of health to the object it's called by.
        return this.speed;
    }
    //----------get methods

    //----------set methods
    public void setName(String name) {
        this.name = String.format("%s%d", name, actorId); //Set name and format it with the proper id number.
    }

    //-----Attribute set methods----------

    //Each double Attribute is checked against the corresponding predefined limit
    //If it exceeds either limit the value is set to the nearest limit and the user is notified.
    //Otherwise the selected field is set to the specified value.

    public void setSpeed(double speed) {
        //If user input exceeds limit, set it to nearest limit
        if (speed > MAX_SPEED){
            System.out.printf("The entered Speed is greater than specified limits," +
                    " setting the value to defined max %.1f instead %n", MAX_SPEED);
            this.speed = MAX_SPEED;
        } else if (speed < MIN_SPEED){
            System.out.printf("The entered Speed is lower than specified limits," +
                    " setting the value to defined min %.1f instead %n", MIN_SPEED);
            this.speed = MIN_SPEED;
        } else {
            this.speed = speed; //If user input is valid set Attribute to that value.
        }
    }

    public void setHealth(double health) {
        //If user input exceeds limit, set it to nearest limit
        if (health > MAX_HEALTH){
            System.out.printf("The entered Health value is greater than specified limits," +
                    " setting the value to defined max %.1f instead %n", MAX_HEALTH);
            this.health = MAX_HEALTH;
        } else if (health < MIN_HEALTH){
            System.out.printf("The entered Health value is lower than specified limits," +
                    " setting the value to defined min %.1f instead %n", MIN_HEALTH);
            this.health = MIN_HEALTH;
        } else {
            this.health = health;//If user input is valid set Attribute to that value.
        }
    }

    public void setStrength(double strength){
        //If user input exceeds limit, set it to nearest limit
        if (strength > MAX_STRENGTH){
            System.out.printf("The entered Strength is greater than specified limits," +
                    " setting the value to defined max %.1f instead %n", MAX_STRENGTH);
            this.strength = MAX_STRENGTH;
        } else if (strength < MIN_STRENGTH){
            System.out.printf("The entered Strength is lower than specified limits," +
                    " setting the value to defined min %.1f instead %n", MIN_STRENGTH);
            this.strength = MIN_STRENGTH;
        } else {
            this.strength = strength;//If user input is valid set Attribute to that value.
        }
    }
    //-----Attribute set methods----------
}
