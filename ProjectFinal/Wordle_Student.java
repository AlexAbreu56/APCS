
package ProjectFinal;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Wordle_Student{
//* DO NOT CHANGE*/
    private String loadPhrase() {
    String tempPhrase = "";

    int numOfLines = 0;
    tempPhrase = "how are you";

    try {

      Scanner sc = new Scanner(new File(/* Replace with the path */"/workspace/APCS/ProjectFinal/Words.txt"));
      while (sc.hasNextLine()) {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing phrases.txt");
    }

    int randomInt = (int) ((Math.random() * numOfLines) + 1);

    try {
      int count = 0;
      Scanner sc = new Scanner(new File(/* Replace with the path */"/workspace/APCS/ProjectFinal/Words.txt"));
      while (sc.hasNextLine()) {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt) {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing phrases.txt");
    }
    return tempPhrase;
  }
//* DO NOT CHANGE */
  public String[] bPhrase(String i) {
    String Phrase = i;

    String[] bPhrase = Phrase.split("(?!^)");

    for (int x = 0; x < bPhrase.length; x++) {
      bPhrase[x] = "_";
    }
    return (bPhrase);
  }

  public String[] Guess() {
    //Sets up our variables, first is the scanner and a String that holds the wordle 
    Scanner sc = new Scanner(System.in);
    String tempA = loadPhrase();
    //* create a string array with the split method*/
    /*"(?!^)" splits the string every character*/
    String[] answer = tempA.split("(?!^)");
    //*plug in the string that holds the worlde into the bPhrase method to make a second string array */
    String[] bAnswer = bPhrase(tempA);
    //*sets up an ArrayList*/
    
    /*Your Code Here */

    //*Sets up a boolean we use later with a while loop*/
    boolean win = false;
    //*initalize the string array guess variable*/
    String[] guess = {};
    /*sets up the number of guess possible variable */
    int gc = 5;
    //*Adds the whole alphebet to the ArrayList */

    /*Your Code Here */

    //* while loop keeps the game running*/
    while (win == false) {
      //*Set up the count, this will be used to check how many correct letters are in the word*/
      int count = 0;
      //*Prints out the Blank worldle */
      System.out.print("\n");
      System.out.print("The worlde is " + bAnswer.length + " letters long...");
      System.out.print("\n");
      /*Prints out the number of guesses the user have left*/
      System.out.println("Number of guess left: " + gc);
      //*Prints out the Arraylist */
      System.out.println("\n");

      /*Your Code Here */

      System.out.println("\n");
      //*Prompts the user for a guess */
      System.out.println("What word will you guess?\n");
      String tempG = sc.nextLine();
      //*Turns the user input into all lowercase */
      String G = tempG.toLowerCase();
      //*Splits the User input into an array using the guess array*/
      guess = G.split("(?!^)");
      /*Checks if the guess is the same length of the answer */
      if (guess.length == answer.length){
        /*a for loop that goes through each letter in the answer */
        for (int i = 0; i < answer.length; i++) { 
          /*a loop that goes through the arraylist*/
          
            /*Your Code Here */

            /*Checks if the guess letter is in the arraylist */

            /*Your Code Here */ {

              /*Checks if the letter in the guess is equal to the letter in the answer */
              if (guess[i].equalsIgnoreCase((answer[i]))) {
                /*This changes the color of the letter to green */
                guess[i] = "\033[32m" + guess[i] + "\033[0m";
                /*This checks if the actual letter guess excluding the color code is in the arraylist */

                if /*Your Code Here */{

                  /*If it is it will set the corresponding letter to the letter with the color code. */

                  /*Your Code Here */
                } 
              }
              /*a for loop that goes through the answer and checks if one letter is in the the answer at all*/
              for (int y = 0; y < answer.length; y++) {
                if (guess[i].equalsIgnoreCase((answer[y]))) {
                  /*Changes the color to yellow */
                  guess[i] = "\033[33m" + guess[i] + "\033[0m";
                  /*This checks if the actual letter guess excluding the color code is in the arraylist */

                  if /*Your Code Here */ {

                    /*If it is it will set the corresponding letter to the letter with the color code. */

                    /*Your Code Here */

                  } 
                }
              }
              /*Checks if the letter in the guess is not equal to the letter in the answer */
              if (!(guess[i].equalsIgnoreCase((answer[i])))) {
                /*Changes the color to red */
                guess[i] = "\033[31m" + guess[i] + "\033[0m";
                /*This checks if the actual letter guess excluding the color code is in the arraylist */

                if/*Your Code Here */{

                  /*Checks if this is the first time the letter was guessed wrong */

                  if/*Your Code Here */{

                    /*If it is it will set the corresponding letter to the letter with the color code. */

                    /*Your Code Here */
                  }
                  /*Checks if the letter is equal to "m" then it sets m to red, this is needed as m is in all color codes so if this isnt here it will override other letters */
                  if(guess[i].substring(5,6).equals("m")){
                    /*If it is it will set m to red*/

                    /*Your Code Here */
                    
                  }
                } 
              }
            }
          }
        }
        /*For loop that goes through the length of the guess/answer and checks if the guess letters contain the green color code */
        for (int i = 0; i < answer.length; i++) {
          if (guess[i].contains("\033[32m")) {
            /*if it does it adds to the count */
            count++;
          }
        }
        /*if the count is equal to the answer length or guess length */
        if (count == answer.length) {
          /*ends the game */
          win = true;
        }
        /*Prints out the the guess with the colors  */
        System.out.println("________________________");
        System.out.print("\n");
        for (String y : guess) {
          System.out.print(y);
        }
        System.out.print("\n");
        System.out.println("________________________");
        /*If the guess is valid the number of guesses you have goes down */
        gc--;
        /*Gets you out of the loop if you run out of guesses */
        if (gc == 0){
          win = true;
        }
      }
      /*if they dont enter something with the same length as the guess it prints an error statment*/
      else
      {
        System.out.println("\n");
        System.out.println("Please type in something valid.");
      }
    }
    /*When you get out of the while loop you get a victory message or lose message*/
    if(gc > 0){
      System.out.print("\n");
      System.out.println("Congrats, You won!!");
    }
    else{
      System.out.print("\n");
      System.out.println("You lose!");
    }
    /*Returns the guesss array */
    return (guess);
  }
}
