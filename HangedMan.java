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
    ArrayList wordBank = new ArrayList <String>();
    Dictionary D = new Dictionary();
    D.makeDictionary();
    wordBank = D.getWordBank();
    System.out.println(D.getWord());
    /*for (int i=0; i<wordBank.size(); i++)
    {
      System.out.println(wordBank.get(i));
    }*/ 
  }
}