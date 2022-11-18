import java.util.Scanner;
import java.io.File;
public class Runner {
    public static void main(String[] args)
    {
                Scanner sc = new Scanner(System.in);
        System.out.println("Whats player one's name? ");
        String P1Name = sc.nextLine();
        Player PlayerOne = new Player(P1Name);
        System.out.println("Whats player two's name? ");
        String P2Name = sc.nextLine();
        Player PlayerTwo = new Player(P2Name);
        Board NewBoard = new Board(PlayerOne, PlayerTwo);
        NewBoard.Guesses();
    }
}
