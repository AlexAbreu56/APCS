public class SAA {
    public static void main(String[] args)
    {
      int[] goals = {1, 2, 0, 3, 2, 4, 2, 1, 0, 2, 0, 1, 3, 2};
      int[] goalCounter = new int[10];
      for(int g: goals)
      {
        goalCounter[g]++;
        
      }
      double sum = 0;
      int max = 0;
      int min = 0;
      int mode = 0;
      double avg = 0;

      for (int i = 0; i < goals.length; i++)
      {
        sum += goals[i];
        if(goals[i] > max)
        {
            max = goals[i];
        }
        if(goals[i] < min)
        {
            min = goals[i];
        }
      avg = sum/goals.length;
      
      }
      System.out.println("All goals: " + sum);
      System.out.println("Avg: " + avg);
      System.out.println("Max: " + max);
      System.out.println("Min: " + min);
      System.out.println("Mode: " + mode);
    }
}
