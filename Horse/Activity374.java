package Horse;

import java.util.ArrayList;

public class Activity374 {
    private static final String Indexof = null;

    public static void main(String[] args)
    {
        int[] randNums = RandomPermutation.next(10);
       
        //System.out.println(java.util.Arrays.toString(randNums));
      
        ArrayList<String> HorseList = new ArrayList<String>();
        HorseList.add("Molly");
        HorseList.add("Juan");
        HorseList.add("Steve");
        HorseList.add("Joe");
        HorseList.add("Sally");
        HorseList.add("John");
        HorseList.add("Holly");
        HorseList.add("Quandale");
        HorseList.add("Harley");
        HorseList.add("Jim");

      
        ArrayList<String> NewHorseList = new ArrayList<String>();

        for(int i = 0; i < 10; i++)
        {
            NewHorseList.add(HorseList.get(randNums[i]-1));
        }
        
        System.out.println("");
        System.out.println("List of Horses");
        System.out.println("_____________________________");
        System.out.println("");
        for(String x: NewHorseList)
        {
          System.out.print(x + ", ");
        }
        System.out.println("");
        System.out.println("_____________________________");
        System.out.println("");
        for(int i = 0; i < randNums.length; i++)
        {
            if( NewHorseList.size() > 1)
            {
                int Random = (int)(Math.random()*NewHorseList.size());
                int SRandom = (int)(Math.random()*NewHorseList.size());
                while (Random == SRandom)
                {
                    SRandom = (int)(Math.random()*NewHorseList.size());
                }
                //System.out.println("r1 " + Random + " | r2 " + SRandom);
                System.out.println(NewHorseList.get(Random) + " and " + NewHorseList.get(SRandom) + " are a pair");
                System.out.println("________________________________");
                System.out.println("");
                i++;
  
                NewHorseList.remove(NewHorseList.get(Random));            
                if(SRandom > 0)
                {
                    if(Random > SRandom)
                    {
                        NewHorseList.remove(NewHorseList.get(SRandom));
                    }
                    else
                    {
                        NewHorseList.remove(NewHorseList.get(SRandom-1));
                    }
                }
                
                else
                {
                    NewHorseList.remove(NewHorseList.get(SRandom));
                }

                //for(String x: NewHorseList)
               // {
               //   System.out.print(x + " ");
               // }
               // System.out.println("");

            }
            else
            {
                System.out.println(NewHorseList.get(0)+ " is alone");
            }

        }

        
    }
    
}
