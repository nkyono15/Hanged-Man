/* Hanged Man
 * By Nicky Kyono
 */

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary
{
  ArrayList<String> wordBank = new ArrayList<String>();
  int marker = 0;
  File dictionary = new File("/Users/nkyono15/Desktop/AP Comp Sci/Hanged-Man");
  Scanner scanLine = new Scanner(System.in);
  
  public void makeDictionary()
  {
    String line = scanLine.nextLine();
    wordBank.add(line);
    makeRecursion(wordBank);
  }
  
  private ArrayList makeRecursion(ArrayList <String> wordBank)
  {
    String line = scanLine.nextLine();
    wordBank.add(line);
    makeRecursion(wordBank);
    return wordBank;
  }
  
  public ArrayList getWordBank()
  {
    return wordBank;
  }
  
}
