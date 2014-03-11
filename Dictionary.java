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
  ArrayList<String> wordBank = new ArrayList<String>();     //creates arraylist that the dictionary is kept in         
  private String guessedLetter = "";    //keeps track of the letter that was guessed
  private int wordLength = 0;      //keeps the word length
  private String word;        //keeps the word the computer is thinking
  ArrayList<ArrayList<String>> families = new ArrayList<ArrayList<String>>();    //creates an arraylist of arraylist to store different word families
  private String displayed = "";        //keeps track of what the player can see
  private int lives = 10;
  
  //method so other classes can get lives
  public int getLives()
  {
    return lives;
  }
  
  //method that selects a random word from the dictionary  
  public void selectWord()
  {
    word = wordBank.get((int)(Math.random()*wordBank.size()));
  }
  
  //method so other classes can get the word
  public String getWord()
  {
    return word;
  }
  
  //method to get the guessed letter
  public void setGuess(String guess)
  {
    guessedLetter = guess;
  }
  
  //method to get the word length
  public void setWordLength(int wordL)
  {
    wordLength = wordL;
  }
  
  //method to get what's displayed 
  public void setDisplayed(String display)
  {
    displayed = display;
  }
  
  //method that takes the file and puts each line into an array
  public void makeDictionary() throws FileNotFoundException
  {
    File dictionary = new File("/Users/nkyono15/Desktop/AP Comp Sci/Hanged-Man/Dictionary.txt");
    Scanner scanLine = new Scanner(dictionary); 
    while (scanLine.hasNext())  //while theres another line in the file the wordbank keeps adding it to the next index in the array
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
    for (int i = wordBank.size(); i > 0 ; i--)  //goes through arraylist backwards so it doesnt mess up
    {
      if (wordBank.get(i-1).length() != wordLength)   //if the word length in the array doesnt match the specified length it gets removed
      {
        wordBank.remove(i-1);
      }
    }
  }
  
  //sorts into families depending on if they have the guess or not
  public void split()  
  {
    boolean with = false;     //use this boolean to decide which group to keep
    if ((int)(Math.random()*2) == 0)
    {
      with = true;   //decides the group
    }
    boolean has = false;   //keeps track of whether or not word has guess
    
    ArrayList <String> clone = new ArrayList<String>();
    clone.addAll(wordBank);   //makes a copy of arraylist
    
    for (int i = clone.size()-1; i>-1; i--)  //goes through the clone and takes out words depending on the variables
    {
      for (int j = 0; j < wordLength; j++)
      {
        if (clone.get(i).substring(j,j+1).equals(guessedLetter))
          has = true;
      }
      if ((has == true && with == false) || (has == false && with == true))   //if has is true and it doesn't want them remove and if it doesn't have it but wants it remove
      {
        clone.remove(i);
      }
      has = false;
    }
    
    if (clone.size() == 0)   //if the clone array is sized at zero switch whether or not the program wants it 
      with = !with;
    
    for (int i = wordBank.size()-1; i>-1; i--)  //does the same thing as with the clone but for real this time
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
    
    if (with == false)    //if it didn't want the guess take away a life
    {
      lives--;
    }
  }
  
  //sorts the words into different families depending on how many of the guessed letters it has
  public void sortAmount()
  {
    int num = 0;                 //number of times guesss occurs
    ArrayList[] families = new ArrayList[6];   //arraylist
    for(int i=0;i<5;i++)                      
    {
      families[i]= new ArrayList<String>();  //at each arraylist is another arraylist
    } 
    
    for(int i=0;i<wordBank.size();i++)         //goes through to figure out how many intances of each letter are in the word
    {
      num = howMany(wordBank.get(i), guessedLetter);
      for (int j=0; j<5;j++)
      {
        if(num == j)
        {
          families[j].add(wordBank.get(i));  //adds it to the index (number representing how many times it occured)
        }
      }
    }
    
    int which = ((int)(Math.random()*5));       //random number (correlates to which family computer chooses)
    int size = families[which].size();
    
    if (size > 5)           //if the family has more than 5 words in it replace the wordBank with those words
    {
      for(int i = wordBank.size(); i>0; i--)
      {
        wordBank.remove(i-1);
      }
      wordBank.addAll(families[which]);
    }
  }
  
  //Goes through the wordBank and the word/what's displayed to see if they match and if they don't take it out
  public void correctPlacement()
  {
    for (int i = wordBank.size()-1; i>0; i--)
    {
      for (int j = 0; j < wordLength; j++)
      {
        if (displayed.substring(j,j+1).equals("-"))
        {
          //if a - then ignore
        }
        else if ((displayed.substring(j,j+1).equals(wordBank.get(i).substring(j,j+1))))
        {
          //if its correct ignore
        }
        else
        {
          wordBank.remove(i);   //if wrong remove it
          j = wordLength;
        } 
      }    
    }
  }
  
  
  //goes through a word and sees how many times a specified letter is in it and returns that number
  public int howMany(String word, String letter)
  {
    int numberLetter = 0;
    for (int i = -1; (i = word.indexOf(letter, i + 1)) != -1; )   //uses index of to find where letter is and then keeps going until it finds the places because it would return -1 if no occurance 
    {
      numberLetter ++;
    }  
    return numberLetter;
  }

  //sees if the player won by comparing what's displayed with the word
  public boolean hasWon()
  {
    if (displayed.equals(word))
    {
      return true;
    }
    return false;
  }
}

