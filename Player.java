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
  //ArrayList wordBank = D.getWordBank();
  
  private String playerGuess = null;
  private String guessed = "";
  private int wLength = 0;
  private String word = "";
  private String displayed = "";
  
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
  
  public String getAllGuesses()
  {
    return guessed;
  }
  
  public void getTheWord(String w)
  {
    Dictionary D = new Dictionary();
    word = w; 
  }
  
  public String getDisplayed()
  {
    return displayed;
  }
  
  public void guess()
  {
    System.out.println("Next guess: ");
    playerGuess = input.next();
    guessCheck(playerGuess);
  }
  
  public void guessCheck(String primGuess)
  {
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    boolean letter = false;
    
    for (int i = 0; i < alpha.length(); i++)
    {
      if ((primGuess.equals(alpha.substring(i,i+1))) == true)
      {
        letter = true;
      }
    }
    
    if (letter == false)
    {
      System.out.println("Invaild guess");
      System.out.println("Please try again.");
      primGuess = "";
      guess();
    }
    
    if (primGuess.length() == 1)
    {
      for (int i=0; i<guessed.length(); i++)
      {
        if (primGuess.equalsIgnoreCase(guessed.substring(i , i+1)))
        {
          System.out.println("Invaild guess");
          System.out.println("Please try again.");
          primGuess = "";
          guess();
        }
      }
    }
    
    guessed = guessed + primGuess;
  }
  
  
  public void display()
  {
    //System.out.println("word: " + word);
    //System.out.println("guessed: " + guessed);
    //System.out.println("wLength: " + wLength);
    for (int i = 0; i<wLength; i++)
    {
      if (guessed.length() > 0)
      {
        for (int j = 0; j<guessed.length(); j++)
        {
          if (word.substring(i,i+1).equals(guessed.substring(j,j+1)))
          {
            displayed = displayed.substring(0,i) + guessed.substring(j,j+1) + displayed.substring(i+1,displayed.length());
          }
        }
      }
      else
      {
        displayed = displayed + "-";
      }
      //System.out.println(i);
    }
  }
}