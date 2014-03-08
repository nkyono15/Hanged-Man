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

public class Dictionary
{
  ArrayList<String> wordBank = new ArrayList<String>();
  private int marker = 0;
  private String guessedLetter = "";
  private int wordLength = 0;
  private String word;
  ArrayList<ArrayList<String>> families = new ArrayList<ArrayList<String>>();
  private String displayed = "";
  private int lives = 10;
  
  
  public int getLives()
  {
    return lives;
  }
  
  public void selectWord()
  {
    word = wordBank.get((int)(Math.random()*wordBank.size()));
    //System.out.println("selectWord: " + word);
  }
  
  public String getWord()
  {
    //System.out.println("getWord: " + word);
    return word;
  }
  
  public void setGuess(String guess)
  {
    guessedLetter = guess;
  }
  
  public void setWordLength(int wordL)
  {
    wordLength = wordL;
  }
  
  public void setDisplayed(String display)
  {
    displayed = display;
  }
  
  //method that takes the file and puts each line into an array
  public void makeDictionary() throws FileNotFoundException
  {
    File dictionary = new File("/Users/nkyono15/Desktop/AP Comp Sci/Hanged-Man/Dictionary.txt");
    Scanner scanLine = new Scanner(dictionary);
    while (scanLine.hasNext())
    {
      wordBank.add(scanLine.nextLine());
    }
  }
  
  
  //simple method that returns the the array with words
  public ArrayList getWordBank()
  {
    return wordBank;
  }
  
  
  
  //checks to see which words are the right length 
  public void rightLengthArray()
  {  
    for (int i = wordBank.size(); i > 0 ; i--)
    {
      if (wordBank.get(i-1).length() != wordLength)
      {
        wordBank.remove(i-1);
      }
    }
  }
  
  public void split()
  {
    boolean with = false;
    if ((int)(Math.random()*2) == 0)
    {
      with = true;
    }
    boolean has = false;
    
    ArrayList <String> clone = new ArrayList<String>();
    clone.addAll(wordBank); 
    
    for (int i = clone.size()-1; i>-1; i--)
    {
      for (int j = 0; j < wordLength; j++)
      {
        if (clone.get(i).substring(j,j+1).equals(guessedLetter))
          has = true;
      }
      if ((has == true && with == false) || (has == false && with == true))
      {
        clone.remove(i);
      }
      has = false;
    }
    
    if (clone.size() == 0)
      with = !with;
    
    for (int i = wordBank.size()-1; i>-1; i--)
    {
      for (int j = 0; j < wordLength; j++)
      {
        if (wordBank.get(i).substring(j,j+1).equals(guessedLetter))
          has = true;
      }
      if ((has == true && with == false) || (has == false && with == true))
      {
        wordBank.remove(i);
      }
      has = false;
    }
    
    if (with == false)
    {
      lives--;
    }
  }
  
  
  public void sortAmount()
  {
    int num = 0;
    int[] letterAmount =new int[6];
    ArrayList[] families = new ArrayList[6];
    for(int i=0;i<5;i++)
    {
      families[i]= new ArrayList<String>();
      letterAmount[i] = i;
    } 
    
    for(int i=0;i<wordBank.size();i++)
    {
      num = howMany(wordBank.get(i), guessedLetter);
      for (int j=0; j<5;j++)
      {
        if(num == j)
        {
          families[j].add(wordBank.get(i));
        }
      }
    }
    /*for(int i=0;i<5;i++)
    {
      System.out.println("Family " + i + " : " + families[i].size());
    }*/
    
    int which = ((int)(Math.random()*5));
    //System.out.println("which: " + which);
    int size = families[which].size();
    
    if (size > 5)
    {
      for(int i = wordBank.size(); i>0; i--)
      {
        wordBank.remove(i-1);
      }
      wordBank.addAll(families[which]);
      //System.out.println("random wordBank: " + wordBank.size());
    }
  }
  
  
  public void correctPlacement()
  {
    for (int i = wordBank.size()-1; i>0; i--)
    {
      for (int j = 0; j < wordLength; j++)
      {
        if (displayed.substring(j,j+1).equals("-"))
        {
          //System.out.println(wordBank.get(i));
          //System.out.print("-");
        }
        else if ((displayed.substring(j,j+1).equals(wordBank.get(i).substring(j,j+1))))
        {
          //System.out.println(displayed.substring(j,j+1) + wordBank.get(i).substring(j,j+1));
          //System.out.println(wordBank.get(i));
          //System.out.print("equaled");
        }
        else
        {
          //System.out.print("else");
          wordBank.remove(i);
          j = wordLength;
        }
        
        
      }
      
    }
  }
  
  
  
  public void sortFamilies()
  {
    int[] places = new int [howMany(word, guessedLetter)];
    int marker = 0;       
    for (int i = -1; (i = word.indexOf(guessedLetter, i + 1)) != -1; )   //uses index of to find where letter is and then keeps going until it finds the places because it would return -1 if no occurance 
    {
      places[marker] = word.indexOf(guessedLetter, i+1);
      marker ++;
    }  
    /*for(int i=0;i<wordBank.size();i++)
    {
      
    }
    wordBank.remove(0);*/ 
    
    
  }
  
  
  public int howMany(String word, String letter)
  {
    int numberLetter = 0;
    for (int i = -1; (i = word.indexOf(letter, i + 1)) != -1; )   //uses index of to find where letter is and then keeps going until it finds the places because it would return -1 if no occurance 
    {
      numberLetter ++;
    }  
    return numberLetter;
  }

  public boolean hasWon()
  {
    //System.out.println(displayed);
    if (displayed.equals(word))
    {
      return true;
    }
    return false;
  }
}

