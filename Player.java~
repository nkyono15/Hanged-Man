/* Hanged Man
 * By Nicky Kyono
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
  Scanner input = new Scanner(System.in);
  Dictionary D = new Dictionary();
  
  private String playerGuess = null;    //player's guess
  private String guessed = "";    //letters that have been guessed
  private int wLength = 0;    //word length
  private String word = "";    //the word
  private String displayed = "";    //what's displayed
  
  
  //gets the word length
  public void wordLength()
  {
    System.out.println("Valid lengths are: 2-24 and 28"); //tells valid lengths
    System.out.println("Please enter a word length: ");   
    wLength = input.nextInt(); 
    if (wLength < 2 || wLength == 26 || wLength == 27 || wLength == 25 || wLength > 28)   //keeps user from guessing invalid length
    {
      System.out.println("invalid length");
      System.out.println("try again ");
      wordLength(); 
    }
  }
  
  //allows other classes to get word length
  public int getWordLength()
  { 
    return wLength;
  }
  
  //allows other classes to get the guessed letter
  public String getGuess()
  {
    return playerGuess;
  }
  
  //allows other classes to get all the previous guesses
  public String getAllGuesses()
  {
    return guessed;
  }
  
  //gets the word
  public void getTheWord(String w)
  {
    word = w; 
  }
  
  //allows other classes to get what's displayed
  public String getDisplayed()
  {
    return displayed;
  }
  
  //ask for guess and then calls for the checker
  public void guess()
  {
    System.out.println("Next guess: ");
    playerGuess = input.next();
    guessCheck(playerGuess);
  }
  
  
  //checks whether or not guess is legal
  public void guessCheck(String primGuess)
  {
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    boolean letter = false;
    
    //makes sure the guess is actually in the alphabet
    for (int i = 0; i < alpha.length(); i++)
    {
      if ((primGuess.equals(alpha.substring(i,i+1))) == true)
      {
        letter = true;
      }
    }
    
    //if the not a letter calls guess and sets primGuess to "" so that only keeps legal guesses
    if (letter == false)
    {
      System.out.println("Invaild guess");
      System.out.println("Please try again.");
      primGuess = "";
      guess();
    }
    
    
    if (primGuess.length() == 1)   //if one letter makes sure the letter hasn't been guessed already
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
    
    guessed = guessed + primGuess;   //adds the legal guess to the guessed letters
  }
  
  //sets up the display 
  public void display()
  {
    for (int i = 0; i<wLength; i++)    //goes for as long as the word length
    {
      if (guessed.length() > 0)  //if there has been a guess
      {
        for (int j = 0; j<guessed.length(); j++)   //go through the guessed string
        {
          if (word.substring(i,i+1).equals(guessed.substring(j,j+1)))   //if the letter in the word equals the letter in the guessed sting then display it
          {
            displayed = displayed.substring(0,i) + guessed.substring(j,j+1) + displayed.substring(i+1,displayed.length());
          }
        }
      }
      else
      {
        displayed = displayed + "-";  //if there's been no guesses display all -
      }
    }
  }
}