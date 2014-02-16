package test;

import actor.Actor;
import util.Input;

/**
 * Test program is designed to catch incorrect input along with demonstrate proper programming practices.
 *
 * @author Liam McGovern [Input and SingletonRandom Classes are used with permission from Rex Woolard]
 *         Project:  BattleField Simulator
 *         Version: Assignment 1, Object Oriented Programming.
 *         Lab Proffessor: David Houtman
 */
public class ActorTest {
    public static void main(String[] args) {
        Actor[] setOfActors;
        inot quantityOfActors; //int used to count quantityOfActors to be created.
                        quantityOfActors = Input.instance.getInt("How many Actors should be made [Must be > 0]?"); //capture int input.
                        //The following is to ensure that the int input is valid..... and to instantiate the setOfActors.
                        while (true) {
                            try {
                                //quantityOfActors = Input.instance.getInt("How many Actors should be made?");
                                setOfActors = new Actor[quantityOfActors];//setOfActors instantiated, with length matching earlier int.

                                //Print all Actor attributes and name
                                System.out.println("Listing unmodified Actor attributes: ");
                                for (int i = 0; i < quantityOfActors; i++) {
                                    setOfActors[i] = new Actor();
                                    System.out.println(setOfActors[i]);
                                }

                                //Does the user want to modify a Actor's attributes?
                                String yesNo = Input.instance.getString("Would you like to modify an Actor's attributes? [Yes/no]");
                                //The following code is used to validate that option choosen by the user
                                //If the user does not choose yes or no then the program will repeat until the user chooses one of the two.
                                while (true) { //This is just to verify proper input choice [yes/no]
                                    if (yesNo.equals("Yes") || yesNo.equals("yes")) {
                                        int index = Input.instance.getInt("Which actor would you like to modify");//Which actor to modify?
                                        setOfActors[index].inputAllFields();
                                        System.out.println("Listing modified Actor attributes: ");
                                        //Print all Actor attributes and name
                                        for (int i = 0; i < quantityOfActors; i++) {
                                            System.out.println(setOfActors[i]);
                                        }
                                        break; //If the user chooses yes, then they are prompted to input all fields.
                                    } else if (yesNo.equals("No") || yesNo.equals("no")) {
                                        break;//If the user chooses no then the program finishes without errr.
                    } else {
                        //If the user fails to choose from the given options then they are prompted to re-enter.
                        yesNo = Input.instance.getString("Invalid input choice please try again! [Yes/no]");
                    }
                }

                //This is for you David, since you wanted to see that the set methods would function without user input.
                //Below is code that demonstrates exactly that.
                System.out.println("Displaying custom name Change");
                setOfActors[0].setName("DHoutman");
                setOfActors[0].setHealth(-1);
                setOfActors[0].setSpeed(101);
                setOfActors[0].setStrength(159694948);


                //Proof of above changes.
                for (int i = 0; i < quantityOfActors; i++) { //Print all Actor attributes and name
                    System.out.println(setOfActors[i]);
                }

                break; //Original while loop ends, program is done.


            } catch (Exception exc) {                 //Catch block for catching any wonky user input.
                if (exc instanceof NegativeArraySizeException) {
                    quantityOfActors = Input.instance.getInt("Please enter a positive number"); //Catch negative input.
                }
                if (exc instanceof ArrayIndexOutOfBoundsException) {//Catch user attempting to create 0 Actors.
                    quantityOfActors = Input.instance.getInt("Please create a quantity of actors greater than 0");
                }
            }
        }
    }
}