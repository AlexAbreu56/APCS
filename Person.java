public class Person {
    private String name;
    private double height;
    private int weight;
    public Person(String n, double h, int w)
    {
        name = n;
        height = h;
        weight = w;
    }
    public String toString()
    {
        return(name + " " + height + " " + weight);
    }
}
