package sdf;

import java.io.Console;
import java.io.IOException;
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
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    Random rand = new Random();

    Integer guessNumber = rand.nextInt(0, 100);

    Server server = new Server();

    server.runServer(guessNumber);

    // Integer myGuess = 0;

    // Console cons = System.console();

    // while(myGuess != guessNumber){
    //     String input = cons.readLine("Guess > ");
    //     myGuess = Integer.parseInt(input);
    //     if (myGuess > guessNumber) {

    //         System.out.println("lower");
            
    //     } else if (myGuess < guessNumber){

    //         System.out.println("higher");

    //     } else {
    //         System.out.println("correct!");
    //         System.exit(1);
    //     }

    }

    
}
