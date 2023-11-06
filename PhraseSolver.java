/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;

/* The primary class for the Wheel of Fortune style game.
 * Hosts the objects which comprise the game's set up, and performs all required operations with them.
 */
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;
  /* your code here - constructor(s) */ 
  public PhraseSolver(){
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  }

  // The following method (play) implements the requirements for PLTW 2.5.5, step 5.
  /* Precondition: player1, player2, game, and solved have been declared, and their associated classes exist with all their methods.
   * Postcondition: The game has finished running. Solved is set to true, and solvedPhrase is equivalent to phrase.
   * Runs the gameplay loop for the Wheel of Fortune style game.
   * Takes care of input, swapping players, checking if the game is complete, requesting guesses,
   * and dealing with the results of the guesses.
   */
  public void play()
  {
    solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    while (!solved) {
      
      /* your code here - game logic */
      // Tells the players how much of  the phrase has been guessed.
      String oldPhrase = game.getSolvedPhrase();
      System.out.println(oldPhrase);

      // Notifies the players of which player is currently heremoving.
      if(currentPlayer == 1){
        System.out.println("Current Player: " + player1.getName());
      } else {
        System.out.println("Current Player: " + player2.getName());
      }

      // Sets and gives the point value of the next guess.
      game.setLetterValue();
      System.out.println("Point Value of Next Guess: " + game.getCurrentLetterVal());

      // Takes in the player's guess (or their skipping of their turn) and processes it.
      System.out.println("Please enter a guess.");
      String guess = input.next();
      if(!guess.equals("skip")){
        if(guess.length() == 1){
          game.guessLetter(guess);
        } else {
          game.guessPhrase(guess);
        }

        // Changes the player if they got the question wrong, and updates their points if they got it right.
        if(oldPhrase.equals(game.getSolvedPhrase())){
          currentPlayer++;
          currentPlayer %= 2;
        } else {
          if(currentPlayer == 1){
            player1.updatePoints(game.getCurrentLetterVal());
          } else {
            player2.updatePoints(game.getCurrentLetterVal());
          }
        }

        /* your code here - determine how game ends */
        // Ends game if the phrase has been fully guessed.
        String solvedPhraseSpaceless = game.getSolvedPhrase().replaceAll("\\s+", "");
        String phraseSpaceless = game.getPhrase().replaceAll("\\s+","");
        if(solvedPhraseSpaceless.equals(phraseSpaceless)){
          solved = true; 
        }
      } else {
        // Changes the current player.
        currentPlayer++;
        currentPlayer %= 2;
      }
    }
    // Notifies the players of their final scores.
    System.out.println("Game ended.");
    System.out.println(player1.getName() + "'s points: " + player1.getPoints());
    System.out.println(player2.getName() + "'s points: " + player2.getPoints());
  }
}