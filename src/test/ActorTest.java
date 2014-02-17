package test;

import actor.Actor;
import actor.Hobbit;
import actor.Wizard;
import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Test program to demonstrate that each individual actor (either a hobbit or wizard) has unique modifiable attributes
 * that can be displayed to terminal with a call to either toString, or naturally without.
 *
 * @author Liam McGovern [Input and SingletonRandom Classes are used with permission from Rex Woolard]
 *         Project:  BattleField Simulator
 *         Version: Assignment 2, Object Oriented Programming.
 *         Lab Proffessor: David Houtman
 */
public class ActorTest {
    public static void main(String[] args) {
        final byte amountOfActors = 20;
        byte arrayIndex = 0;

        Actor[] setOfActors;//Create an array of references to Actor objects
        setOfActors = new Actor[amountOfActors]; //Define the array of Actors length to be 10.

        // Create a Wizard, and modify it's fields
        Actor w1 = new Wizard(); //Construct a Wizard
        System.out.println("Printing contents of UNmodified actor \n"+w1); //Print UNmodified Wizard.
        w1.inputAllFields(); //Change Hobbit.
        System.out.println("Printing contents of modified actor \n"+w1); //Print changed Wizard.
        //Place this actor into the setOfActors array
        setOfActors[arrayIndex++] = w1;
        // END-Create a Wizard, and modify it's fields

        // Create a Hobbit, and modify it's fields
        Actor h1 = new Hobbit();//Construct a Hobbit
        System.out.println("Printing contents of UNmodified actor \n"+h1);//Print UNmodified Hobbit.
        h1.inputAllFields();//Change Hobbit.
        System.out.println("Printing contents of modified actor \n"+h1);//Print modified Hobbit.
        //Place this actor into the setOfActors array
        setOfActors[arrayIndex++] = h1;
        // END-Create a Hobbit, and modify it's fields

        // Create a second Wizard and Hobbit, and modify their fields, then display all actors
        Actor w2 = new Wizard(); //Construct a Wizard
        Actor h2 = new Hobbit();//Construct a Hobbit
        System.out.println("Printing contents of UNmodified actor \n"+w2+"\n"+h2); //Print UNmodified Actors.
        w2.inputAllFields(); //Change Hobbit.
        h2.inputAllFields();//Change Wizard.
        System.out.println("Printing contents of modified actor \n"+w2+"\n"+h2); //Print changed Actors.
        //Place these actors into the setOfActors array
        setOfActors[arrayIndex++] = w2;
        setOfActors[arrayIndex++] = h2;
        for (int i = 0; i < arrayIndex; i++) {
            System.out.println(setOfActors[i]);
        }
        // END-Create a Wizard, and modify it's fields

        //Test out the setStealth method
        System.out.println(h1);
        ((Hobbit)h1).setStealth(123);
        System.out.println(h1);//Proof
        ((Hobbit)h1).setStealth(-12);
        System.out.println(h1);//Proof
        //END-Test out the setStealth method
        
        //Test out modifications to Wizard boolean values, and the Wizard's set Methods
        System.out.println(w1);
        //We can efficiently test both set and get below, by combining them.
        ((Wizard)w1).setHasHorse(!((Wizard)w1).getHasHorse()); //Set's the value to the opposite of it's current value.
        System.out.println(w1); //Proof
        ((Wizard)w1).setHasStaff(!((Wizard)w1).getHasStaff()); //Set's the value to the opposite of it's current value.
        System.out.println(w1); //Proof
        //END-Test out modifications to Wizard boolean values, and the Wizard's set Methods

        /*TODO populate setactors with other actors, print them all..... satisfy the documents thing about
         virtual methods and finish test plan  */





//
//
//        //setOfActors[0] = a1;
//
//        Actor[] as;
//        as = new Actor[1];
//        as[1] = new Hobbit();
//
//        //Below we create and set the first 5 Actors to references to Hobbit Objects.
//        for (int i = 0; i < 5; i++) {
//            setOfActors[i] = Hobbit; //Actor array at position i is now a reference to a Hobbit object.
//        }
//
//
//        //Below we create and set the last 5 Actors to references to Wizard Objects.
//        for (int i = 5; i < 10 ; i++) {
//            setOfActors[i] = new Wizard();//Actor array at position i is now a reference to a Wizard object.
//        }
//
//        //Display the Actor prior to any input, allowing us to ensure that they are constructed with proper values.
//        for (int i = 0; i < 10; i++) {
//            System.out.println(setOfActors[i]);
//        }
//
//        //Below we demonstrate the functionality of each actors set methods. Along with demonstrating that each
//        //actor has entirely unique attributes, unaffected by the modification of other Actors.
//
//        //Demonstration of set method boundary testing
//        //Set Strength proof
//        (Hobbit(setOfActors[0])).setStealth(110.0); //Attempt to set Strength to a value beyond 110
//        System.out.println(setOfActors[0]); //Proof.
//        setOfActors[1].setStealth(1);
//        setOfActors[1].setStrength(-10); //Attempt to set value below -10.
//        System.out.println(setOfActors[1]); //Proof.
//        //End set Strength proof.
//        Actor a = new Hobbit();
//        Hobbit h1 = new Hobbit();
//        h1.setStealth(1);
//
//


       // ((Hobbit)a).setStealth(10.0);



       
    }
}