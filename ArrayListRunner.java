import java.util.ArrayList;

public class ArrayListRunner {
    public static void main(String[] args)
    {
        ArrayList<Person> People= new ArrayList<Person>();
        People.add(new Person("Alex", 6.1, 160));
        
        System.out.println(People.toString());
        
    }
}
