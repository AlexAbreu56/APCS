import java.util.Scanner;
import java.io.File;
public class Board
{
  Player PlayerOne;
  Player PlayerTwo;

  public Board(Player p1, Player p2)
  {
    PlayerOne = p1;
    PlayerTwo = p2;
  }

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

  public String bPhrase(String loadPhrase)
  {
    String Phrase = loadPhrase;
    String bPhrase = "";
    for(int i = 0; i < Phrase.length(); i++)
    {
      if(Phrase.substring(i, i+1).equals(" "))
      {
        bPhrase += " ";
      }
      else
      {
        bPhrase += "_";
      }
    }
    return(bPhrase);
  }
  
  public String Guesses()
  {
    Scanner sc = new Scanner(System.in);
    String answer = loadPhrase();
    String blank = bPhrase(answer);
    System.out.println(blank);
    String gLetter = "";
    String blank2 = "";
    Boolean Player2 = false;
    Boolean Player1 = true;
    int Player1S = 0;
    int Player2S = 0;
  
    while(!(blank2.equals(answer)))
    {
      System.out.println("You have guessed, " + gLetter + "\n");
      System.out.print("What letter you guessing?\n");
      String guess = sc.nextLine();
      System.out.print("\n");
      gLetter += guess + ", ";
      blank2 = "";
      if(answer.contains(guess))
      // Is the guess in the answer staement?
      {
        if(Player1 == true)
        //If its PLayer ones turn add score to PLayer one
        {
          Player1S = PlayerOne.setScore(1);
        }
        if(Player2 == true)
        //IF its player two turn add score to player two
        {
          Player2S = PlayerTwo.setScore(1);
        }
        for(int i = 0; i < blank.length(); i++)
        //Loops through blank statement
        {
          if(answer.substring(i,i+1).contains(guess))
          // is the answer substring equal to the players guess if so it adds the guess to the blank2 string
          {
           blank2 += guess;
          }
          else if(gLetter.contains(answer.substring(i,i+1)))
          //checks if the letters in the guessed letters string are in the answer substring, it so it adds that substring to the blank2 string
          {
            blank2 += answer.substring(i,i+1);
          }
          else
          //adds blaks if the other too conditions are not met
          {
            blank2 += "_";
          }
        }
      }
      else if(!(answer.contains(guess)))
      {
        System.out.println("Thats not in the statement!\n");
        for(int i = 0; i < blank.length(); i++)
        {
          if(answer.substring(i,i+1).contains(guess))
          {
           blank2 += guess;
          }
          else if(gLetter.contains(answer.substring(i,i+1)))
          {
            blank2 += answer.substring(i,i+1);
          }
          else
          {
            blank2 += "_";
          }
        }
        if(Player2 == false)
        {
          System.out.println("It's " + PlayerTwo.GetName() + " Turn");
          Player2 = true;
          Player1 = false;
        }
        else 
        {
          System.out.println("It's " + PlayerOne.GetName() + " Turn");
          Player2 = false;
          Player1 = true;
        }

      }
      System.out.println(blank2);

    }
    if(blank2.equals(answer))
    {
      if(Player1S > Player2S)
      {
        System.out.println(PlayerOne.GetName() + " Wins!!!");
        System.out.println(PlayerOne.GetName() + " Score: " + PlayerOne.GetScore());
        System.out.println(PlayerTwo.GetName() + " Score: " + PlayerTwo.GetScore());
      }
      else if(Player1S < Player2S)
      {
        System.out.println(PlayerTwo.GetName() + " Wins!!!");
        System.out.println(PlayerOne.GetName() + " Score: " + PlayerOne.GetScore());
        System.out.println(PlayerTwo.GetName() + " Score: " + PlayerTwo.GetScore());
      }
      else
      {
        System.out.println("No one wins... ");
        System.out.println(PlayerOne.GetName() + " Score: " + PlayerOne.GetScore());
        System.out.println(PlayerTwo.GetName() + " Score: " + PlayerTwo.GetScore());
      }
    }
    return(blank2);
  }
}