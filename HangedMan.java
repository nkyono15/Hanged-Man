/* Hanged Man
 * By Nicky Kyono
 */

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class HangedMan
{
  
  
  public static void main (String [] args) throws FileNotFoundException
  {
    boolean hasWon = false;
    Dictionary D = new Dictionary();
    Player P = new Player();
    D.makeDictionary();
    
    System.out.println("EVIL HANGMAN");
    System.out.println("By Nicky Kyono");
    System.out.println("Have fun!");
    System.out.println();
    
    P.wordLength();
    D.setWordLength(P.getWordLength());
    D.rightLengthArray();
    
    int counter = 0;
    while (D.getLives() !=0 && hasWon == false)
    //while (counter < 3)
    {
      if(D.hasWon())
      {
        hasWon = true;
        System.out.println("Congratulations, you have won!");
        System.out.println("The word was " + D.getWord()+".");
      }
      D.selectWord();
      P.getTheWord(D.getWord());
      P.display();
      System.out.println(P.getDisplayed());
      D.setDisplayed(P.getDisplayed());
      P.guess();
      System.out.println("guessed: " + P.getAllGuesses());
      D.setGuess(P.getGuess());
      D.split();
      D.sortAmount();
      D.correctPlacement();
      System.out.println("Lives: " + D.getLives());
      //System.out.println("wordBank: " + D.getWordBank().size());
      D.setDisplayed(P.getDisplayed());
      //counter++;
    }
    
    if (D.getLives() == 0)
    {
    System.out.println("You lose...");
    System.out.println("Play again?");
    System.out.println("The word was " + D.getWord() + ".");
    }
  }
  
}