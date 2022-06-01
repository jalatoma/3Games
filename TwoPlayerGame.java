/*
 * TwoPlayerGame
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Jacynda Alatoma (alato006)
 */

public abstract class TwoPlayerGame
{
    // protect and static fields of the class
    static String name = "Two Player Game";
    protected int currentPlayer = 1;
    protected int winningPlayer = 0;

    /**
     * This helps access the static and protected elements in the games
     */
    public TwoPlayerGame(){}

    /**
     * This is the function that calls the instructions for the game
     */
    public abstract String getInstructions();

    /**
     * Checks to see if game is won
     */
    public abstract boolean isGameWon();

    /**
     * Checks to see if game is tied
     */
    public abstract boolean isGameTied();

    /**
     * Checks the game's current state and prints it
     */
    public abstract String getCurrentGameState();

    /**
     * Gets the prompt for the player that is playing at the turn
     */
    public abstract String getCurrentPlayerPrompt();

    /**
     * Gets the input from the user from it's prompt
     * @param input
     */
    public abstract void processCurrentPlayerInput(String input);

    /**
     * Retrieves the wining player from the game
     * @return winningPlayer
     */
    public int getWinningPlayer()
    {
        return winningPlayer;
    }
}
