package test;

import actor.Actor;
import actor.Hobbit;
import actor.Wizard;

/**
 * Test program to demonstrate that each individual actor (either a hobbit or wizard) has unique modifiable attributes
 * that can be displayed to terminal with a call to either toString, or naturally without.
 *
 * @author Liam McGovern [Input and SingletonRandom Classes are used with permission from Rex Woolard]
 *         Project:  BattleField Simulator
 *         Version: Assignment 1, Object Oriented Programming.
 *         Lab Proffessor: David Houtman
 */
public class ActorTest {
    public static void main(String[] args) {

        Actor[] setOfActors;//Create an array of references to Actor objects
        setOfActors = new Actor[10]; //Define the array of Actors length to be 10.

        Actor a1 = new Wizard();
        setOfActors[0] = a1;
        ((Hobbit)setOfActors[0]).setStealth();


        Actor[] as;
        as = new Actor[1];
        as[1] = new Hobbit();

        //Below we create and set the first 5 Actors to references to Hobbit Objects.
        for (int i = 0; i < 5; i++) {
            setOfActors[i] = Hobbit; //Actor array at position i is now a reference to a Hobbit object.
        }


        //Below we create and set the last 5 Actors to references to Wizard Objects.
        for (int i = 5; i < 10 ; i++) {
            setOfActors[i] = new Wizard();//Actor array at position i is now a reference to a Wizard object.
        }

        //Display the Actor prior to any input, allowing us to ensure that they are constructed with proper values.
        for (int i = 0; i < 10; i++) {
            System.out.println(setOfActors[i]);
        }

        //Below we demonstrate the functionality of each actors set methods. Along with demonstrating that each
        //actor has entirely unique attributes, unaffected by the modification of other Actors.

        //Demonstration of set method boundary testing
        //Set Strength proof
        (Hobbit(setOfActors[0])).setStealth(110.0); //Attempt to set Strength to a value beyond 110
        System.out.println(setOfActors[0]); //Proof.
        setOfActors[1].setStealth(1);
        setOfActors[1].setStrength(-10); //Attempt to set value below -10.
        System.out.println(setOfActors[1]); //Proof.
        //End set Strength proof.
        Actor a = new Hobbit();
        Hobbit h1 = new Hobbit();
        h1.setStealth(1);




        ((Hobbit)a).setStealth(10.0);


        //



       
    }
}