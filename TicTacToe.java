/*
 * TicTacToe
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Jacynda Alatoma (alato006)
 */

import java.util.Scanner;

public class TicTacToe extends TwoPlayerGame{

    // This is the name static field that sets the name for the game
    public static String name = "TicTacToe";

    // creating the string array to hold the elements in the board
    String[] gameBoard = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    // setting initial count of how many turns have occurred
    int count = 0;

    /**
     * This is the override for the getInstructions method, it tells the user instructions to the game
     * @return instructions
     */
    @Override
    public String getInstructions() {
        return ("""
                The starting player places an 'x' in one of the locations on the grid.
                The second player then places a 'o' on one of the grid locations, but
                not one that was previously chosen. This continues until either all the
                grid locations have been filled, or until a player wins. A player wins
                by placing their "pieces" in three grid locations that either share
                the same row, column, or diagonal.""");
    }

    /**
     * Checks conditions to see if the user has won tic-tac-toe and returns a boolean for if they did
     * @return true or false
     */
    @Override
    public boolean isGameWon() {
        // Checking across, up and down, and diagonal winning entries
        if ((gameBoard[0].equals(gameBoard[1])) && (gameBoard[0].equals(gameBoard[2]))){
            winningPlayer = currentPlayer;
            return true;
        }else if ((gameBoard[3].equals(gameBoard[4])) && (gameBoard[4].equals(gameBoard[5]))) {
            winningPlayer = currentPlayer;
            return true;
        }else if ((gameBoard[6].equals(gameBoard[7])) && (gameBoard[7].equals(gameBoard[8]))) {
            winningPlayer = currentPlayer;
            return true;
        }else if ((gameBoard[0].equals(gameBoard[4])) && (gameBoard[4].equals(gameBoard[8]))) {
            winningPlayer = currentPlayer;
            return true;
        }else if ((gameBoard[2].equals(gameBoard[4])) && (gameBoard[4].equals(gameBoard[6]))) {
            winningPlayer = currentPlayer;
            return true;
        }else if ((gameBoard[0].equals(gameBoard[3])) && (gameBoard[3].equals(gameBoard[6]))) {
            winningPlayer = currentPlayer;
            return true;
        }else if ((gameBoard[1].equals(gameBoard[4])) && (gameBoard[4].equals(gameBoard[7]))) {
            winningPlayer = currentPlayer;
            return true;
        }else if ((gameBoard[2].equals(gameBoard[5])) && (gameBoard[5].equals(gameBoard[8]))) {
            winningPlayer = currentPlayer;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Checks to see if the game is tied by seeing if all turns have been played and nobody has won
     * @return count boolean
     */
    @Override
    public boolean isGameTied() {
        return count == 9;
    }

    /**
     * Prints the updated gameBoard for the user
     * @return gameBoard printed
     */
    @Override
    public String getCurrentGameState() {
        return (gameBoard[0] + "|" + gameBoard[1] + "|" + gameBoard[2] + "\n" + "-+-+-" + "\n" + gameBoard[3] + "|"
                + gameBoard[4] + "|" + gameBoard[5] + "\n" + "-+-+-" + "\n"+ gameBoard[6] + "|" + gameBoard[7] + "|"
                + gameBoard[8] + "\n");
    }

    /**
     * checks and sets which player is going as well as increments the count for how many turns have been played
     * then prints the correct prompt for the user
     * @return player prompt
     */
    @Override
    public String getCurrentPlayerPrompt() {
        // if game is starting then the player is player 1
        if (count == 0){
            currentPlayer = 1;
        }
        // these are to switch players when the turn changes
        else if ((count > 0) && currentPlayer == 1){
            currentPlayer = 2;
        }
        else{
            currentPlayer = 1;
        }
        // returns the correct prompt for the player playing
        if (currentPlayer == 1){
            count += 1;
            return("Player 1 (x) choose your location: ");
        }
        else{
            count += 1;
            return("Player 2 (o) choose your location: ");
        }
    }

    /**
     * makes sure location selected hasn't already been played, if it has then asks for user to re-input their
     * selection. Then updates the board with the correct user's symbol
     * @param input
     */
    @Override
    public void processCurrentPlayerInput(String input) {
        // convert string input to int
        int location = Integer.parseInt(input);
        // check if input is valid
        if(location != 1 && location != 2 && location != 3 && location != 4 && location != 5 && location != 6 && location != 7 && location != 8 && location != 9){
            System.out.println("Please enter a valid input.");
            if (currentPlayer == 1) {
                System.out.println("Player 1 (x) choose your location: ");
                // set new scanner to read the new inputs
                Scanner scanner = new Scanner(System.in);
                String user = scanner.nextLine();
                location = Integer.parseInt(user);
            } else {
                System.out.println("Player 2 (o) choose your location: ");
                Scanner scanner = new Scanner(System.in);
                String user = scanner.nextLine();
                location = Integer.parseInt(user);
            }
        }
        // checks to make sure location isn't already full, if it is, re-ask the user to pick a location
        if ((gameBoard[location - 1].equals("x")) || (gameBoard[location - 1].equals("o"))) {
            System.out.println("Please pick a spot that hasn't been played:");
            if (currentPlayer == 1) {
                System.out.println("Player 1 (x) choose your location: ");
                // set new scanner to read the new inputs
                Scanner scanner = new Scanner(System.in);
                String user = scanner.nextLine();
                location = Integer.parseInt(user);
            } else {
                System.out.println("Player 2 (o) choose your location: ");
                Scanner scanner = new Scanner(System.in);
                String user = scanner.nextLine();
                location = Integer.parseInt(user);
            }
        }
        // set the location given by the user to their assigned symbol
        if(currentPlayer == 1){
            gameBoard[location - 1] = "x";
        } else {
            gameBoard[location - 1] = "o";
        }
    }
}
