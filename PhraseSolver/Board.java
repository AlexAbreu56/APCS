import java.util.Scanner;
import java.io.File;
public class Board{

  //Returns a random phrase from the text document.
  private String loadPhrase()
    {
      String tempPhrase = "";
      
      int numOfLines = 0;
      tempPhrase = "how are you";
      
      try 
      {
        
        Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/APCS/PhraseSolver/phrases.txt"));
        while (sc.hasNextLine())
        {
          tempPhrase = sc.nextLine().trim();
          numOfLines++;
        }
      } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
      
      int randomInt = (int) ((Math.random() * numOfLines) + 1);
      
      try 
      {
        int count = 0;
        Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/APCS/PhraseSolver/phrases.txt"));
        while (sc.hasNextLine())
        {
          count++;
          String temp = sc.nextLine().trim();
          if (count == randomInt)
          {
            tempPhrase = temp;
          }
        }
      } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
      return tempPhrase;
    }

  public String GuessPhrase()
  {
    String Phrase = loadPhrase();
    String bPhrase = "";
    for(int i = 0; i < Phrase.length(); i++)
    {
      if(Phrase.substring(i, i+1) != " ")
      {
        bPhrase += "_";
      }
      else
      {
        bPhrase += " ";
      }
    }
    return(bPhrase);
  }
}