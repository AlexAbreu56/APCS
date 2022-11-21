package Nim;


import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //Asks the user to input thier name for the player
        System.out.println("What is Player One's name?: ");
        String P1Name = sc.nextLine();
        Player p1 = new Player(P1Name);

        //Asks the user to input their name for the player.
        System.out.println("What is Player Two's name?: ");
        String P2Name = sc.nextLine();
        Player p2 = new Player(P2Name);

        String again = "Literally any string";
        Player currentPlayer;
        
        //Runs the game
        while (!again.equals("q")){
            //Generates the game
            //TO DO: Create "game"
            Game game = new Game(p1, p2);

            //TO DO: Set the a random player as the current player

            double x = (Math.random()*2);
            int IntValue = (int)x;
            if(IntValue == 0)
            {
                currentPlayer = p1;
                
            }
            else 
            {
                currentPlayer = p2;
            }

            game.setFirstPlayer(currentPlayer);
            //This is the loop in which the game will be played
            while(!game.isComplete()){
                game.takePiece();
                currentPlayer = game.getNextPlayer();
            }
            System.out.println(currentPlayer.getName()+ " Won!!");
            System.out.println(p1.getName() +" had removed "+ p1.getScore()+" pieces!");
            System.out.println(p2.getName() +" had removed "+ p2.getScore()+" pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = sc.nextLine();
        }
        System.out.println("Thank you for playing!");
    }
}
