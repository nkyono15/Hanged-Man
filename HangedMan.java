/* Hanged Man
 * By Nicky Kyono
 * ***Note: To make this run the pathway for the dictionary may need to be changed to where it is in your computer.
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
    
    P.wordLength();    //asks for a word length
    D.setWordLength(P.getWordLength());    //sets the word length
    D.rightLengthArray();     //narrows down the dictionary to words that are the right length
    
    while (D.getLives() !=0 && hasWon == false)  //while the player still has lives and hasn't won
    {
      D.selectWord();   //selects word
      P.getTheWord(D.getWord());   //sets word
      P.display();     //sets up display
      System.out.println(P.getDisplayed());    //prints out the display
      D.setDisplayed(P.getDisplayed());     //sets the display
      P.guess();    //ask for guess
      System.out.println("guessed: " + P.getAllGuesses());   //prints out previous guesses
      D.setGuess(P.getGuess());   //sets guess
      D.split();       //splits into families of whether or not it has the gues
      D.sortAmount();   //sorts into families depending on how many instances the letter in the word comes up
      D.correctPlacement();   //cuts down the wordBank so that the possiblities match up with what's displayed
      System.out.println("Lives: " + D.getLives());  //prints out the lives
      //System.out.println("wordBank: " + D.getWordBank().size());
      P.display();     //sets up display
      D.setDisplayed(P.getDisplayed());   //shares what's displayed
      if(D.hasWon())
      {
        hasWon = true;
        System.out.println("Congratulations, you have won!");
        System.out.println("The word was " + D.getWord()+".");
      }
    }
    
    if (D.getLives() == 0)  //if someone loses
    {
    System.out.println("You lose...");
    System.out.println("Play again?");
    System.out.println("The word was " + D.getWord() + ".");
    }
  }
  
}