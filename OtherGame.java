/*
 * OtherGame
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Jacynda Alatoma (alato006)
 */

import java.util.Scanner;

public class OtherGame extends TwoPlayerGame{

    // set static name of the game
    public static String name = "Other Game";

    // set the bool for how many rounds played and initialize other variables to use later
    boolean round = false;
    String player1 = "none";
    String player2 = "none";
    int count = 0;
    int player1win = 0;
    int player2win = 0;

    /**
     * This method just returns the instructions to the game
     * @return instructions
     */
    @Override
    public String getInstructions() {
        return ("""
                This is a rock-paper-scissors game. PLayer 1 will first be asked to play 
                either rock, paper,
                or scissors. Player 2 (pretending/assuming that they can't see what 
                player 1 played) will then also 
                enter either rock, paper, or scissors (case-sensitive, lower case inputs 
                only). If an invalid input is 
                entered, it will re-ask you to enter an input. Then, after 3 games have been 
                played it will tell you 
                how many games each one of you have won and print the final winner (if there 
                is any) or if it ended in 
                a tie.""");
    }

    /**
     * Checks to see who won best out of 3 games and returns true or false if there is a winner
     * @return bool for game one
     */
    @Override
    public boolean isGameWon() {
        // checks for winner only if three games have been completed and updates winningPlayer
        if (count == 3){
            if (player1win > player2win){
                winningPlayer = 1;
                return true;
            } else if (player2win > player1win){
                winningPlayer = 2;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * checks for a tie after 3 games have been played
     * @return bool for tie
     */
    @Override
    public boolean isGameTied() {
        // only checks if three games have been played and returns bool
        if (count == 3){
            if (player1win == player2win){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * tells user what each player is playing and updates a win count for if someone has won a game
     * @return nothing, this is mostly to print statements
     */
    @Override
    public String getCurrentGameState() {
        // checks to see if a round has been completed and if less than 3 rounds has been played
        if ((round) && (count < 4)) {
            // tells users what they are playing against each other
            System.out.println("Player 1 you're playing " + player1 + ", Player 2 you're playing " + player2 +".\n");
            // updates win counts for each player
            if ((player1.equals("rock")) && (player2.equals("scissors"))) {
                player1win += 1;
            } else if ((player1.equals("scissors")) && (player2.equals("paper"))) {
                player1win += 1;
            } else if ((player1.equals("paper")) && (player2.equals("rock"))) {
                player1win += 1;
            } else if ((player1.equals("scissors")) && (player2.equals("rock"))) {
                player2win += 1;
            } else if ((player1.equals("rock")) && (player2.equals("paper"))) {
                player2win += 1;
            } else if ((player1.equals("paper")) && (player2.equals("scissors"))) {
                player2win += 1;
            }
            // if all three rounds have been played it print this statement to show how mnay games each user has won
            if (count == 3) {
                round = false;
                return("Player 1 you've won " + player1win + " games, Player 2 you've won " + player2win +
                        " games.\n");
            // returns empty stuff since nothing really needs to be returned if above isn't satisfied
            } else {
                return ("");
            }
        }
        return ("");
    }

    /**
     * checks for which current player is playing, prints the prompt for the current player
     * @return prompt
     */
    @Override
    public String getCurrentPlayerPrompt() {
        if ((currentPlayer == 1)){
            // changes the round to false because needs to wait for player 2 to answer until they compare
            round = false;
            // printing what round they're in
            System.out.println("Round " + (count + 1));
            return("Player 1, rock, paper, or scissors:");
        } else if ((currentPlayer == 2)){
            count += 1;
            round = true;
            return("Player 2, rock, paper, or scissors:");
        }
        // if none statements above fits, return a space
        else {
            return("");
        }
    }

    /**
     * takes in a string input of the user's answer, if it's invalid it re-prompts the user. Then it stores the
     * user's input into it's own field to use in above methods, updates current player
     * @param input
     */
    @Override
    public void processCurrentPlayerInput(String input) {
        // if input is invalid, ask the user to input a new value
        if (!input.equals("rock") && !input.equals("paper") && !input.equals("scissors")) {
            System.out.println("Please enter a valid input.");
            if (currentPlayer == 1) {
                System.out.println("Player 1, rock, paper, or scissors:");
                // set new scanner to read the new inputs
                Scanner scanner = new Scanner(System.in);
                String user = scanner.nextLine();
                player1 = user;
                currentPlayer = 2;
            } else {
                System.out.println("Player 2, rock, paper, or scissors:");
                Scanner scanner = new Scanner(System.in);
                String user = scanner.nextLine();
                player2 = user;
                currentPlayer = 1;
            }
        // store the value and switch the current player
        } else if(currentPlayer == 1){
            player1 = input;
            currentPlayer = 2;
        } else {
            player2 = input;
            currentPlayer = 1;
        }
    }
}
