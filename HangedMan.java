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
    Dictionary D = new Dictionary();
    Player P = new Player();
    D.makeDictionary();
    P.wordLength();
    D.rightLengthArray(P.getWordLength());
    while (P.getLives() !=0)
    {
      D.selectWord();
      P.guess();
      D.setGuess(P.getGuess());
      D.sortAmount();
      
      if(D.hasWon())
      {
        System.out.println("Congratulations, you have won!");
        System.out.println("The word was " + D.getWord()+".");
      }
    }
    
    System.out.println("You lose...");
    System.out.println("Play again?");
    
    for (int i=0; i<5/*wordBank.size()*/; i++)    //print out all words in the arrayList
    {
      System.out.println(D.getWordBank().get(i));
    }
  }
  
}