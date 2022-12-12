public class FRQ {
    private static int[] itemsSold = {48, 50 ,37 ,62, 38, 70, 55, 37, 64, 60};
    private static double[] wages; 
    public static void main(String[] args)
    {
        FRQ.computeBonusThreshold();
        FRQ.computeWages(10.0, 1.5);
    }
    public static double computeBonusThreshold()
    {
        double sum = 0;
        double min = 20000;
        double max = 0;
        double avg = 0;

        for (int i = 0; i < itemsSold.length; i++)
        {
            sum += itemsSold[i];
            if(itemsSold[i] > max)
            {
                max = itemsSold[i];
            }
            if(itemsSold[i] < min)
            {
                min = itemsSold[i];
            }
        }
        avg = (sum-(min+max))/(itemsSold.length-2);
        System.out.println(avg);

        return(avg);
    }

    public void computeWages(double fixedWage, double perItemWage)
    {
        double wage;
        double fWage = fixedWage;
        double pIWage = perItemWage;
        for (int i = 0; i < itemsSold.length; i++)
        {
            if(itemsSold[i] >= computeBonusThreshold())
            {
                wage = ((fWage + pIWage) * itemsSold[i]) * 1.1;
            }
            else
            {
                wage = ((fWage + pIWage)* itemsSold[i]);
            }
        }
    }
    // Other instance variables, constructors, and methods not shown.
    
}
