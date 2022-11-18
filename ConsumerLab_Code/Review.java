import java.util.Scanner;

import javax.management.StandardEmitterMBean;

import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.Arrays;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  public static void main(String[] args){
    System.out.println(starRating("/workspace/APCS/ConsumerLab_Code/SimpleReview.txt"));
    System.out.println(totalSentiment("/workspace/APCS/ConsumerLab_Code/SimpleReview.txt"));
    System.out.println(fakeReview("/workspace/APCS/ConsumerLab_Code/SimpleReview.txt"));
  }
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  
  private static final String SPACE = " ";
  static{
    try {
      Scanner input = new Scanner(new File("/workspace/APCS/ConsumerLab_Code/cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("/workspace/APCS/ConsumerLab_Code/positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("/workspace/APCS/ConsumerLab_Code/negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

      /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
 
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }
  public static double totalSentiment( String filename )
  {
    double sum = 0;
    String x = Review.textToString(filename);
    String [] y = x.split(" ");
    ArrayList<String> strList = new ArrayList<String>(Arrays.asList(y));
    for(int i = 0; i < strList.size(); i ++){
      sum += sentimentVal(strList.get(i));
    }
    return(sum);
  }
  public static int starRating(String filename)
  {
    int star = 0;
    double sVal = totalSentiment(filename);
    if(sVal >= 10)
    {
      star = 5;
    }
    else if(sVal >= 8)
    {
      star = 4;
    }
    else if(sVal >= 6)
    {
      star = 3;
    }
    else if(sVal >=4)
    {
      star = 2;
    }
    else if(sVal >=2)
    {
      star = 1;
    }
    else
    {
      star = 1;
    }
    return (star);
  }
  public static String fakeReview(String filename)
  {
    String x = textToString(filename);
    String [] y = x.split(" ");
    String ns = "";
    ArrayList<String> strList = new ArrayList<String>(Arrays.asList(y));
    for(int i = 0; i < strList.size(); i ++){
      if(strList.get(i).contains("*"))
      {
        ns+=randomAdjective() + " ";
      }
      else
      {
        ns += strList.get(i) + " ";
      }
    }
    return(ns);
  }
}

