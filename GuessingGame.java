/*
 * GuessingGame
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Jacynda Alatoma (alato006)
 */

import java.util.Scanner;

public class GuessingGame extends TwoPlayerGame{

    // setting static string name to the name of the game
    public static String name = "Guessing Game";

    // initializing variables that will be used later
    int min = 1;
    int max = 100;

    // creating a secret random number between 1 and 100 inclusive
    int int_random = (int)(Math.random()*(max - min + 1) + min);

    // set boolean for if a round of both player 1 and 2 answering has passed and guessing values for player1 and player2
    boolean round = false;
    int player1 = 0;
    int player2 = 0;

    /**
     * This just returns the instructions of the game
     * @return instructions
     */
    @Override
    public String getInstructions() {
        return ("""
                When the game starts the computer will generate a random number between 1
                and 100 (including both 1 and 100). The game will prompt each player for a
                a guess. Once both players have submitted a valid guess, the game will tell
                you which player is closer to the secret number. Once a player has guessed
                the secret number, they win and the game is over. If both players correctly
                guess the secret number, the game will end in a tie.""");
    }

    /**
     * checks for if a player has guessed the random number correctly
     * @return bool for if player won or not
     */
    @Override
    public boolean isGameWon() {
        // checks for a stand alone winner (not a tie) at the end of a round
        if ((player1 == int_random) && (round) && (player2!=int_random)){
            winningPlayer = 1;
            return true;
        } else if ((player2 == int_random) && (round) && (player1!= int_random)){
            winningPlayer = 2;
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks for a tie between the two players, if they both guessed the same number
     * @return bool value for if it is a tie
     */
    @Override
    public boolean isGameTied() {
        return player1 == int_random && (player2 == int_random) && round;
    }

    /**
     * checks for which player is closer to the random integer value and returns a statement that tells the user who is
     * closer, or it returns a nothing (a space) if somebody has already guessed it right
     * @return who is closer string
     */
    @Override
    public String getCurrentGameState() {
        // checks to see if a full round has completed to check the differences
        if (round) {
            // calculating the absolute value of the guessing vs. the actual number
            int difference = Math.abs(player1 - int_random);
            int difference2 = Math.abs(player2 - int_random);
            // returns a statement for who is closer depending on the differences, as long as they haven't won
            if ((difference > difference2) && (difference != 0) && (difference2 != 0)) {
                return ("Player 2 is closer.\n");
            } else if ((difference2 == difference) && (difference != 0)) {
                return ("Player 1 and 2 are equally far away.\n");
            } else if ((difference < difference2) && (difference != 0) && (difference2 != 0)){
                return ("Player 1 is closer.\n");
            // these last two else statements return a space because if the person has won, no need to show the
            // differences/who is closer to the actual value
            } else {
                return("");
            }
        } else {
            return (" ");
        }
    }

    /**
     * Checks which player is playing and then returns the correct prompt for them to answer
     * @return prompt for the player
     */
    @Override
    public String getCurrentPlayerPrompt() {
        if ((currentPlayer == 1)){
            // changes the round to false because needs to wait for player 2 to answer until they compare
            round = false;
            return("Player 1, make your guess:");
        } else if ((currentPlayer == 2)){
            round = true;
            return("Player 2, make your guess:");
        }
        // if none above fit, just return a space
        else {
            return("");
        }
    }

    /**
     * checks for which player is playing and sets their guess value to a variable to use in later methods
     * @param input
     */
    @Override
    public void processCurrentPlayerInput(String input) {
        // check to see if the input is only a number
        if (!input.matches("\\d+")) {
            System.out.println("Please enter a valid input.");
            if (currentPlayer == 1) {
                System.out.println("Player 1, make your guess:");
                // set new scanner to read the new inputs
                Scanner scanner = new Scanner(System.in);
                String user = scanner.nextLine();
                int num = Integer.parseInt(user);
                player1 = num;
                currentPlayer = 2;
            } else {
                System.out.println("Player 2, make your guess:");
                Scanner scanner = new Scanner(System.in);
                String user = scanner.nextLine();
                int num = Integer.parseInt(user);
                player2 = num;
                currentPlayer = 1;
            }
        }
        // converts the inputs to an integer and stores them in their correct variables to use in later methods
        else if(currentPlayer == 1){
            int number = Integer.parseInt(input);
            player1 = number;
            currentPlayer = 2;
        } else {
            int number = Integer.parseInt(input);
            player2 = number;
            currentPlayer = 1;
        }
    }
}
