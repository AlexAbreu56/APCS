import java.util.Scanner;
public class Game {
    private int pieces;
    private int take;
    private boolean test;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Scanner sc = new Scanner(System.in);

    //Sets up the game with a random amount of pieces between 10 and 50
    //Sets up the players so they can be accessed
    public Game(Player p1, Player p2){
        double x = (Math.random()*50)+10;//To Do: Grab a random value between 10 and 50
        pieces = (int)x;
        this.p1 = p1;
        this.p2 = p2;
    }

    //Allows a player to take a specific amount of pieces.
    //Adds the amount of pieces taken to the user's score.
    public int takePiece()
    {
        System.out.println("There are "+ pieces+" remaining!");
        System.out.println("-----------------------");
        System.out.println("How many do you want");
        String take = sc.nextLine();
        int nTake = Integer.parseInt(take);


        
       //TO DO: Grab the user amount of pieces and repeat if it not allowed.
        while (!isLegal(nTake)){
            takePiece();
        }
        //TO DO: Adjust the pieces
        pieces -= nTake;
        currentPlayer.adjustScore(nTake);
        System.out.println(currentPlayer.getName() + " took " + nTake + " pieces.");
        System.out.println("-----------------------");
        return nTake;
    }

    
    //**TO DO**//
    public Player getNextPlayer(){
    //Changes which players turn it is and returns the current player.
        if(currentPlayer == p1)
        {
            currentPlayer = p2;
            System.out.println("It's " + p2.getName() + "'s turn.");
        }
        else
        {
            currentPlayer = p1;
            System.out.println("It's " + p1.getName() + "'s turn.");
        }
        return currentPlayer;
    }

    //Checks whether or not the user's requested move is allowed or not.
    public boolean isLegal(int x){
        int nTake = x;
        if (nTake == 1)
        {
            test = true;
        }
        else if(nTake > Math.round(pieces/2))
        {
            System.out.println("You cant take that many!");
            System.out.println("-----------------------");
            test = false;
        }
        else if(nTake <= Math.round(pieces/2))
        {
            test = true;
        }
        else
        {
            test = false;
        }
        return test;// Change appropriately
    }


    //DO NOT CHANGE
    public boolean isComplete(){

        if (pieces == 0){ return true;}
        return false;
    }

    //DO NOT CHANGE
    public void setFirstPlayer(Player p){
        currentPlayer = p;
    }
}
