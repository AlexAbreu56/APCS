
import java.util.ArrayList;

public class ArrayListExample
{  
   public static void main(String args[])
   {  
      ArrayList<String> animalList = new ArrayList<String>();  
      animalList.add("Dog");
      animalList.add("Cat");
      animalList.add("Rabbit");
      animalList.add("Frog");
      animalList.add("Snake");
      animalList.add("Horse");
      animalList.add("Cow");
      
      // isplaying elements
      System.out.println(animalList);
      
      animalList.add("Bird");
      System.out.println(animalList.get(1) + "," + animalList.get(4) + "," + animalList.get(6));
      animalList.remove(3);
      System.out.println(animalList.size());
      
      // display elements
      System.out.println(animalList);


   }  
}

