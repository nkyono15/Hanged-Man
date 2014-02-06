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
  int marker = 0;
  
  public void makeDictionary() throws FileNotFoundException
  {
    File dictionary = new File("/Users/nkyono15/Desktop/AP Comp Sci/Hanged-Man/Dictionary.txt");
    Scanner scanLine = new Scanner(dictionary);
    while (scanLine.hasNext())
    {
      wordBank.add(scanLine.nextLine());
    }
  }
  
  public ArrayList getWordBank()
  {
    return wordBank;
  }
  
  public String getWord()
  {
    return (wordBank.get((int)(Math.random()*wordBank.size())));
  }
    
}
