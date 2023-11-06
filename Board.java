/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

/*
 * The setup for the game.
 * Handles the displaying of the phrase, the guessing of the phrase, etc.
 */
public class Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board(){
    setLetterValue();
    solvedPhrase = "";
    phrase = loadPhrase();
  }
  /* your code here - accessor(s) */
  public String getPhrase(){
    return phrase;
  }

  public String getSolvedPhrase(){
    return solvedPhrase;
  }

  public int getCurrentLetterVal(){
    return currentLetterValue;
  }
  /* your code here - mutator(s)
   * The following methods (setPhrase, guessPhrase) implement the requirements for PLTW 2.5.5, step 4.
  */
  /* Precondition: phrase has already been declared.
   * Postcondition: phrase is set to a new value.
   * Sets the phrase being used for the game to a different one.
   * @param newPhrase the new phrase to be used
   */
  public void setPhrase(String newPhrase){
    phrase = newPhrase;
  }

  /* Precondition: phrase and solvedPhrase have already been declared.
   * Postcondition: solvedPhrase is phrase, if guessedPhrase is phrase.
   * Sets solvedPhrase to phrase if phrase is guessed correctly.
   * @param guessedPhrase the player's guess as to what the phrase is
   */
  public void guessPhrase(String guessedPhrase){
    if(guessedPhrase.equals(phrase)){
      solvedPhrase = phrase;
    }
  }

  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  public boolean guessLetter(String guess)
  {
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    
    for (int i = 0; i < phrase.length(); i++)
    {
      if (phrase.substring(i, i + 1).equals(guess))
      {
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
  } 
} 