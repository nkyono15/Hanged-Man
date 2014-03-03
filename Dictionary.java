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
  private String playerSees = "";
  ArrayList<ArrayList<String>> families = new ArrayList<ArrayList<String>>();
  private boolean changeLives = false;
  
  public void selectWord()
  {
    word = wordBank.get((int)(Math.random()*wordBank.size()));
    System.out.println("selectWord: " + word);
  }
  
  public String getWord()
  {
    System.out.println("getWord: " + word);
    return word;
  }
  
  public void setGuess(String guess)
  {
    guessedLetter = guess;
  }
  
  public void getWordLength()
  {
    Player P = new Player();
    wordLength = P.getWordLength();
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
  
  public boolean getChangeLives()
  {
    return changeLives;
  }
  
  
  //checks to see which words are the right length 
  public void rightLengthArray(int length)
  {  
    for (int i = wordBank.size(); i > 0 ; i--)
    {
      if (wordBank.get(i-1).length() != length)
      {
        wordBank.remove(i-1);
      }
    }
  }
  
  public void split()
  {
    boolean withGreater = true;
    int with = 0;
    int without = 0;
    for (int i = 0; i<wordBank.size(); i++)
    {
      for (int j = 0; j < wordLength; j++)
      {
        if(wordBank.get(i).substring(j,j+1).equals(guessedLetter))
          with++;
      }
      without ++;
    }
    if (with > without)
    {
      withGreater = true;
      System.out.println("with");
    }
    else
    {
      withGreater = false;
      System.out.println("without");
    }
    
    for (int i = wordBank.size(); i>0; i++)
    {
      for (int j = 0; j < wordLength; j++)
      {
        if (withGreater)
        {
          if(wordBank.get(i).substring(j,j+1).equals(guessedLetter))
            j = wordLength;
          else
            wordBank.remove(i-1);
        }
        else
        {
          if(wordBank.get(i).substring(j,j+1).equals(guessedLetter))
            wordBank.remove(i-1);
          j = wordLength;
        }
      }
    }
  }
  
  
  public void sortAmount()
  {
    Player P = new Player();
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
    
    
    
    /*for(int i=0; i<7; i++)
     {
     if(families[i].size() == 0)
     {
     P.changeLives();
     }
     }*/
    
    
    ArrayList<String> returnList= new ArrayList<String> (families[0]);
    
    for (int i = 0;i<5; i++)
    {
      //System.out.println("returnList: " + returnList.size());
      //System.out.println("families: " + families[i].size());
      if (returnList.size() < families[i].size())
      {
        for(int j = returnList.size(); j>0; j--)
        {
          returnList.remove(j-1);
        }
        returnList.addAll(families[i]);
      }
    }
    for(int i = wordBank.size(); i>0; i--)
    {
      wordBank.remove(i-1);
    }
    wordBank.addAll(returnList);
    //System.out.println("returnList: " + returnList.size());
    //System.out.println("families: " + families[0].size());
    
    //System.out.println("wordBank: " + wordBank.size());
    
    if (returnList.equals(families[0]))
    {
      System.out.println("Nope, try again");
      changeLives = true;
    }
    else
    {
      sortFamilies();
      changeLives = false;
    }
    
    /*while (returnList.size() == 0)
     {
     returnList.equals(families[(int)(Math.random()*7)]);
     }*/
    
    //return  families[(Math.random()*7)];
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
    for(int i=0;i<wordBank.size();i++)
    {
      
    }
    wordBank.remove(0);
    
    
  }
  
  /*public void selectFam()
   {
   wordBank.equals(families.get(0));
   for (int i = 0;i<families.size(); i++)
   {
   if (wordBank.size() < families.get(i).size())
   {
   wordBank.equals(families.get(i));
   }
   }
   }*/
  
  
  public int howMany(String word, String letter)
  {
    int numberLetter = 0;
    for (int i = -1; (i = word.indexOf(letter, i + 1)) != -1; )   //uses index of to find where letter is and then keeps going until it finds the places because it would return -1 if no occurance 
    {
      numberLetter ++;
    }  
    return numberLetter;
  }
  
  /*public int seperate (String word)
   {
   String nums = "0123456";
   for (i = 0; i < word.length(); i++)
   {
   if (word.substring(word.length()-1, word.length()) == nums.substring(nums[i], nums[i+1]))
   {
   return i;
   }
   }
   }   Failed Idea */
  
  public boolean hasWon()
  {
    if (playerSees.equals(word))
    {
      return true;
    }
    return false;
  }
  
  /*public void forWith()
  {
    for (int i = wordBank.size(); i>0; i++)
    {
      for (int j = 0; j < wordLength; j++)
      {
        if(wordBank.get(i).substring(j,j+1).equals(guessedLetter))
          j = wordLength;
        else
          wordBank.remove(i-1);
      }
      
    }
  }
  
  public void forWithout()
  {
    for (int i = wordBank.size(); i>0; i++)
    {
      for (int j = 0; j < wordLength; j++)
      {
        if(wordBank.get(i).substring(j,j+1).equals(guessedLetter))
          wordBank.remove(i-1);
        j = wordLength;
      }
    }
  }*/
}

