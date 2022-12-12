
package ProjectFinal;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Wordle {
    
    public Wordle()
    {

    }
    private String loadPhrase()
    {
      String tempPhrase = "";
      
      int numOfLines = 0;
      tempPhrase = "how are you";
      
      try 
      {
        
        Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/APCS/ProjectFinal/Words.txt"));
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
        Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/APCS/ProjectFinal/Words.txt"));
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
    public String[] bPhrase(String i)
    {
        String Phrase = i;
       
        String[] bPhrase = Phrase.split("(?!^)");

        for(int x = 0; x < bPhrase.length; x++)
        {
            bPhrase[x] = "_";
        }
        return(bPhrase);
    }
    public String[] Guess()
    {
        Scanner sc = new Scanner(System.in);
        String tempA = loadPhrase();
        String[] answer = tempA.split("(?!^)");
        String[] bAnswer = bPhrase(tempA);
        System.out.print("\n");
        for(String y: bAnswer)
        {
            System.out.print(y);
        }
        ArrayList LettersGuessed = new ArrayList();
        boolean win = false;
        String[] guess={};

        while(win == false)
        {
            System.out.println("You have guessed, " + LettersGuessed.toString() + "\n");
            System.out.println("What letter you guessing?\n");
            String tempG = sc.nextLine();
            guess = tempG.split("(?!^)");
            if(!(guess == answer))

            {
                for(int i = 0; i < answer.length; i++)
                {
                    if(guess[i].equalsIgnoreCase((answer[i])))
                    {
                        guess[i] = "\033[32m" + guess[i] + "\033[0m";
                    }
                }
            }
            for(String y: guess)
            {
                System.out.print(y);
            }
        }
        return(guess);
    }
}


