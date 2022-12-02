public class TheFunny {
    public static void main(String[] args)
    {


    int[] numbers = {1,2,3,4,5,6,7,8};
    String[] names = {"Alex", "David", "Andrew",};
    double[] doubles = {1.2, 2.3, 0.1, 0.8,};
    
    for(int x = 0; x < numbers.length ; x++)
    {
        System.out.println(numbers[x]);
    }
    int index = 0;
    while (index < names.length)
    {
        System.out.println(names[index]);
        index++;
    }
    for(double y: doubles)
    {
        System.out.println(y);
    }
}  
}

