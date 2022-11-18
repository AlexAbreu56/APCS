public class Player 
{
    private String pName;
    private int score;
    public Player(String name)
    {
        pName = name;
        score = 0;
    }
    public String GetName()
    {
        return(pName);
    }
    public int GetScore()
    {
        return(score);
    }
    public int setScore(int Num)
    {
        score = score + Num;
        return(score);
    }
}
