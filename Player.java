/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

/* The class for the games' players.
 * Handles the characteristics of the players (name and score).
 */
public class Player
{
  /* your code here - attributes */
  private int points;
  private String name;
  /* your code here - constructor(s) */ 
  public Player(){
    System.out.println("Enter player name:");
    Scanner s = new Scanner(System.in);
    name = s.nextLine();
    System.out.println("Hello, " + name + ". Welcome to the game!");
    points = 0;
  }

  public Player(String inputName){
    name = inputName;
    System.out.println("Hello, " + name + ". Welcome to the game!");
    points = 0;
  }
  /* your code here - accessor(s) */
  /* Returns the number of points obtained by this player.
   * @return the number of points the player has obtained
   */
  public int getPoints(){
    return points;
  }

  /* Returns the name of this player.
   * @return the player's name
   */
  public String getName(){
    return name;
  }
  /* your code here - mutator(s)
   * The following methods (updatePoints, setName) implement the requirements for PLTW 2.5.5, step 4.
  */
  /* Precondition: points has been declared.
   * Postcondition: points is set to a value.
   * Adds points to the player's current amount of points.
   * @param newPoints the number of points the player has gained
   */
  public void updatePoints(int newPoints){
    points += newPoints;
  }
  
  /* Precondition: name has been declared.
   * Postcondition: name is set to a value.
   * Changes the player's name to a different one.
   * @param newName the player's new name
   */
  public void setName(String newName){
    name = newName;
  }
}