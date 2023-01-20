package sdf;

import java.io.Console;
import java.util.Random;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
    Random rand = new Random();

    Integer guessNumber = rand.nextInt(0, 100);

    System.out.println("the number is " + guessNumber);

    Integer myGuess = 0;

    Console cons = System.console();

    while(myGuess != guessNumber){
        String input = cons.readLine("Guess > ");
        myGuess = Integer.parseInt(input);
        if (myGuess > guessNumber) {

            System.out.println("lower");
            
        } else if (myGuess < guessNumber){

            System.out.println("higher");

        } else {
            System.out.println("correct!");
            System.exit(1);
        }

    }

    }
}
