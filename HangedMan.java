/* Hanged Man
 * By Nicky Kyono
 */

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class HangedMan
{
  ArrayList wordBank = new ArrayList <String>();
  public static void main (String [] args)
  {
    Dictionary D = new Dictionary();
    wordBank = D.getWordBank();
    for (int i=0; i<wordBank.size(); i++)
    {
      System.out.println(wordBank.get(i));
    }
  }
}