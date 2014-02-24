/* Hanged Man
 * By Nicky Kyono
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
  Scanner input = new Scanner(System.in);
  Dictionary D = new Dictionary();
  //ArrayList wordBank = new ArrayList <String>();
  ArrayList wordBank = D.getWordBank();
  
  private String playerGuess = null;
  private String guessed = "";
  private int lives = 13;
  private int wLength = 0;
  
  public void wordLength()
  {
    System.out.println("Word length: ");
    wLength = input.nextInt(); 
    if (wLength < 2 || wLength == 26 || wLength == 27 || wLength > 28)
    {
      System.out.println("invalid length");
      System.out.println("try again: ");
      wordLength(); 
    }
  }
  
  public int getWordLength()
  { 
    return wLength;
  }
  
  public String getGuess()
  {
    return playerGuess;
  }
  
  public void guess()
  {
    System.out.println("Next guess: ");
    playerGuess = input.next();
    guessCheck(playerGuess);
  }
  
  public void guessCheck(String primGuess)
  {
    System.out.println("primGuess: " + primGuess);
    if (primGuess.length() == 1)
    {
      for (int i=0; i<guessed.length(); i++)
      {
        if (primGuess.equalsIgnoreCase(guessed.substring(i , i+1)))
        {
          System.out.println("Invaild guess");
          guess();
        }
      }
    }
    else
    {
      System.out.println("Please try again.");
      guess();
    }
    guessed = guessed + primGuess;
    System.out.println("guessed: " + guessed);
  }
  
  public void changeLives()
  {
    lives =- 1;
  }
  
  public int getLives()
  {
    return lives;
  }
}